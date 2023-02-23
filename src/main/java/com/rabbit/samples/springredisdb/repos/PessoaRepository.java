package com.rabbit.samples.springredisdb.repos;

import com.rabbit.samples.springredisdb.domain.Pessoa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, String> {

	@Override
    List<Pessoa> findAll();
}
