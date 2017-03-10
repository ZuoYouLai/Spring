package spring.realize;

import spring.Tinterface.HelloImp;

public class HelloFactory {
	
	//工厂的方法
	public static HelloImp newIntance(String message){
		return new HelloConstructorRealize(message);
	}

}
