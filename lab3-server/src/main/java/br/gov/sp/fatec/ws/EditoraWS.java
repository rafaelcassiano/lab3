package br.gov.sp.fatec.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.entity.Editora;
import br.gov.sp.fatec.repository.EditoraRepository;

@Path(value = "/editoras")
public class EditoraWS {
	@Autowired
	private EditoraRepository repo;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Iterable<Editora> listAll() {
		return repo.findAll();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path(value = "/{id}")
	public Editora get(@PathParam(value = "id") long id) {
		return repo.findOne(id);
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response save(Editora editora) {
		try {
			repo.save(editora);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
