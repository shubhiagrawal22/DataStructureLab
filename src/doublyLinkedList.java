import java.util.NoSuchElementException;

//structure
public class doublyLinkedList {
	private ListNode head;
	private ListNode tail;
	private int length;
	private class ListNode{
		private int data;
		private ListNode next;
		private ListNode previous;
		public ListNode(int data)
		{
			this.data = data;

		}
	}
	public doublyLinkedList(){
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	public boolean isEmpty(){

		return length ==0;  //or head == null
	}

// how to insert element at beginning of DLL

    public void insertAtStart(int value){
		ListNode newNode = new ListNode(value);
		if(isEmpty()){
			tail = newNode;
		}
		else{
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
    }

    //insert at end

	public void insertAtLast(int value){
		ListNode newNode = new ListNode(value);
		if(isEmpty()){
			head = newNode;
		}
		else{
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;
	}

	//print from head to tail
	public void displayForward(){
		ListNode temp = head;
		while (temp!=null){
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}

	//print from tail to head
	public void displayBackward(){
		if(head == null){
			return;
		}
		ListNode temp = tail;
		while(temp != null){
			System.out.print(temp.data + "->");
			temp = temp.previous;
		}
		System.out.println("null");
	}

	//delete first node

	public ListNode deleteFirst(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		ListNode temp = head;
		if(head == tail){
		    tail = null;
		}
		else{
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;
	}

    public static void main(String[] args){
		doublyLinkedList dll = new doublyLinkedList();
		dll.insertAtStart(1);
		dll.insertAtStart(12);
		dll.insertAtStart(16);

		//dll.insertAtLast(90);
		//dll.insertAtLast(80);

	    dll.deleteFirst();

		dll.displayForward();
		dll.displayBackward();
    }
}
