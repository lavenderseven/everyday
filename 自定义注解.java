 /**java-spring自定义注解*/

  //配置文件需要配置
<property name="customArgumentResolvers">
			<list>
				<bean class="cn.vcread.framework.web.resolver.SignUpVisitorAnnotationResolver"/>
			</list>
		</property>

//实现了HandlerMethodArgumentResolver接口的参数解析器：
 public class SignUpVisitorAnnotationResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(SignUpVisitor.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return SARequestContext.getSignUpUserId();
	}

}
//如何把user放入session？
 //得到用户消息可以考虑用shiro