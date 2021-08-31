package com.et.design;

import java.util.Arrays;
import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>{

	Node head; 
    Node current;
	public PeekingIterator(Iterator<Integer> iterator) {
        while(iterator.hasNext()){
            createNode(iterator.next());
        }
	}
	
    private void createNode(int data){
       if(head==null){
        head=new Node(data);
        current=head;
       }
        else{
            Node nextNode=new Node(data);
            current.next=nextNode;
            current=current.next;
        }
    }
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return head!=null?head.data:-1;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(head!=null){
            int data=head.data;
            head=head.next;
            return data;
        }
        return -1;
	}
	
	@Override
	public boolean hasNext() {
	    return head!=null;
	}
	
	public static void main(String[] args) {
		String[] commands={"PeekingIterator","next","peek","next","next","hasNext"};
		Object[] values= {new Integer[] {1,2,3}};
		int i=0;
		PeekingIterator obj=null;
		while(i<commands.length) {
			switch (commands[i]) {
				case "PeekingIterator": {
					Integer[] arr=(Integer[])values[i];
					Iterator<Integer> itr=Arrays.asList(arr).iterator();
					obj=new PeekingIterator(itr);
					break;
				}
				case "next":{
					int data= obj.next();
					System.out.println(data);
					break;
				}
				case "peek":{
					int data= obj.peek();
					System.out.println(data);
					break;
				}
				case "hasNext":{
					boolean hasNext=obj.hasNext();
					System.out.println(hasNext);
					break;
				}
			}
			i++;
		}
	}
}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}
