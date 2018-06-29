package example6;

import java.util.*;

public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> o1 = Optional.of("Hello");
		System.out.println(o1.get());
		System.out.println(o1.isPresent());
		o1.ifPresent(t->System.out.println(t));
		
		Optional<String> o2 = Optional.empty();
		// NoSuchElementException
		// System.out.println(o2.get());
		
		// NullPointerException
		// Optional<String> o3 = Optional.of(null);
		
		Optional<String> o4 = Optional.ofNullable(null);
		System.out.println(o4.orElse("비었어요 "));
		System.out.println(o4.orElseThrow(()->new IllegalArgumentException("없어 없어")));
	}
}
