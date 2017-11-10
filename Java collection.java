Java collection
List:
	实现Collection 
	允许重复
	可以有null
	有序
	底层是数组
	删除很慢
	对ArrayList来说，remove( )和add( )方法是类似的，在任意位置移除元素之后，都要进行数组的复制和重组。
Set:
	实现Collection
	无序
	不能重复
	底层是hashmap
	哈希码
	放到HashSet中的对象需要实现hashCode()方法
	适用场景：去重复数据，单列
Map:
	快速得到值map.get(key)
	适用映射算法

list.contains(o)会遍历整个list,效率很低
set.contains(o)使用hashcode,效率高

哈希码：。Object的hashCode()方法返回的哈希码是根据对象的内存地址来生成的，所以每个对象的哈希码是不相同的，如果你要比较的两个变量的类型没有重写Object的hashCode()方法那么这两个变量除非是指向
相同的对象（地址相同），否则返回的一定是false。而String以及基本数据类型的包装类中都重写了hashCode()方法，他们生成的哈希码是跟他们的内容
（这里就是指值）息息相关，也就是说在用equals()比较两个变量是否相等的时候只要他们的值相等，那么就返回true，因为他们生成的哈希码相等。有个
值得注意的地方是：在JDK的类中只要重写的Object的equals()方法，那就肯定重写了它的hashCode()方法，因为equals()方法中在比较两个变量时，
判断的标准就是哈希码是否一样，Object中的hashCode()方法是根据对象的内存地址生成的，如果重写了equals()方法而继续使用原来的hashCode()方
法生成的哈希码作为判断相等的依据，那显然达不到我们要改变判断对象是否相等的标准的效果。