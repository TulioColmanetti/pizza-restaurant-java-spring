package br.com.tulio.pizza_restaurant.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= "br.com.tulio.pizza_restaurant")
public class WebConfiguration extends WebMvcConfigurerAdapter {

	/*	The view resolver object try to transform strings obtained from controllers into views for rendering
	 *	For example, a request on url "/app/ingredient" will pass the string "ingredient" to view resolver*/
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
//		Very simple Spring view resolver, it looks for views based on the url
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		/*	It will look for views on folder: /pizza_restaurant/src/main/webapp/WEB-INF/url_string.jsp
		 *	With Java web apps, the webapp folder is the default one for sharing resources with client side
		 *	Inside it, the WEB-INF folder is the ONLY one with PRIVATE access, so users will NOT have direct access
		 *	For this reason it was chosen for our views, only the controller will have access and will render for users*/
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
//		Set type of rendering to JSTL, which is a library for Java on HTML (better than pure Java on HTML - Scriptlet)
		viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);
	}
}
