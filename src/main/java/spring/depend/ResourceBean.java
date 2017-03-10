package spring.depend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResourceBean {
	
	private FileOutputStream fos;
	private File file;
	
	//初始化方法
	public void init(){
		System.out.println("Resource Bean------->初始化");
		//加载资源
		System.out.println("加载ResourceBean的配置文件内容");
		try {
			this.fos=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//销毁资源方法
	public void destory(){
		System.out.println("Resource--------->销毁");
		System.out.println("释放资源,执行一些清理操作...");
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileOutputStream getFos() {
		return fos;
	}

	
	public void setFile(File file) {
		this.file = file;
	}
	
}
