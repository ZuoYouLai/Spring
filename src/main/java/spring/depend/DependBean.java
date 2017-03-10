package spring.depend;

import java.io.IOException;

public class DependBean {
	
	ResourceBean resourceBean;
	
	
	public ResourceBean getResourceBean() {
		return resourceBean;
	}

	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}

	public void write(String name){
		System.out.println("DependBean---------写资源");
		try {
			resourceBean.getFos().write(name.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//初始化方法
	public void init(){
		System.out.println("DependBean-------------->初始化");
		try {
			resourceBean.getFos().write("DependBean--------->初始化".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//销毁方法
	public void destory(){
		System.out.println("DependBean------------->销毁");
		//在销毁之前需要往文件中写销毁内容
		try {
			resourceBean.getFos().write("DependBean--------->销毁".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
