import java.io.Serializable;

/**
 * 
 * @author Austen
 *
 * Description: Node used to store data in a chain. Used with the Bag class to store as many numbers as necessary.
 */
import java.io.Serializable;

public class Node implements Serializable{
	
	private Task data;
	@SuppressWarnings("rawtypes")
	private Node nextNode = null;
	
	Node(Task data)
	{
		this.data = data;
	}

	public Task getData() {
		return data;
	}

	public void setData(Task data) {
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
