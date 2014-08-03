package com.tiarebalbi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Classe de configuração de contexto
 * 
 * @author Tiarê Balbi Bonamini
 */
@Configuration
@EnableAutoConfiguration
@Import(value={DataContext.class, WebContext.class})
public class ApplicationContext {

    /**
     * Inicialização da aplicação
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class, args);
    }
}
