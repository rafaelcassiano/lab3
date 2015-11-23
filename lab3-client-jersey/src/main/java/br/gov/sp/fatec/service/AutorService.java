package br.gov.sp.fatec.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.dto.AutorDto;

@Service
public class AutorService {

	public List<AutorDto> list() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/autores");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(new GenericType<List<AutorDto>>() {
		});
	}

	public AutorDto load(long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/autores/" + id);
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(new GenericType<AutorDto>() {
		});
	}

	public boolean save(AutorDto autor) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/autores/");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(autor, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			return false;
		}
		return true;
	}
}
