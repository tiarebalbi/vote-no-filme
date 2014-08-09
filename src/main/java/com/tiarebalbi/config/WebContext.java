package com.tiarebalbi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * @author Tiarê Balbi Bonamini
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.tiarebalbi.controller", "com.tiarebalbi.api","com.tiarebalbi.validator"})
public class WebContext extends WebMvcConfigurerAdapter {
	
	private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
	private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	/**
	 * @return {@link MessageSource}
	 */
	@Bean
	public MessageSource messageSource(){
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames("classpath:i18n/messages");
	    return messageSource;
	}
	
	/**
	 * Configuração do bean de validação JSR-303
	 * @return {@link LocalValidatorFactoryBean}
	 */
	@Bean
	public LocalValidatorFactoryBean validatorBean() {
		LocalValidatorFactoryBean bean = new  LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
	
	/**
	 * Definições do Apache Tiles
	 * 
	 * @return {@link TilesConfigurer}
	 */
	@Bean
	public TilesConfigurer configuracaoTiles() {
		TilesConfigurer config = new TilesConfigurer();
		String[] definicoes = new String[2];
		definicoes[0] = "WEB-INF/views/tiles-*.xml";
		definicoes[1] = "WEB-INF/views/**/view-*.xml";

		config.setDefinitions(definicoes);
		return config;
	}
	
	/**
	 * JSTL View Resolver
	 * 
	 * @return {@link ViewResolver}
	 */
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
        viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
        viewResolver.setOrder(2);

        return viewResolver;
    }
	
	/**
	 * Configuração do viewResolver do Apache Tiles
	 * 
	 * @return {@link TilesViewResolver} 
	 */
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver view = new TilesViewResolver();
		view.setContentType("text/html");
		view.setOrder(1);
		return view;
	}
	
	/**
	 * @return {@link JsonViewResolver}
	 */
	@Bean
	public JsonViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false)
				  .favorParameter(false)
				  .defaultContentType(MediaType.TEXT_HTML)
				  .useJaf(false)
				  .mediaType("html", MediaType.TEXT_HTML)
				  .mediaType("json", MediaType.APPLICATION_JSON);
		
	}
	
	/**
	 * Negociador do ViewResolver
	 * @param manager {@link ContentNegotiationManager}
	 * 
	 * @return {@link ContentNegotiatingViewResolver}
	 */
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

		viewResolvers.add(this.tilesViewResolver());
		viewResolvers.add(this.viewResolver());
		viewResolvers.add(this.jsonViewResolver());

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        resolver.setViewResolvers(viewResolvers);
        return resolver;
	}
	

}
