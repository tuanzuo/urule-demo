package com.tz.urule.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    /**
     * 构建RestTemplate
     */
    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        //方式1【不推荐】：增加自定义的消息转换器[在RestTemplateBuilder中添加消息转换器会影响到所有使用它来构建RestTemplate的地方，相当于一个全局的设置]
        //builder.additionalMessageConverters(new XXXHttpMessageConverter());
        RestTemplate restTemplate = builder.build();
        //方式2【推荐】：增加自定义的消息转换器[只影响当前生成的RestTemplate,不影响其他地方使用RestTemplateBuilder来构建的RestTemplate]
        //restTemplate.getMessageConverters().add(new XXXHttpMessageConverter());
        return restTemplate;
    }

    /*
    //构建另一个RestTemplate
    @Bean("redisRestTemplate")
    public RestTemplate redisRestTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }*/

}
