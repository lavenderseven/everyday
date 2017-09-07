spring boot启动

//使用内嵌tomcat 的好处：可以打成jar包直接运行

//打jar包，pox.xml
 1.<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>spring-milestone</id>
            <url>https://repo.spring.io/libs-release</url>
        </repository>
    </repositories>

2. maven build —— package

3.双击运行打成的xxx.jar（服务不知该如何停下来）
4.cmd 控制台进入xxx.jar目录用java -jar xxx.jar运行服务，关闭控制台即关闭服务


// 打成war包的好处：传输快，可自动解压
如果我们想要将在外部的tomcat服务器部署的WAR包，就不能依赖于RestfulApiWebDemo 
的main函数，要以类似于web.xml文件配置的方式来启动spring 应用上下文，
此时我们需要声明一个类，这个类的作用与在web.xml中配置负责初始化spring应用上下文的
监听器作用类似，只不过这里不是xml文件了
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

}

pom.xml修改：  <packaging>war</packaging>

 这里还需要移除对嵌入式 tomcat的依赖，这样打出的war包中，在lib目录下才不会包含tomcat相关的jar包
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
改成

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
</dependency>

//jar比war启动快？以maven方式启动是不是默认就是jar?如何在本地环境以jar启动

