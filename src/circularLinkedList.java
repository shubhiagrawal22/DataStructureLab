import java.util.NoSuchElementException;

public class circularLinkedList {
	private ListNode last;
	private int length;
	private class ListNode{
		private ListNode next;
		private int data;

		public ListNode(int data){
			this.data = data;
		}
	}
	public circularLinkedList(){
		last = null;
		length = 0;
	}
	public boolean isEmpty(){
		return length == 0;
	}
	public void createCircularLinkedList(){
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);

		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;

		last = fourth;
	}
	public void insertAtStart(int data){
		ListNode temp = new ListNode(data);
		if(last == null){
			last = temp;
		}
		else{
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}

	public void insertAtEnd(int data){
		ListNode temp = new ListNode(data);
		if(last == null){
			last = temp;
			last.next = last;
		}
		else{
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}

		length++;
	}

	public ListNode delete(){
		if(isEmpty()){
			throw new NoSuchElementException("Circular Singly Linked List is already empty");
		}
		ListNode temp = last.next;
		if(last.next == last){
			last = null;
		}
		else{
			last.next = temp.next;
		}
		temp.next = null;
		length--;
		return temp;
	}

	public void display(){
		if(last ==null){
			return;
		}
		ListNode first = last.next;
		while (first != last){
			System.out.print(first.data + "-->");
			first = first.next;
		}
		System.out.println(first.data);
	}

	public static void main(String[] args) {
		circularLinkedList cll = new circularLinkedList();
		//cll.createCircularLinkedList();

		//cll.insertAtStart(1);
		//cll.insertAtStart(3);
		//cll.insertAtStart(5);
		//cll.insertAtStart(7);

		cll.insertAtEnd(1);
		cll.insertAtEnd(3);
		cll.insertAtEnd(5);
		cll.insertAtEnd(7);

		cll.delete();

		cll.display();
	}

}
