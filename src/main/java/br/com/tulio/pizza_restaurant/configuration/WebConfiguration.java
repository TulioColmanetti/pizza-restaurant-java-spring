package br.com.tulio.pizza_restaurant.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= "br.com.tulio.pizza_restaurant")
public class WebConfiguration extends WebMvcConfigurerAdapter {

}
