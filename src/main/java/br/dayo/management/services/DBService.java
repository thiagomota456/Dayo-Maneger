package br.dayo.management.services;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dayo.management.domain.Cliente;
import br.dayo.management.domain.Projeto;
import br.dayo.management.domain.Tarefa;
import br.dayo.management.repositories.ClienteRepository;
import br.dayo.management.repositories.ProjetoRepository;
import br.dayo.management.repositories.TarefaRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private TarefaRepository tarefarepository;
	
	public void instantiateTestDatabase() throws ParseException {

		Cliente c1 = new Cliente(null, "João", "Sobre o cliente joão", "joca@gmail.com", "111.111.111-11","381271293", "31 3912381288", "1111111", "Centro - BH - 14123");
//		Cliente c1 = new Cliente(null, "Cliente1", "cli1@gmail.com", "111.111.111-11", "(31) 9 97334709");
//		Endereco end1 = new Endereco(null,"Minas Gerais", "Belo Horizonte", "11111-111", "Centro", "Das pedras", "27",null);
//		end1.setCliente(c1);
//		c1.setEndereco(end1);		
//		
//		Cliente c2 = new Cliente(null, "Me Exclua", "exluir@gmail.com", "222.222.222-22", "(31) 9 97334709");
//		Endereco end2 = new Endereco(null,"Rio de Janeiro", "Rio de Janeiro", "22222-222", "Centro", "Das pedras", "45",null);
//		end2.setCliente(c2);
//		c2.setEndereco(end2);
		clienteRepository.save(c1);
//		clienteRepository.save(c2);
//		
//		
		Projeto p1 = new Projeto(null,"Projeto 1" ,1652832000000L,1652832000000L, 1652832000000L, "Projeto de teste 1", c1);
		c1.getProjetos().add(p1);
		projetoRepository.save(p1);
//		
		Tarefa t1 = new Tarefa(null, "Tarefa 01", "Esta tarefa consiste em desenhar uma logo para a empresa X","0h", "6h", "to-do");
		long a = 1652832000000L;
		t1.setProjeto(p1);
		t1.setDataFinalizacao(a);
		tarefarepository.save(t1);
	}
}

