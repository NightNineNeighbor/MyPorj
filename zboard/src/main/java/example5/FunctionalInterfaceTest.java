package example5;

import java.util.function.*;


public class FunctionalInterfaceTest {
	public static void main(String[] args) {
		Consumer<String> c = t->System.out.println(t+"입니다");
		c.accept("홍길동");
		
		Supplier<Integer> supplier = ()->{
			return (int)(Math.random()*101);
		};
		System.out.println(supplier.get());
		
		BinaryOperator<Integer> operator = (a,b)-> {
			return a>b? a : b;
		};
		System.out.println(operator.apply(10, 20));
		System.out.println(operator.apply(300, 20));
	}
}
