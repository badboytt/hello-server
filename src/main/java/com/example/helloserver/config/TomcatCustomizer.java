package com.example.helloserver.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            AbstractHttp11Protocol protocol = (AbstractHttp11Protocol) connector.getProtocolHandler();

            int originMaxKeepAliveRequests = protocol.getMaxKeepAliveRequests();
            protocol.setMaxKeepAliveRequests(-1);
            log.info("####################################################################################");
            log.info("#");
            log.info("# TomcatCustomizer");
            log.info("#");
            log.info("# origin maxKeepAliveRequests {}", originMaxKeepAliveRequests);
            log.info("# custom maxKeepAliveRequests {}", protocol.getMaxKeepAliveRequests());
            log.info("# server port :{}", protocol.getPort());
//            log.info("# origin keepalive timeout: {} ms", originKeepAliveTimeout);
            log.info("# keepalive timeout: {} ms", protocol.getKeepAliveTimeout());
            log.info("# connection timeout: {} ms", protocol.getConnectionTimeout());
            log.info("# max connections: {}", protocol.getMaxConnections());
            log.info("# max threads: {}", protocol.getMaxThreads());
            log.info("#");
            log.info("####################################################################################");

        });
    }
}
