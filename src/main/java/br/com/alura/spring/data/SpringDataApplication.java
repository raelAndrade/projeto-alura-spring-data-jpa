package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private Boolean system = true;
	
	@Autowired
	private CrudCargoService crudCargoService;

	@Autowired
	private CrudFuncionarioService funcionarioService;
	
	@Autowired
	private CrudUnidadeService unidadeService;
	
	@Autowired
	private RelatoriosService relatoriosService;
	
	@Autowired
	private RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao vc quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade Trabalho");
			System.out.println("4 - Relatórios");
			System.out.println("5 - Relatório Dinâmico");
			
			int action = scanner.nextInt();
			
			switch(action) {
				case 1:
					crudCargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
				case 5:
					relatorioFuncionarioDinamico.inicial(scanner);
				default:
					break;
			}
		}

	}
}