package example3;

import java.util.*;

public class ThreadTest2 {
	public static void main(String[] args) {
		new Thread(()-> {
			for(int i=0; i<10; i++) {
				System.out.println(new Date());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		Runnable runnable = ()->{
			for(int i=0; i<10; i++) {
				System.out.println("나 살아 있어요 ");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(runnable).start();
	}
}
