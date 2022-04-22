import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		System.out.print("Input an expression: ");
        String str = in.nextLine();

		in.close();

		String rpn = Calculator.ToRPN(str);
		if (rpn != "") {
			System.out.println(Calculator.Calculate(rpn));
		} else {
			System.out.println("Expression not valid");
		}
    }
}
