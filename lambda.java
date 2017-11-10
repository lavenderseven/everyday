当一个方法接受函数式接口作为参数时，可以传入Lambda表达式或则方法、构造器的引用进行调用
函数式接口：减少可变量的声明，使用@FunctionalInterface注解进行标注(非强制性)
			
高阶函数：将函数作为参数传入到另一个函数中
			函数的返回值可以是函数类型
			在函数中创建另一个函数
如果一个方法接受一个函数式接口作为参数，那么我们可以传入以下类型作为参数：

匿名内部类(Anonymous Inner Class)
Lambda表达式
方法或者构造器的引用(Method or Constructor Reference)