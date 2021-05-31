package br.com.tulio.pizza_restaurant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("br.com.tulio.pizza_restaurant.configuration");
//		Load Servlet right after app startup
//		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/app/*");
		
		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
	}

//	private AnnotationConfigWebApplicationContext buildApplicationContext() {
//		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//		webApplicationContext.setConfigLocation("br.com.tulio.pizza_restaurant.configuration");
//		return webApplicationContext;
//	}
}