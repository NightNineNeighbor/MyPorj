package example3;

import java.util.*;

// 비동기적인 작업 @Async
class SampleJob implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class ThreadTest1 {
	public static void main(String[] args) {
		Thread t = new Thread(new SampleJob());
		t.start();
		for(int i=0; i<10; i++) {
			System.out.println("나 살아 있어요 ");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
