package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.entity.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

}
