## spring security+thymeleaf在html页面使用<sec>标签
* maven 导入
    -  <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity4</artifactId>
            <version>2.1.2.RELEASE</version>
        </dependency>
* config配置Bean
    -    @Bean
        public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
        }
* html页面引入标签
    -  xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">