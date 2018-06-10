package com.mackittipat.macmonitoring.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.spring.autoconfigure.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricConfig {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
        return registry -> {
            registry.config().commonTags("app", "mac-monitoring");
            // new UptimeMetrics().bindTo(registry);
        };
    }
}
