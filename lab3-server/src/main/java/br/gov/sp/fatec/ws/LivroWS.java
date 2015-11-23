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

import br.gov.sp.fatec.entity.Livro;
import br.gov.sp.fatec.repository.LivroRepository;

@Path(value = "/livros")
public class LivroWS {
	@Autowired
	private LivroRepository repo;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Iterable<Livro> listAll() {
		return repo.findAll();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path(value = "/{id}")
	public Livro get(@PathParam(value = "id") long id) {
		return repo.findOne(id);
	}

	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response save(Livro livro) {
		try {
			repo.save(livro);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
