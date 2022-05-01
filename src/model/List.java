package model;


public class List {

private Node head;
	
    public int size;
	public void addFirst(int value) {
		Node node = new Node(value);
		addFirst(node);
	}

	private void addFirst (Node node) {
		if(head==null) {
			head=node;
			head.setNext(head);
			head.setPrev(head);
		}else {
			
			Node tail=head.getPrev();
			tail.setNext(node);
			node.setPrev(tail);
			node.setNext(head);
			head.setPrev(node);
			head=node;
		}
	}
	public void addLast(int value) {
		Node node =new Node(value);
	    addLast(node);	
	}
	private void addLast(Node node) {
		if(head==null) {
			head=node;
			head.setNext(head);
			head.setPrev(head);
			size++;
		}else {
			
			head.getPrev().setNext(node);
			node.setNext(head);
			node.setPrev(head.getPrev());
			head.setPrev(node);
            size++;
		}
	}
	public void print() {
		print(head);
	}
	private void print(Node node) {
		if(node.getNext()==head) {
			System.out.println(node.getValue());
			return;
		}
		System.out.println(node.getValue());
		print(node.getNext());
	}
	public void printj() {
		printj(head);
	}
	private void printj(Node current) {
		if(current.getNext()==head) {
			System.out.println(current.getValue());
			return;
		}
		System.out.println(current.getValue());
		printj(current.getNext());
	}
	
	public int turncurrent(int turncurrent) {
		
		return turncurrent(head,turncurrent);
	}
	private int turncurrent(Node current,int turncurrent) {
	    
		turncurrent++;

		if(turncurrent>head.getPrev().getValue()) {
			turncurrent=head.getValue();
		}
		
	    
		return turncurrent;
	}
	public void addCalled(int value) {
		addCalled(head,value);
	}
	private void addCalled(Node current,int value) {
		if(current.getValue()==value) {
			int timecall = current.getTimes();
			timecall++;
			current.setTimes(timecall);
			return;
		}
		if(current.getNext()==head) {
			return;
		}
		addCalled(current.getNext(),value);
	}
	public void verifyCalled() {
		verifyCalled(head);
	}
	private void verifyCalled(Node current) {
		
		if(current.getTimes()==2) {
			delete(current.getValue());
			System.out.println("The Turn "+current.getValue()+" has been removed\n");
			return;
		}
		if(current.getNext()==head) {
			return;
		}
		verifyCalled(current.getNext());
		
	}
	public void delete(int value) {
		delete(head,value);
	}
	private void delete(Node node,int value) {
		
		if(head.getValue()==value) {
			Node last=head.getPrev();
			head=head.getNext();
			head.setPrev(last);
			last.setNext(head);
            
            size--;
            
			return;
		}
		if(node.getValue()==value) {
			node.getPrev().setNext(node.getNext());
		 	node.getNext().setPrev(node.getPrev());
			
			
			size--;
			
			return;
		}
		if(node.getNext()==head) {
			return;
		}
		delete(node.getNext(),value);
	}
}
