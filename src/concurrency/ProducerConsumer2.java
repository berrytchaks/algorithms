package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadFactory {
	List<String> list = new ArrayList<>();
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();
	final int CAPACITY = 10;

	public int i = 0;

	class Producer extends Thread {

		@Override
		public void run() {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void produce() throws InterruptedException {
		System.out.println("Starting thread " + Thread.currentThread().getName());
		while (true) {
			lock.lock();
			try {
				while (list.size() == CAPACITY) {
					System.out.println("List is full to its CAPACITY, producer waiting");
					notFull.await();
				}
				if (i == CAPACITY) i=0;
				String str = "Data " + i++;
				System.out.println("Putting " + str + " to list of size "+list.size());
				list.add(str);
				if (list.size() ==1 )
					notEmpty.signal();
			} finally {
				lock.unlock();
				Thread.sleep(500);
			}
		}
	}

	private void consume() throws InterruptedException {
		System.out.println("Starting thread " + Thread.currentThread().getName());
		while (true) {
			lock.lock();
			try {
				while (list.size() == 0) {
					System.out.println("List is empty, consumer waiting");
					notEmpty.await();
				}
				String str = list.remove(list.size() - 1);
				System.out.println("Popping " + str + " from list of size "+list.size());
				if (list.size() ==CAPACITY-1 )
					notFull.signal();
			} finally {
				lock.unlock();
			}
		}
	}

	public ThreadFactory(List<String> l ){
		this.list = l;
		Thread p= new Producer();
		p.setName("Producer");
		p.start();
		Thread c=new Consumer();
		c.setName("Consumer");
		c.start();
	}
}

public class ProducerConsumer2 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		ThreadFactory p = new ThreadFactory(l);
//		BoundedBuffer b = new BoundedBuffer(0, 0, 0);
	}
}

class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	public BoundedBuffer(int count, int putptr, int takeptr) {
		this.count = 0;
		this.putptr = putptr;
		this.putptr = putptr;
		new Producer().start();
		new Producer().start();
		new Consumer().start();
		new Consumer().start();
	}

	final Object[] items = new Object[10];
	int putptr, takeptr, count;

	class Producer extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					put("Object");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length){
				System.out.println("Buffer full producer sleeps");
				notFull.await();
			}
			items[putptr] = x;
			System.out.println("Producer: " + putptr);
			if (++putptr == items.length)
				putptr = 0;
			++count;
			if(count == 1){
				System.out.println("An item present awake consumer");
				notEmpty.signal();
			}
		} finally {
			lock.unlock();
			Thread.sleep(500);
		}
	}

	public Object take() throws InterruptedException {

		lock.lock();
		try {
			while (count == 0) {
				System.out.println("Buffer empty consumer sleeps");
				notEmpty.await();
			}
			Object x = items[takeptr];
			System.out.println("Consumer: " + takeptr);
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			if(count == items.length-1){
				System.out.println("Cell empty awake producer");
				notFull.signal();
			}
			return x;
		} finally {
			lock.unlock();
		}
	}

}
