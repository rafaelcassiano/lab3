package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.entity.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

}
