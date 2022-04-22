import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Calculator c = new Calculator();
		Scanner in = new Scanner(System.in);

		System.out.print("Input an expression: ");
        String str = in.nextLine();

		in.close();

		String rpn = c.ToRPN(str);
		if (rpn != "") {
			System.out.println(c.Calculate(rpn));
		} else {
			System.out.println("Expression not valid");
		}

	}

}
