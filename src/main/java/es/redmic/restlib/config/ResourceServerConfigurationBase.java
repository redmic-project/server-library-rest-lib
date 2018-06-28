package es.redmic.restlib.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

public abstract class ResourceServerConfigurationBase extends ResourceServerConfigurerAdapter {

	private static final String SPARKLR_RESOURCE_ID = "sparklr";

	@Value("${oauth.check_token.endpoint}")
	String checkTokenEndpoint;
	@Value("${oauth.client.id}")
	String clientId;
	@Value("${oauth.client.secret}")
	String secret;
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setCheckTokenEndpointUrl(checkTokenEndpoint);
    	tokenService.setClientId(clientId);
	    tokenService.setClientSecret(secret);
	    return tokenService;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.tokenServices(tokenService()).resourceId(SPARKLR_RESOURCE_ID);
	}
}