package com.sqav.tattow.spring.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

//@Configuration
//@Import(value = { PropertiesConfig.class, DataBaseConfig.class, MongoConfig.class,
//		AsyncConfig.class})
//@ComponentScan(value = { "com" }, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
//@EnableAspectJAutoProxy
//@EnableAsync
//@EnableWebMvc
//@EnableScheduling
//public class ApplicationConfig extends WebMvcConfigurerAdapter {
//	
//	@Bean(name="multipartResolver")
//    public CommonsMultipartResolver getResolver() throws IOException{
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSizePerFile(52428800); //50MB
//        return resolver;
//    }
//
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		//registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
//	}
//
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		super.addInterceptors(registry);
//		registry.addInterceptor(enterpriseHandlerInterceptor)
//				.addPathPatterns("/integration/enterprise/**")
//				.addPathPatterns("/integration/partnerships/patients/status/**")
//				.addPathPatterns("/integration/medical-cabin/mensuration/data");
//	}
//
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		List<MediaType> supportedMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN);
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setObjectMapper(new HibernateAwareObjectMapper().findAndRegisterModules());
//		converter.setPrettyPrint(true);
//		converter.setSupportedMediaTypes(supportedMediaTypes);
//		converters.add(converter);
//
//		ResourceHttpMessageConverter resourceConverter = new ResourceHttpMessageConverter();
//		resourceConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//		converters.add(resourceConverter);
//
//		super.configureMessageConverters(converters);
//	}
//	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry
//			.addMapping("/**")
//			.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "HEAD");
//		super.addCorsMappings(registry);
//	}
//
//	@Override
//	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//		long timeout = 3 * 60 * 1000; // 3 minutos
//		configurer.setDefaultTimeout(timeout);
//		super.configureAsyncSupport(configurer);
//	}
//
//}