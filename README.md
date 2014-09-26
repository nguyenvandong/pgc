pgc
===
I. Giới thiệu
	PGC là một công cụ được xây dựng trên nền tảng java với mục đích hỗ trợ việc sử lý biểu thức, đa thức toán học. Nó cho phép phân tích, tính giá trị của biểu thức, tính đạo hàm ...

II. Các tính năng.
	1. Phân tích biểu thức.
	2. Tính giá trị biểu thức.
	3. Hỗ trợ các hoàm toán học cơ bản.
	4. Hỗ trợ sử lý nhiều biến.
	5. Tối giản đa thức, thực hiện các phép toán cộng, trừ, nhân trên đa thức.
	6. Tính đạo hàm của một biểu thức theo một biến.
	7. Tính Taylor Series của hàm số một biến đến một giá trị bất kì
	8. Các tính toán MAXF, MINF, TRUNC, DEDUP theo yêu như mô tả trong file PLDI'14
	   (Hàm MAXF và MINF hỗ trợ hai 2 số).

III. Sử dụng
1. Tính giá trị của một biểu thức.
	    Variable x = new Variable("x", 2);
		Variable y = new Variable("y", 3);
		Parser parser = new Parser();
		parser.add(x);
		parser.add(y);
		String str = "4*x^2*y-3*x^2+5*x*y-1-x";
		ExpressionProgram eProgram = parser.parse(str);
		double result = eProgram.getVal();
