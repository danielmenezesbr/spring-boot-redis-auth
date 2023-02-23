package com.rabbit.samples.springredisdb.controllers;

import com.rabbit.samples.springredisdb.domain.Pessoa;
import com.rabbit.samples.springredisdb.repos.PessoaRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import javax.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;


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
	public ResponseEntity<Pessoa> getById(@PathVariable @NotBlank final String id) {
		log.info("Get Pessoa by id {}...", id);

		Optional<Pessoa> pessoa = getPessoaRepository().findById(id);

		if (pessoa.isEmpty()) {
            return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
        }

		return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa insert(@RequestBody @Valid final Pessoa pessoa) {

		log.info("Insert Pessoa {}...", pessoa);

		return getPessoaRepository().save(pessoa);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pessoa update(@RequestBody @Valid final Pessoa pessoa) {

		log.info("Update Pessoa {}...", pessoa);

		return getPessoaRepository().save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable @NotBlank final String id) {

		log.info("Delete Pessoa by id {}...", id);

		getPessoaRepository().deleteById(id);
	}

}
