package spring;

import org.junit.Test;

import spring.Tinterface.HelloImp;
import spring.realize.HelloRealize;

public class CommonTest {
	
	@Test
	public void helloTest(){
		HelloImp helloImp=new HelloRealize();
		helloImp.hello();
	}
}
