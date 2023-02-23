package com.rabbit.samples.springredisdb.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
@NotNull
@RedisHash("pessoas")
public class Pessoa implements Serializable {

	public enum Sexo {
		MASCULINO, FEMININO
	}


	String id;

	@NotEmpty(message = "Nome não pode ser vazio")
	String nome;

	@NotNull(message = "Sexo não pode ser null")
	Sexo sexo;

	@Min(value = 18, message = "Idade não pode ser menor que 18 anos")
	int idade;

}
