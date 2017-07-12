/**日志LOG
同一个项目里可以配置多种日志，logback\log4j，根据业务需求，在用的时候会区分
spring boot 默认只有输出到控制台，没有输出到文件，需要在 application.properties 手动配置
*/
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

	<!-- Appenders -->
	//输出到控制台
	<appender name="console" class="org.apache.log4j.ConsoleAppender">
		<param name="Target" value="System.out" />
		<param name="Encoding" value="UTF-8" />
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="%d{HH:mm:ss} [%t] %c{1} - %m%n" />
		</layout>
	</appender>
	//输出到文件
	<appender name="file"  class="org.apache.log4j.FileAppender">
		<param name="File" value="c:/logs/file1.log"></param>
		<param name="Threshold" value="info"></param>
		<layout class="org.apache.log4j.PatternLayout">
			<param name="ConversionPattern" value="[%d{yyyy-MM-dd HH:mm:ss\} %-5p] [%t] {%c:%L}-%m%n"></param>
		</layout>
	</appender>
	<logger name="org.springframework.samples">
		<level value="debug" />
	</logger>
	<logger name="org.springframework.core">
		<level value="info" />
	</logger>
	<logger name="org.springframework.beans">
		<level value="info" />
	</logger>
	<logger name="org.springframework.context">
		<level value="info" />
	</logger>
	<logger name="org.springframework.http">
		<level value="debug" />
	</logger>
	<logger name="org.springframework.web">
		<level value="debug" />
	</logger>
	<root>
		<priority value="warn" />
		<appender-ref ref="console" />
		<appender-ref ref="file" />
	</root>

</log4j:configuration>
