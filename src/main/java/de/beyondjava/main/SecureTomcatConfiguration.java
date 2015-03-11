package de.beyondjava.main;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import com.sun.faces.config.ConfigureListener;

import de.beyondjava.scope.ViewScope;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.faces.webapp.FacesServlet;

@Configuration
public class SecureTomcatConfiguration {

	@Bean
	public EmbeddedServletContainerFactory servletContainer()
			throws FileNotFoundException {
		TomcatEmbeddedServletContainerFactory f =
				new TomcatEmbeddedServletContainerFactory();
//		f.addAdditionalTomcatConnectors(createSslConnector());
		
		return f;
	}

/*	private Connector createSslConnector() throws FileNotFoundException {
		Connector connector = new Connector(Http11NioProtocol.class.getName());
		Http11NioProtocol protocol =
				(Http11NioProtocol)connector.getProtocolHandler();
		connector.setPort(8443);
		connector.setSecure(true);
		connector.setScheme("https");
		protocol.setSSLEnabled(true);
		protocol.setKeyAlias("localhost");
		protocol.setKeystorePass("changeme");
		protocol.setKeystoreFile(ResourceUtils
			.getFile("src/main/resources/keystore.jks")
			.getAbsolutePath());
		protocol.setSslProtocol("TLS");
		return connector;
	}*/

}
