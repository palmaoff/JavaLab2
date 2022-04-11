public class Calculator {

	public static boolean IsValid(String str) {

		return true;
	}

	public static String RemoveWhiteSpaces(String str) {
		String result = str.replace(" ", "");

		return result;
	}

	public static String ToRPN(String str) {
		String result = "";

		// code here

		return result;
	}

	public static double Calculate(String str) {

		return 0;
	}

	private int SetPriority(char c) {
		switch (c) {
			case ('*'):
				return 3;
			case ('/'):
				return 3;
			case ('+'):
				return 2;
			case ('-'):
				return 2;
			case ('('):
				return 1;
			case (')'):
				return -1;
			default:
				return 0;
		}
	}

}
