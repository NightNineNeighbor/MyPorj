package example4;

public class FunctionInterfaceTest {
	public static void main(String[] args) {
		Consumer consumer = t->System.out.println(t+"입니다");
		consumer.accept("홍길동");
		
		Supplier supplier = ()->{
			return (int)(Math.random()*101);
		};
		System.out.println(supplier.get());
		
		Operator operator = (a,b)-> {
			return a>b? a : b;
		};
		System.out.println(operator.apply(10, 20));
		System.out.println(operator.apply(300, 20));
	}
}
