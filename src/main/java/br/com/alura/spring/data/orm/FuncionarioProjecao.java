package br.com.alura.spring.data.orm;

// Criar uma entidade projetada contendo os atributos que queremos apresentar.
public interface FuncionarioProjecao {

	// Atributos que será apresentado como projeção. 
	// O objetivo de criar essa interface é encapsular os valores de retorno da consulta dentro de métodos. 
	Integer getId();
	String getNome();
	Double getSalario();

}
