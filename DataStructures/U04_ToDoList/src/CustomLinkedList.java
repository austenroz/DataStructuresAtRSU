
import java.io.Serializable;

public class CustomLinkedList implements Serializable
{
	private int currentSize = 0;
	Node firstNode;
	
	/**@return  Returns the currentSize of the bag */
	public int getCurrentSize() {
		return currentSize;
	}
	
	/**@return  Returns true if the bag is empty, false if not */
	public boolean isEmpty() {
		if (currentSize == 0)
			return true;
		else
			return false;
	}

	/**@param newEntry  adds newEntry object to the bag using the Node objects.
	 * @return  Returns true if successful, false if not */
	public boolean add(Task newEntry) {
		Node newNode = new Node(newEntry);
		if (currentSize == 0)
		{
			firstNode = newNode;
			currentSize++;
		}
		else
		{
			int index = 0;
			while ((index < currentSize) && newEntry.compareTo(get(index)) > 0)
			{
				index++;
			}
			
			add(newEntry, index);
		}
		return true;
	}
	
	/**@param newEntry  adds newEntry object to the bag using the Node objects.
	 * @param index  Choose what index to add the new object at.
	 * @return  Returns true if successful, false if not */
	private boolean add(Task newEntry, int index) {
		if (currentSize < index || index < 0)
		{
			if (currentSize < index)
			{
				index = currentSize;
			}
			else
			{
				index = 0;
			}
		}
		
		if (currentSize >= index)
		{
			Node newNode = new Node(newEntry);
			if (index == 0)
			{
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			}
			else
			{
				Node previousNode = null;
				Node currentNode = firstNode;
				for (int i = 0; i < index; i++)
				{
					previousNode = currentNode;
					currentNode = currentNode.getNextNode();
				}
				newNode.setNextNode(currentNode);
				previousNode.setNextNode(newNode);
			}
			currentSize++;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**@param index  index of data entry wanted
	 * @return  gets the data from index specified */
	public Task get(int index)
	{
		Node currentNode = firstNode;
		for (int i = 0; i < index; i++)
		{
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getData();
	}
	
	/**@return  Returns the first item in the list */
	@SuppressWarnings("unchecked")
	public Task remove() {
		if (currentSize > 0)
		{
			Node oldFirstNode = firstNode;
			firstNode = firstNode.getNextNode();
			currentSize--;
			return oldFirstNode.getData();
		}
		else return null;
	}

	/**@param anEntry  removes the anEntry object from the bag if it exists within the bag.
	 * @return  Returns true if the object was removed successfully, false if not. */
	@SuppressWarnings("unchecked")
	public boolean remove(Task anEntry) {
		boolean foundEntry = false;
		Node previousNode = null;
		Node currentNode = firstNode;
		for (int i = 0; i < currentSize && !foundEntry; i++)
		{
			if (currentNode.getData() == anEntry)
			{
				if (i == 0) //First Entry
				{
					firstNode = firstNode.getNextNode();
				}
				else
				{
					previousNode.setNextNode(currentNode.getNextNode());
				}
				foundEntry = true;
				currentSize--;
			}
			else
			{
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
		}
		return foundEntry;
	}
	
	/**@param anEntry  removesTask based on ID.
	 * @return  Returns true if the object was removed successfully, false if not. */
	@SuppressWarnings("unchecked")
	public boolean remove(int taskId) {
		boolean foundEntry = false;
		Node previousNode = null;
		Node currentNode = firstNode;
		for (int i = 0; i < currentSize && !foundEntry; i++)
		{
			if (currentNode.getData().getId() == taskId)
			{
				if (i == 0) //First Entry
				{
					firstNode = firstNode.getNextNode();
				}
				else
				{
					previousNode.setNextNode(currentNode.getNextNode());
				}
				foundEntry = true;
				currentSize--;
			}
			else
			{
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
		}
		return foundEntry;
	}

	/**Clear all items out of the bag */
	public void clear() {
		currentSize = 0;
		firstNode = new Node(null);
	}

	/**@param anEntry  Checks to see if anEntry exists within the bag and how many exist.
	 * @return  returns number of times anEntry was found within the bag. */
	@SuppressWarnings("unchecked")
	public int getFrequencyOf(Task anEntry) {
		int frequency = 0;
		Node currentNode = firstNode;
		for (int i = 0; i < currentSize; i++)
		{
			if (currentNode.getData() == anEntry)
			{
				frequency++;
			}
			else
			{
				currentNode = currentNode.getNextNode();
			}
		}
		return frequency;
	}

	/**@param anEntry  Checks to see if anEntry exists within the bag
	 * @return  Returns true if the object was found, false if not. */
	@SuppressWarnings("unchecked")
	public boolean contains(Task anEntry) {
		boolean foundEntry = false;
		Node currentNode = firstNode;
		for (int i = 0; i < currentSize; i++)
		{
			if (currentNode.getData() == anEntry)
			{
				foundEntry = true;
			}
			else
			{
				currentNode = currentNode.getNextNode();
			}
		}
		return foundEntry;
	}
}
