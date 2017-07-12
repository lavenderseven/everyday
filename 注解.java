/**注解*/
//spring里的自定义注解可以用来实现一个解耦的功能，用形参的方式来获得想要的值，比如用户登录ID，
<property name="customArgumentResolvers">
			<list>
				<bean class="cn.vcread.framework.web.resolver.SignUpVisitorAnnotationResolver"/>
				<bean class="cn.vcread.framework.web.resolver.TestVisitorAnnotationResolver"/>
			</list>
		</property>//xml配置
@Override//java类实现HandlerMethodArgumentResolver参数解析器
	public class TestVisitorAnnotationResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return parameter.getParameterAnnotation(Test.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ceshizhujie");
		return "测试注解";
	}

}
@Target({ElementType.PARAMETER})//自定义注解
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Test {
	

}
