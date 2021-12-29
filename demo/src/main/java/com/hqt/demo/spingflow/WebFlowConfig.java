package com.hqt.demo.spingflow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.webflow.view.AjaxThymeleafViewResolver;
import org.thymeleaf.spring5.webflow.view.FlowAjaxThymeleafView;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {
	
	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices())
				.setBasePath("classpath:") //
				.addFlowLocation("flows/start/demo-flow.xml", "activationFlow") //
				.setFlowBuilderServices(this.flowBuilderServices())
				.build();
	}

	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(this.flowRegistry())
				.build();
	}

	@Bean
	public FlowBuilderServices flowBuilderServices() {
		return getFlowBuilderServicesBuilder()
				.setViewFactoryCreator(this.mvcViewFactoryCreator())
				.build();
	}
	
	
	@Bean
	public FlowHandlerMapping flowHandlerMapping() {
		FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
		handlerMapping.setOrder(-1);
		handlerMapping.setFlowRegistry(this.flowRegistry());
		return handlerMapping;
	}

	@Bean
	public FlowHandlerAdapter flowHandlerAdapter() {
		FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
		handlerAdapter.setFlowExecutor(this.flowExecutor());
		handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
		return handlerAdapter;
	}

	@Bean
	public AjaxThymeleafViewResolver thymeleafViewResolver() {
	    AjaxThymeleafViewResolver viewResolver = new AjaxThymeleafViewResolver();
	    viewResolver.setViewClass(FlowAjaxThymeleafView.class);
	    viewResolver.setTemplateEngine(this.templateEngine());
	    viewResolver.setCharacterEncoding("UTF-8");
	    return viewResolver;
	}
	
	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(this.templateResolver());
		return templateEngine;
	}
	
	@Bean
	@Description("Thymeleaf template resolver serving HTML 5")
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setCacheable(false);
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}
	
	

	@Bean
	public MvcViewFactoryCreator mvcViewFactoryCreator() {
		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(thymeleafViewResolver());
		MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
		factoryCreator.setViewResolvers(viewResolvers);
		factoryCreator.setUseSpringBeanBinding(true);
		return factoryCreator;
	}
}
