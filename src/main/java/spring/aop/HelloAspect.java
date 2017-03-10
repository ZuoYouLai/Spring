package spring.aop;

public class HelloAspect {
	//前置通知
	public void beforAdvice(){
		System.out.println("before Advice.");
	}
	
	//后置通知
	public void afterAdvice(){
		System.out.println("after Advice");
	}
}
