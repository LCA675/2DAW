package com.cv.portfolio.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class IdiomaConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
        //Lo guardo en las cookies para que asi se gestione mejor a la hora de subirlo a vercel
        CookieLocaleResolver resolver = new CookieLocaleResolver("idioma");
        resolver.setDefaultLocale(new Locale("es"));
        return resolver;
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
