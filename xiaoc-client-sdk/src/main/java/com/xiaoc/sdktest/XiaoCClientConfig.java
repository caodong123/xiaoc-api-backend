package com.xiaoc.sdktest;


import com.xiaoc.sdktest.client.XiaoCClient;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ComponentScan
@ConfigurationProperties("xiaoc.client")
public class XiaoCClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public XiaoCClient xiaoCClient(){
        return new XiaoCClient(accessKey,secretKey);
    }

}
