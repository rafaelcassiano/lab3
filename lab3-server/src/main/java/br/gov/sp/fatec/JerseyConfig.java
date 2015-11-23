package br.gov.sp.fatec;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.gov.sp.fatec.ws.AutorWS;
import br.gov.sp.fatec.ws.EditoraWS;
import br.gov.sp.fatec.ws.LivroWS;

@Configuration
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(AutorWS.class);
		register(LivroWS.class);
		register(EditoraWS.class);
		register(CORSResponseFilter.class);
	}
}