package br.com.alura.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private Boolean system = true;

	@Autowired
	private CargoRepository cargoRepository;
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de cargo deseja executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar();							
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
	
	private void salvar() {
		System.out.println("Descricao do cargo:");
		Scanner entrada = new Scanner(System.in);
		String descricao = entrada.nextLine();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo salvo com sucesso!!!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		
		System.out.println("Descricao do cargo:");
		String descricao = scanner.next();
		
		Optional<Cargo> cargoId = cargoRepository.findById(id);
		
		if(cargoId.isPresent()) {
			Cargo cargo = cargoId.get();
			cargo.setDescricao(descricao);
			
			cargoRepository.save(cargo);
			
			System.out.println("Cargo Atualizado !!!");
		}else {
			cargoId.orElseThrow(() -> new RuntimeException("Cargo de ID " + id + " não localizado"));
		}
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		
		cargoRepository.deleteById(id);
		
		System.out.println("Cargo removido com sucesso!!!");
	}
	
	
}