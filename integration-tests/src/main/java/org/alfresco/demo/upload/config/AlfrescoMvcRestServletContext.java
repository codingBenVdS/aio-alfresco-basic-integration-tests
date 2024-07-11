package org.alfresco.demo.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gradecak.alfresco.mvc.rest.config.DefaultAlfrescoMvcServletContextConfiguration;

@Configuration
@EnableWebMvc
@Import(DefaultAlfrescoMvcServletContextConfiguration.class)
public class AlfrescoMvcRestServletContext {

    @Bean
    AlfrescoMvcRestController alfrescoMvcRestController() {
        return new AlfrescoMvcRestController();
    }
}
