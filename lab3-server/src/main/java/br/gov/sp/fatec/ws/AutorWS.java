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
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.entity.Autor;
import br.gov.sp.fatec.repository.AutorRepository;

@Component
@Path(value = "/autores")
public class AutorWS {
	@Autowired
	private AutorRepository repo;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Iterable<Autor> listAll() {
		return repo.findAll();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path(value = "/{id}")
	public Autor get(@PathParam(value = "id") long id) {
		return repo.findOne(id);
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response save(Autor autor) {
		try {
			repo.save(autor);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
