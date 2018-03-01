public class Node {

	Object value;
	Node next;

	public Node(Object value) {
		this(value, null);
	}

	public Node(Object value, Node next) {
		this.value = value;
		this.next = next;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
