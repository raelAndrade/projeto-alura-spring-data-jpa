package br.com.alura.spring.data.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

// Quando criamos consultas dinâmicas, utilizamos a Specification.
// Ter um objeto com todos os itens necessários para realizar uma consulta dinâmica, 
// como por exemplo root, criteriaQuery e criteriaBuilder.
public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome){
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Funcionario> cpf(String cpf){
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("cpf"), cpf);
	}
	
	public static Specification<Funcionario> salario(Double salario){
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.greaterThan(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao){
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
	}
}