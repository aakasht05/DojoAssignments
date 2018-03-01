public class SinglyLinkedList {

	private Node head;

	public SinglyLinkedList() {
		head = null;
	}

	public void add(Object value) {

		Node next = new Node(value);
		Node current = head;

		if (head == null) {
			head = next;
		} else {
			while (current.next != null) {
				current = current.next;
			}

			current.setNext(next);
		}
	}

	public void remove() {

		Node current = head;

		while (current.next != null) {

			if (current.next.next == null) {
				current.setNext(null);
			} else {
				current = current.next;

			}
		}
	}

	public void printValues() {
		Node current = head;

		while (current.next != null) {
			System.out.println(current.value);
			current = current.next;
		}
		System.out.println(current.value);
	}

}
