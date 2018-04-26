## spring实战（第五，六章）

* mvc启动的基本配置(使用java类配置)

    
<servlet>

	@Configuration
	@EnableWebMvc                 //启动mvc
	@ComponentScan("spittr.web")  //组件扫描,扫描的是包
	public class WebConfig ...{   //配置jsp视图解析器
		@Bean
		public ViewResolver viewResolver(){
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/views/");
			resolver.setSuffix(".jsp");
			resolver.setExposeContextBeansAsAttributes(true);
			return resolver;
		}
	}
</servlet>

* 基本的控制器（使用java类配置）

@Controller，声明为一个控制器

@RequestMapping(value = "/",method = GET),处理对“/”的GET请求

* 处理异常方法

@ResponseStatus将异常映射为特定的状态码。

<servlet>

	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Spittle Not Found");    //将异常映射为HTTP状态404

* 控制器通知@ControllerAdvice

使用@ControllerAdvice，为所有的控制器处理异常	

<servlet>

	@ControllerAdvice        //定义控制器类
	public class AppWideExceptionHandler {
		//定义异常处理方法
		@ExceptionHandler(DuplicateSpittleException.class)
		public String duplicateHadler(){
			return "error/duplicate";
		}
	}