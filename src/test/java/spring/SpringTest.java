package spring;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import spring.Tinterface.HelloImp;
import spring.depend.DependBean;

public class SpringTest {
	
	/**
	 * ApplicationContext实例化对象
	 */
	@Test
	public void ApContextTestHello(){
		//读取配置文件实例化一个IOC容器
		ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
		//从容器中获取对应的bean,注意此处"面向接口编程,而不是面向实现"
		HelloImp helloImp=context.getBean("hello",HelloImp.class);
		//执行业务逻辑
		helloImp.hello();
		System.out.println("ApplicationContext");
	}
	
	
	
	/**
	 * BeanFactory实例化对象
	 */
	@Test
	public void BeanFactoryTestHello(){
		//1.ClassPathResource方式
//		Resource resource=new ClassPathResource("hello.xml");
		//2.FileSystemResource方式
		File file=new File("resource/hello.xml");
		Resource resource=new FileSystemResource(file);
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		//从容器中获取对应的bean,注意此处"面向接口编程,而不是面向实现"
		HelloImp helloImp=beanFactory.getBean("hello",HelloImp.class);
		//执行业务逻辑
		helloImp.hello();
		System.out.println("BeanFactory");
	}
	
	/**
	 * id与name进行对比
	 */
	@Test
	public void IdAndNameTest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
		HelloImp helloImp=context.getBean("helloOne",HelloImp.class);
		helloImp.hello();
		String[] alias=context.getAliases("helloOne");
		//alias.length = 0
		//因此别名不能和id一样，如果一样则由IOC容器负责消除冲突
		System.out.println("alias.length = "+alias.length);
		Assert.assertEquals(0, alias.length);
		System.out.println("IdAndNameTest");
	}
	
	/**
	 * constructor构造器的建立
	 */
	@Test
	public void ConstrouctTest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
		HelloImp h1=context.getBean("helloC1",HelloImp.class);
		HelloImp h2=context.getBean("helloC2",HelloImp.class);
		h1.hello();
		h2.hello();
		/*
		 * 打印结果:
		 * 	this is constructor Test.
			Hello Spring!
		 */
		System.out.println("ConstrouctTest");
	}
	
	
	/**
	 * 静态工厂Factory的测试
	 * 
	 */
	@Test
	public void FactoryTest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
		HelloImp factoryBean=context.getBean("factoryHello",HelloImp.class);
		factoryBean.hello();
		//打印：Bean Factory Spring...
		System.out.println("FactoryTest");
	}
	
	/**
	 * 实例化Factory的测试
	 * 
	 */
	@Test
	public void instanceFactoryTest(){
		ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
		HelloImp factoryBean=context.getBean("instanceBean",HelloImp.class);
		factoryBean.hello();
		//打印：Instance Spring!
		System.out.println("instanceFactoryTest");
	}
	
	
	/**
	 * ResourceLoader
	 */
	@Test
	public void testResourceLoad(){
		ResourceLoader loader=new DefaultResourceLoader();
		Resource resource=loader.getResource("classpath:resource/hello.xml");
		//验证返回的是ClassPathResource
		Assert.assertEquals(ClassPathResource.class, resource.getClass());
		
	}
	

}
