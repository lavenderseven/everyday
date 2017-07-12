/**缓存*/
//spring cache 是代码级的缓存，他一般使用一个ConcurrentMap,也就是说实际上还是使用JVM的内存来缓存对象。
从3.1开始，spring引入了对Cache的支持。核心思想：当我们在调用一个缓存方法时会把该方法参数和返回结果作为一个键值对存放在缓存中，java ehcache +spring
//那么肯定会造成大量的内存消耗，但是使用方便。
//redis作为一个缓存服务器，是内存级的缓存，它是使用单纯的内存来进行缓存
//spring-boot+ehcache 
   <dependency>//pom.xml,maven引用
            <groupId>net.sf.ehcache</groupId>
            <artifactId>ehcache</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
//hibernate缓存？
//redis：为了解决IO瓶颈，
