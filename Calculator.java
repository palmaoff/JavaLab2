import java.util.Stack;

public class Calculator {

	public static boolean IsValid(String str) {
		boolean b = true;

		// check all symbols

		// check bracets

		return b;
	}

	public static String RemoveWhiteSpaces(String str) {
		String result = str.replace(" ", "");

		return result;
	}

	public String ToRPN(String str) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		int priority;

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

	public double Calculate(String str) {
		return 0;
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

}
