package com.toni.actuator.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        //sessionLocaleResolver.setDefaultLocale(Locale.US);
        sessionLocaleResolver.setDefaultLocale(new Locale("es","ES"));
        return sessionLocaleResolver;
    }

    @Bean
    LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(localeChangeInterceptor());
    }     
	
}