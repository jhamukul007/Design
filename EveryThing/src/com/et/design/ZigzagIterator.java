package com.et.design;

import java.util.List;

public class ZigzagIterator {
	  Node head;
	    Node current;
	    
	    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	          int i=0;                                                                                                             int size=v1.size()>v2.size()?v1.size():v2.size();
	          while(i<size){
	              if(i<v1.size())
	                  create(v1.get(i));
	              if(i<v2.size())
	                   create(v2.get(i));
	              i++;
	          }
	    }
	    
	    private void create(int data){
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
	    public int next() {
	        int data=0;
	        if(head!=null){
	            data=head.data;
	            head=head.next;
	        }
	        return data;
	    }

	    public boolean hasNext() {
	        return head!=null;
	    }
	}
