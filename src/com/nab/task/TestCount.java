package com.nab.task;

class Count {
	private int count = 0;
	
	public synchronized void setCount(int count) {
		this.count = count;
	}
	public synchronized int getCount() {
		return count;
	}
}

class CountRunner extends Thread {
	Count count;
	
	public CountRunner(Count count) {
		this.count = count;
	}
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			count.setCount(count.getCount() + 1);
		}
	}
}

public class TestCount {
	public static void main(String[] args) throws Exception {
		Count count = new Count();
		CountRunner runnerA = new CountRunner(count);
		CountRunner runnerB = new CountRunner(count);
		runnerA.start();
		runnerB.start();
		runnerA.join();
		runnerB.join();
		System.out.println("count.getCount = " + count.getCount());
	}
}
