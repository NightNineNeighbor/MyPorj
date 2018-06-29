package example3;

import java.util.*;

// 동기적인 작업
public class NoThreadTest {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
