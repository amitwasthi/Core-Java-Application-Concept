package com.infotech;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class MyRunnable implements Runnable{
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " = run()");
        try {
               Thread.sleep(1000);
        } catch (InterruptedException e) {
               e.printStackTrace();
        }
	}
}

class MyThreadFactory implements ThreadFactory{
	public Thread newThread(Runnable r) {
        return new Thread(r, "Thread 1"); //Give custom name to thread
  }
}



public class GiveNameToExecutorFrameworkThreads {
	public static void main(String[] args) {
		Executors.newSingleThreadExecutor(new MyThreadFactory()).submit(new MyRunnable());
	}

}
