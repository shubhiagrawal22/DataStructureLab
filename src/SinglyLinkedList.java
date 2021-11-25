//to print a linked list


public class SinglyLinkedList {
	private ListNode head;       //points to head to node
	private static class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data){
			this.data = data;               //constructor
			this.next = null;
		}  //data structure define,declared
	}
	public void display(){
		ListNode current = head;
		while(current != null){
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print("null");
	}

	//to find the length of list

	public int length(){
		if(head == null) return 0;
		int count = 0;
		ListNode current = head;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}

	public static void main(String[] args){
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode fourth = new ListNode(11);
		sll.head.next = second;      //10->1 connect to next node data
		second.next = third;
		third.next = fourth;

		int k = sll.length();
		System.out.println("Length of List : "+ k);
		sll.display();
	}


}
