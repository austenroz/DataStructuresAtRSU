/**
 * 
 * @author Austen
 *
 * Description: Node used to store data in a chain. Used with the Bag class to store as many numbers as necessary.
 */

public class Node<T> {
	
	private T data;
	@SuppressWarnings("rawtypes")
	private Node nextNode = null;
	
	Node(T data)
	{
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@SuppressWarnings("rawtypes")
	public Node getNextNode() {
		return nextNode;
	}

	@SuppressWarnings("rawtypes")
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}
