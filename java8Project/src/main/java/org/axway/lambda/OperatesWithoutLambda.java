package org.axway.lambda;

public class OperatesWithoutLambda {
	private static Operation add = new Operation() {

		@Override
		public int operate(int a, int b) {
			return a + b;
		}
	};

	private static Operation multiply = new Operation() {

		@Override
		public int operate(int a, int b) {
			return a * b;
		}
	};
	
	public static  int operations(int a, int b, Operation operation){
		return operation.operate(a, b);
	}
	
	public static void main(String args[]) {
		System.out.println(operations(10, 20, add));
		System.out.println(operations(10, 20, multiply));
	}
}

