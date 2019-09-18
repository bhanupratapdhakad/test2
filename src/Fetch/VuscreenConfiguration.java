package com.vuliv.vuscreen.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.vuliv.vuscreen")
@PropertySource("classpath:public.properties")
public class VuscreenConfiguration {
	@Autowired
	private Environment env;

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean(name = "db")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("DRIVER_NAME"));
		dataSource.setUrl(env.getProperty("URL"));
		dataSource.setUsername("root");
		dataSource.setPassword(env.getProperty("PASSWORD"));
		return dataSource;
	}

	@Bean(name = "initMaps")
	public InitializeMaps initializeMaps() {
		return new InitializeMaps();
	}

	@Bean(name = "initConfig")
	public ConfigReader configReader() {
		return new ConfigReader();
	}
	
	public String getProperty(String key){
		return env.getProperty(key);
	}
}
