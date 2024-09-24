package org.SchoolApp.config;

import org.SchoolApp.Filters.RestResponseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RestResponseFilter> responseFormatFilter() {
        FilterRegistrationBean<RestResponseFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new RestResponseFilter());
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        registrationBean.addInitParameter("excludeUrlPatterns", "/api-docs/*,/swagger-ui/*,/swagger-ui.html/*");
        registrationBean.setOrder(1); // Set filter order

        return registrationBean;
    }
}
