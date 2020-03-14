package calculator;

public class CalculatorAppend implements ICalculator {

	@Override
	public void sum(int a, int b) {
		String res = String.valueOf(a) + '+' + String.valueOf(b);
		System.out.println(res);
	}

}
