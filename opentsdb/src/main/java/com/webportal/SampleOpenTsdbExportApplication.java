package com.webportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.opentsdb.DefaultOpenTsdbNamingStrategy;
import org.springframework.boot.actuate.metrics.opentsdb.OpenTsdbGaugeWriter;
import org.springframework.boot.actuate.metrics.opentsdb.OpenTsdbNamingStrategy;
import org.springframework.boot.actuate.metrics.writer.GaugeWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by amarendra on 22/09/16.
 */
@SpringBootApplication
public class SampleOpenTsdbExportApplication {

    @Bean
    @ConfigurationProperties("metrics.export")
    @ExportMetricWriter
    public GaugeWriter openTsdbMetricWriter() {
        OpenTsdbGaugeWriter writer = new OpenTsdbGaugeWriter();
        writer.setNamingStrategy(namingStrategy());
        writer.setUrl("http://192.168.99.100:4242/api/put");
        return writer;
    }

    @Bean
    @ConfigurationProperties("metrics.names")
    public OpenTsdbNamingStrategy namingStrategy() {
        return new DefaultOpenTsdbNamingStrategy();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleOpenTsdbExportApplication.class, args);
    }

}
