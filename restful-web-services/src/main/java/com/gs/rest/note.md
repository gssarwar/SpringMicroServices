# RestFull Web Services 

	Social media application 
	
	user -> posts
	1 - > n

-retrieve all users          - GET /users
-create a user 				 - POST /users
-retrieve a user			 - GET /users/{id}  -> user/1
-delete a user 				 - DELETE /users/{id}  -> user/1


-Retrieve all posts for a user  - GET /users/{id}/posts
-create a posts for a user 		- POST /users/{id}/posts
- retrieve details of a post    - GET  /user/{id}/posts/{post_id} 

# error due to missing getters of bean calss 

Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue Oct 15 06:01:36 IST 2019
There was an unexpected error (type=Internal Server Error, status=500).
No converter found for return value of type: class com.gs.rest.helloWorld.bean.HelloWorldBean
org.springframework.http.converter.HttpMessageNotWritableException: No converter found for return value of type: class com.gs.rest.helloWorld.bean.HelloWorldBean
	at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:234)
	at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.handleReturnValue(RequestResponseBodyMethodProcessor.java:181)
	at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:82)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:123)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:893)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:798)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:634)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:741)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
