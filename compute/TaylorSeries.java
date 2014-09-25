package pgc.compute;

import pgc.data.ExpressionProgram;
import pgc.data.Parser;
import pgc.data.Variable;

public class TaylorSeries {

	public TaylorSeries() {

	}

	/**
	 * Tinh Taylor cua ham 1 bien
	 * 
	 * @param str_exp
	 * @param var
	 * @param a
	 * @param n
	 * @return
	 */
	public static ExpressionProgram seies(String str_exp, Variable var, int a,
			int n) {
		var.setVal(a);
		Parser parser = new Parser();
		parser.add(var);
		ExpressionProgram expg = parser.parse(str_exp);
		double p1 = expg.getVal();
		String result = Double.toString(p1);
		for (int i = 1; i <= n; i++) {
			expg = derivative(expg, var);
			double deriv = expg.getVal();
			int factorial = factorial(i);
			String factor = "";
			if (deriv == 0)
				factor = "";
			else {
				if (deriv == 1)
					factor = "1/" + Integer.toString(factorial);
				else {
					if (deriv == -1)
						factor = "-1/" + Integer.toString(factorial);
					else
						factor = "1/" + Integer.toString(factorial) + "*" + "("
								+ Double.toString(deriv) + ")";
				}
			}
			String variable = "";
			if (a == 0)
				variable = "x";
			else
				variable = "(x-" + Integer.toString(a) + ")";
			if (!factor.equals("")) {
				if (i != 1)
					result += "+" + "(" + factor + ")" + "*" + variable + "^"
							+ Integer.toString(i);
				else
					result += "+" + "(" + factor + ")" + "*" + variable;
			}

		}
		ExpressionProgram exprog = parser.parse(result);
		return exprog;
	}

	/**
	 * Tinh dao ham tai mot diem
	 * 
	 * @param ex
	 * @param var
	 * @return
	 */
	private static ExpressionProgram derivative(ExpressionProgram ex,
			Variable var) {
		ex = ex.derivative(var);
		return ex;
	}

	/**
	 * Tinh giai thua
	 * 
	 * @param n
	 * @return
	 */
	private static int factorial(int n) {
		if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
}
