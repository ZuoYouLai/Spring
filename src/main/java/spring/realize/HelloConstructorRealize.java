package spring.realize;

import spring.Tinterface.HelloImp;

public class HelloConstructorRealize implements HelloImp{

	private String message;
	
	public HelloConstructorRealize(){
		this.message="this is constructor Test.";
	}
	
	
	
	public HelloConstructorRealize(String message) {
		this.message = message;
	}


	public void hello() {
		System.out.println(this.message);
	}
	

}
