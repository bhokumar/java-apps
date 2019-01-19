package org.bhoopendra.app.client;

public class AppClient4 {

	public static void main(String[] args) {

		AppClient4 app = new AppClient4();
		int noOfTries = 0;
		int maxTries = 3;

		int result = app.checkException(noOfTries, maxTries);
		while (result <= 0) {
			result = app.checkException(noOfTries + 1, maxTries);
		}

	}

	private int checkException(int noOfTries, int maxNoTries) {

		try {
			methodDevideByZero();
			return 1;
		} catch (Exception e) {
			if (noOfTries < maxNoTries)
				return 0;
			else
				return 2;
		}
	}

	private void methodDevideByZero() throws Exception {
		throw new Exception("");
	}

}
