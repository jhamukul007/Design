package com.et.design;

import java.util.*;


public class BlockingQueue<T> {
	private Queue<T> queue=new LinkedList<T>();
	private int max_size=10;
	
	public BlockingQueue(int size) {
		this.max_size=size;
	}
	
	public synchronized void enqueue(T t) throws InterruptedException {
		if(t==null)
			throw new IllegalArgumentException("entity can't be bull");
		while(this.queue.size()==this.max_size)
			wait();
		this.queue.add(t);
		notifyAll();
	}
	
	public synchronized T dequeue() throws InterruptedException {
		while(this.queue.size()==0)
			wait();
		notifyAll();
		return queue.poll();
	}
}
