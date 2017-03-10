package spring.realize;

import spring.Tinterface.HelloImp;
//实例化工厂
public class HelloInstanceFactory {
	public HelloImp newInstance(String message){
		return new HelloConstructorRealize(message);
	}
}
