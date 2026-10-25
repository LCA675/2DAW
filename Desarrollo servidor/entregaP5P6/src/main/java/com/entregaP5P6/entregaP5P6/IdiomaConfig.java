package com.entregaP5P6.entregaP5P6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
//la implementacion nos permitira modificar como funciona spring
public class IdiomaConfig implements WebMvcConfigurer {
    //Le ponemos el @Bean para que el metodo le entregue a spring lo que devuelva
    @Bean
    public LocaleResolver localeResolver() {
//       Creamos un objeot sessionlocaleResolver para saber que idioma tiene el usuario por defecto
        SessionLocaleResolver sesion = new SessionLocaleResolver();
//        Vemos si el idioma es español "es"
        sesion.setDefaultLocale(Locale.of("es"));
        return sesion;
    }
//Creamos un interceptor para que Spring lo ejecute en cada peticion
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
        inter.setParamName("lang");
        return inter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }

}


