package mySpringBoot.com.lago.configuation;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class MySpringServletContainerInitializer implements ServletContainerInitializer{

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("进入MySpringServletContainerInitializer");
		MyWebApplicationInitializer initializer = new MyWebApplicationInitializer();
		initializer.onStartup(ctx);
	}

}
