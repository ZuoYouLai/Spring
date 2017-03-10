package spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.depend.DependBean;

public class DependOnTest {
	
	@Test
	public void testDependOn(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("depend-on.xml");
		//一点要注册销毁回调，否则我们定义的销毁的方法不执行
		context.registerShutdownHook();
		DependBean dependBean=context.getBean("dependBean",DependBean.class);
		dependBean.write("AAAA");
	}

}
