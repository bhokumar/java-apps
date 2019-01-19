package org.axway.lambda;

public class OperatesWithLambda {

	private static Operation add = (a, b) -> (a + b);

	private static Operation multiply = (a, b) -> (a * b);

	public static int operations(int a, int b, Operation operation) {
		return operation.operate(a, b);
	}

	public static void main(String args[]) {
		System.out.println(operations(10, 20, add));
		System.out.println(operations(10, 20, multiply));
	}
}
