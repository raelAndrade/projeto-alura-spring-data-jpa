package br.com.alura.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {
	
	private Boolean system = true;

	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de unidade deseja executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);							
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao do unidade:");
		String descricao = scanner.next();
		
		Unidade unidade = new Unidade();
		unidade.setDescricao(descricao);
		
		unidadeRepository.save(unidade);
		System.out.println("Unidade salvo com sucesso!!!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		
		System.out.println("Descricao do unidade:");
		String descricao = scanner.next();
		
		Optional<Unidade> unidadeId = unidadeRepository.findById(id);
		
		if(unidadeId.isPresent()) {
			Unidade unidade = unidadeId.get();
			unidade.setDescricao(descricao);
			
			unidadeRepository.save(unidade);
			
			System.out.println("Unidade Atualizado !!!");
		}else {
			unidadeId.orElseThrow(() -> new RuntimeException("Unidade de ID " + id + " não localizado"));
		}
	}
	
	private void visualizar() {
		Iterable<Unidade> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		
		unidadeRepository.deleteById(id);
		
		System.out.println("Unidade removido com sucesso!!!");
	}
	
	
}