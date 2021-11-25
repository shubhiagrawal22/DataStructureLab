//performing operations of insertion and deletion on linked list


public class SinglyLinkedList1 {
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

	//add a node at starting of list

	public void insertFirst(int value){
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}

	//insert a node at the end

	public void inserLast(int value){
		ListNode newNode = new ListNode(value);
		if (head == null){
			head = newNode;
			return;
		}
		ListNode current = head;
		while (current.next != null){
			current = current.next;
		}
		current.next = newNode;
	}

	//delete at start

	public ListNode deleteFirst(){
		if(head == null) return null;
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

	//delete at last
	public ListNode deleteLast(){
		if(head == null || head.next == null) return head;
		ListNode current = head;
		ListNode previous = null;
		while (current.next != null){
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
	}
	public void insert(int position,int value){
		ListNode node = new ListNode(value);
		if(position == 1)
		{
			node.next = head;
			head = node;
		}
		else{
			ListNode previous = head;
			int count = 1;
			while(count < position-1){
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			node.next = current;
			previous.next = node;
		}
	}
	public void delete(int position){
		if(position == 1){
			head = head.next;
		}
		else{
			ListNode previous = head;
			int count = 1;
			while(count < position-1){
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
		}
	}

	public static void main(String[] args){
		SinglyLinkedList1 sll = new SinglyLinkedList1();
		//sll.insertFirst(1);
		//sll.insertFirst(11);
		//sll.insertFirst(8);
		//sll.insertFirst(10);

		sll.inserLast(1);
		sll.inserLast(11);
		sll.inserLast(8);
		sll.inserLast(10);

		sll.insert(3,7);
		sll.delete(3);


		int k = sll.length();
		System.out.println("Length of List : "+ k);
		sll.display();
		//System.out.println("\n");
		//System.out.println(sll.delete(3));
		//System.out.println(sll.deleteLast().data);
	}


}

