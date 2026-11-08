package com.cv.portfolio.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class IdiomaConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
//       Creamos un objeot sessionlocaleResolver para saber que idioma tiene el usuario por defecto
        SessionLocaleResolver sesion = new SessionLocaleResolver();
//        Vemos si el idioma es español "es"
        sesion.setDefaultLocale(Locale.of("es"));
        return sesion;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
        inter.setParamName("lang");
        return inter;
    }
    // Activa el cambio de idioma en todas las páginas
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
}
