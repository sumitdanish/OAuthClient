package com.sumit.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = "com.sumit")
	@PropertySource(
						{
							"classpath:db.properties",
							"classpath:hibernate.properties",
							"security.properties"
						}
					)
public class WebConfig extends WebMvcConfigurerAdapter {
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
			return new PropertySourcesPlaceholderConfigurer();
		}

		@Bean
		public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
			ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
			ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
			contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
			contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
			contentViewResolver.setDefaultViews(Arrays.<View> asList(new MappingJackson2JsonView()));
			return contentViewResolver;
		}

		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/jsp/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}

		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
		}

		
		@Configuration
		@EnableOAuth2Client
		public static class ClientApplication{
			@Value("${oauth.authorize}")
			private static String oAuthServerUrl;
			@Value("${oauth.token}")
			private String oAuthTokenUrl;
			@Qualifier("accessTokenRequest")
			private AccessTokenRequest accessTokenRequest;
			
		}
	}

