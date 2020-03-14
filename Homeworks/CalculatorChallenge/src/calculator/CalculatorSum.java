package calculator;

public class CalculatorSum implements ICalculator {

	@Override
	public void sum(int a, int b) {
		int res = a + b;	
		System.out.println(res);
	}

}
