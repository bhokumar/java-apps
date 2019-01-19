package org.axway.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class WithoutLambdaWithStream {
	public static void main(String args[]) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Stream<Integer> stream = list.stream();
		Function<Integer, Integer> function = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {

				return t * 2;
			}
		};
		Stream<Integer> doubledStream = stream.map(function);

		Predicate<Integer> predicate = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				if (t % 2 == 0) {
					return true;
				}
				return false;
			}
		};
		Stream<Integer> filteredStream = doubledStream.filter(predicate);

		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer c, Integer e) {
				return c + e;
			}
		};
		
		System.out.println(filteredStream.reduce(0,binaryOperator));
		
	}
}
