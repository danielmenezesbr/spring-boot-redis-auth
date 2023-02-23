package com.rabbit.samples.springredisdb.controllers;

import com.rabbit.samples.springredisdb.domain.Pessoa;
import com.rabbit.samples.springredisdb.repos.PessoaRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> getAll() {

		log.info("Get all Pessoas...");

		return pessoaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Pessoa getById(@PathVariable final String id) {

		if (!StringUtils.hasLength(id)) {
			log.error("Get Pessoa by id: ID vazio!");
			return Pessoa.builder().errMsg("ID não pode ser vazio").build();
		}

		log.info("Get Pessoa by id {}...", id);

		return getPessoaRepository().findById(id).get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa insert(@RequestBody @Valid final Pessoa pessoa) {

		if (pessoa == null) {
			log.error("Insert Pessoa: Objeto não pode ser null!");
			return Pessoa.builder().errMsg("Objeto não pode ser null").build();
		}

		log.info("Insert Pessoa {}...", pessoa);

		return getPessoaRepository().save(pessoa);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pessoa update(@RequestBody @Valid final Pessoa pessoa) {

		if (pessoa == null) {
			log.error("Update Pessoa: Objeto não pode ser null!");
			return Pessoa.builder().errMsg("Objeto não pode ser null").build();
		}

		log.info("Update Pessoa {}...", pessoa);

		return getPessoaRepository().save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final String id) {

		if (!StringUtils.hasLength(id)) {
			log.error("Delete Pessoa by id: ID vazio");
		}

		log.info("Delete Pessoa by id {}...", id);

		getPessoaRepository().deleteById(id);
	}

}
