package com.vmware.tanzu.se.wsdbjmsexample;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(final ApplicationContext applicationContext) {
        final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/Receiver/*");
    }

    @Bean(name = "outboundAmender")
    public SimpleWsdl11Definition outboundAmenderWsdl11Definition() {
        return new SimpleWsdl11Definition(new ClassPathResource("wsdl/outboundAmender.wsdl"));
	}

	@Bean(name = "outboundAmender-schema")
	public XsdSchema outboundAmenderSchema() {
		return new SimpleXsdSchema(new ClassPathResource("wsdl/outboundAmender-schema.xsd"));
	}
}