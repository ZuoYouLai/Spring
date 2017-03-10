package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.HelloService;

public class aopTest {
	
	@Test
	public void testHello(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aop.xml");
		HelloService helloService=applicationContext.getBean("helloService",HelloService.class);
		helloService.sayHello();
	}
	
	
	@Test
	public void testTwoHello(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aop.xml");
		HelloService helloService=applicationContext.getBean("helloService",HelloService.class);
		helloService.hellTwo();
	}
	
	

}
