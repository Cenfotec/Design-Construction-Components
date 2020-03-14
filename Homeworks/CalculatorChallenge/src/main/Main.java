package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testbean.MySpringCalculatorBeanWithDependency;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		BeanFactory factory = context;
		MySpringCalculatorBeanWithDependency test = (MySpringCalculatorBeanWithDependency) factory
				.getBean("MySpringCalculatorBeanWithDependency");
		test.run();
	}
}