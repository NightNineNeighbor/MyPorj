package example2;

public class InterfaceTest {
	public static void main(String[] args) {
		NoParamReturn f1 = ()->{
			int num = (int) (Math.random()*101);
			return num;
		};
		int num1 = f1.execute();
		System.out.println(num1);
		int num2 = f1.execute();
		System.out.println(num2);
	}
}
