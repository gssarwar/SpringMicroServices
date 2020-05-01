package com.gs.rest.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//rest controller 
@RestController
public class HelloWorldController {
	
	//GET 
	//URI -/hello-world
	//method - "Hello World"
//	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	
	@Autowired
	private MessageSource messageSource ;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	 
	
		@GetMapping(path = "/hello-world-bean")
		public HelloWorldBean helloWorldBean() {
			return new HelloWorldBean("Hello World");
		}
		@GetMapping(path = "/hello-world-bean/path-variable/{name}")
		public HelloWorldBean helloWorldBeanPathVaiable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World helloWorldBeanPathVaiable, %s", name));
		}
		//now path param is not working for now will have look later 
	/*
	 * @GetMapping(path = "/hello-world-bean/path-param/{name}") public
	 * HelloWorldBean helloWorldBeanPathParam(@PathParam(value = "name") String
	 * name) { System.out.println("name:::::::::"+name); return new
	 * HelloWorldBean(String.format("Hello World helloWorldBeanPathParam, %s",
	 * name)); }
	 */
		
		@GetMapping(path = "/hello-world-internationalization")
		public MessageSource helloWorldInternationalization(@RequestHeader(name="Accept-Language" ,required = false ) Locale local) {
			messageSource.getMessage("good.morning.messages",null, local);
			return messageSource;
		}
		
		@GetMapping(path = "/hello-world-internationalized")
		public String helloWorldInternationalized() {
			return messageSource.getMessage("good.morning.messages", null, LocaleContextHolder.getLocale());
		}
	

}
