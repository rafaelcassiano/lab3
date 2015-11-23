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

import br.gov.sp.fatec.dto.EditoraDto;

@Service
public class EditoraService {

	public List<EditoraDto> list() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/editoras");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(new GenericType<List<EditoraDto>>() {
		});
	}

	public EditoraDto load(long id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:8080/editoras/" + id);
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).get();
		return response.readEntity(new GenericType<EditoraDto>() {
		});
	}

	public boolean save(EditoraDto editora) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/editoras/");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(editora, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			return false;
		}
		return true;
	}

}
