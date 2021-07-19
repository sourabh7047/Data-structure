package DSA.Graph;

public class Node<K, E> {
	
	private K key = null;
	
	private K endNode = null;
	
	private E edgeLabel = null;

	public Node(K key, K endNode, E edgeLabel) {
		this.key = key;
		this.endNode = endNode;
		this.edgeLabel = edgeLabel;
	}

	@Override
	public boolean equals(Object node1) {
		return key.equals(node1);
	}
	
	@Override
	public int hashCode() {
		return key.hashCode();
	}
	
	public String toString() {
		return "{ key: " + key + " , endNode: "+ endNode + ", edgeLabel: " + edgeLabel + " }";
	}
}
