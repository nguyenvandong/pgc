package pgc.compute;

import java.util.ArrayList;

import pgc.data.Variable;

public class Monomial {
	public double factor; // he so
	public ArrayList<Variable> arrVariable = new ArrayList<Variable>();

	/**
	 * ham tao khong tham so
	 */
	public Monomial() {

	}

	public Monomial(double factor) {
		this.factor = factor;
	}

	/**
	 * @param factor
	 * @param variable
	 */
	public Monomial(Double factor, ArrayList<Variable> arrVariable) {
		this.factor = factor;
		this.arrVariable = arrVariable;
	}

	public Monomial(ArrayList<Variable> arrVariable) {
		this.arrVariable = arrVariable;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	/**
	 * Kiem tra xem don thuc co phu thuoc vao bien var hay khong
	 * Neu co tra ve gia tri "true"
	 * @param var
	 * @return
	 */
	public int dependOn(Variable var) {
		int check = -1;
		for (int i = 0; i < arrVariable.size(); i++) {
			if (arrVariable.get(i).getName().equals(var.getName()))
				check = i;
		}
		return check;
	}

	/**
	 * Chuyen don thuc sang dang String
	 * 
	 * @return
	 */
	public String convertToString() {
		String uni = "";
		if (arrVariable.size() != 0) {
			for (int i = 0; i < arrVariable.size(); i++) {
				if (i != arrVariable.size() - 1)
					uni += arrVariable.get(i).convertToString() + "*";
				else
					uni += arrVariable.get(i).convertToString();
			}
			if (factor != 1 && factor != -1) {
				uni = factor + "*" + uni;
			} else {
				if (factor == -1)
					uni = "-" + uni;
			}
		} else
			uni += factor;

		return uni;
	}
}
