package testbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calculator.ICalculator;

@Service
public class MySpringCalculatorBeanWithDependency {
	private ICalculator calculator;
	
	@Autowired
	public void setCalculator(ICalculator iCalculator) {
		this.calculator = iCalculator;
	}
	
	public void run() {
		int a = 2;
		int b = 3;
		calculator.sum(a, b);
	}
}
