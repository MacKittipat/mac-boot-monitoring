package com.mackittipat.macmonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableSpringBootMetricsCollector
//@Configuration
//@EnablePrometheusEndpoint
@SpringBootApplication
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public SpringBootMetricsCollector springBootMetricsCollector(Collection<PublicMetrics> publicMetrics) {
//        SpringBootMetricsCollector springBootMetricsCollector = new SpringBootMetricsCollector(publicMetrics);
//        springBootMetricsCollector.register();
//        return springBootMetricsCollector;
//    }
//
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        DefaultExports.initialize();
//        return new ServletRegistrationBean(new MetricsServlet(), "/prometheus");
//    }

}
