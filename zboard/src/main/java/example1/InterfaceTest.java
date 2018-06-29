package example1;

public class InterfaceTest {
	public static void main(String[] args) {
		NoParamNoReturn n1 = ()->System.out.println("Hello Lambda");
		n1.execute();
	}
}
