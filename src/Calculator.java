import java.util.Stack;

public class Calculator {

	// for testing (maybe)
	public static Double solve(String str) {
		String rpn = ToRPN(str);

		if (rpn != "") {
			return Calculate(rpn);
		}

		return 0.0;
	}

	public static String RemoveWhiteSpaces(String str) {
		String result = str.replace(" ", "");

		return result;
	}

	public static boolean IsValid(String str) {
		boolean b = true;
		Stack<Character> stack = new Stack<>();

		// check all symbols
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') continue;
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')')
				continue;
			else {
				b = false;
				break;
			}
		}

		// check bracets
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				stack.push('(');
			} else if (c == ')') {
				if (stack.isEmpty()) {
					b = false;
					break;
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty()) {
			b = false;
		}

		return b;
	}

	private static int GetPriority(char c) {
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

	public static String ToRPN(String str) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		int priority;

		str = RemoveWhiteSpaces(str);

		if (!IsValid(str))
			return "";

		for (int i = 0; i < str.length(); i++) {
			priority = GetPriority(str.charAt(i));

			if (priority == 0) {
				result += str.charAt(i);
			}
			else if (priority == 1) {
				stack.push(str.charAt(i));
			}
			else if (priority > 1) {
				result += ' ';
				while (!stack.empty()) {
					if (GetPriority(stack.peek()) >= priority) {
						result += stack.pop();
					}
					else {
						break;
					}
				}
				stack.push(str.charAt(i));
			}
			else if (priority == -1) {
				result += ' ';

				while (GetPriority(stack.peek()) != 1) {
					result += stack.pop();
				}

				stack.pop();
			}

		}
		
		while (!stack.empty()) {
			result += stack.pop();
		}

		return result;
	}

	public static double Calculate(String str) {
		String operand = new String();
		Stack<Double> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			if (GetPriority(str.charAt(i)) == 0 && str.charAt(i) != ' ') {
				while (str.charAt(i) != ' ' && GetPriority(str.charAt(i)) == 0
						&& i < str.length())
					operand += str.charAt(i++);

				stack.push(Double.parseDouble(operand));
				operand = "";
			}
			if (GetPriority(str.charAt(i)) > 1) {
				double a = stack.pop();
				double b = stack.pop();

				if (str.charAt(i) == '+') stack.push(b + a);
				if (str.charAt(i) == '-') stack.push(b - a);
				if (str.charAt(i) == '*') stack.push(b * a);
				if (str.charAt(i) == '/') stack.push(b / a);

			}
		}
		
		return stack.pop();
	}

}
