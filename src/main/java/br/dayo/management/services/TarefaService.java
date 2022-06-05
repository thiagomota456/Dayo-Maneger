package br.dayo.management.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.dayo.management.domain.Projeto;
import br.dayo.management.domain.Tarefa;
import br.dayo.management.dto.TarefaDTO;
import br.dayo.management.repositories.TarefaRepository;
import br.dayo.management.services.exception.ObjectNotFoundException;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repo;
	
	@Autowired
	private ProjetoService projetoService;
	
	@Transactional
	public Tarefa save(Tarefa tarefa) {
		return repo.save(tarefa);
	}
	
	public Tarefa find(Integer id) {
		Optional<Tarefa> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + "Tipo: " + Tarefa.class.getName()));
	}
	
	public Tarefa fromDTO(TarefaDTO objDTO){
		Projeto projeto =  projetoService.find(objDTO.getProjetoID());
		Tarefa tarefa = new Tarefa(objDTO.getId(), objDTO.getTitulo(), objDTO.getDescricao(), objDTO.getHorasTrabalhadas(), objDTO.getTempoPrevisto(),objDTO.getStatus());
		tarefa.setProjeto(projeto);
		tarefa.setDataFinalizacao(objDTO.getDataFinalizacao());
		tarefa.setDataDeCriacao(objDTO.getDataDeCriacao());
		return  tarefa;
	}
	
	public void delete(Integer id) throws Exception{
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new Exception("Não foi possivel excluir esta Tarefa");
		}
	}
	
	public Tarefa update(Tarefa obj) {
		Tarefa novoObjeto = find(obj.getId());
 
		novoObjeto.setTitulo(obj.getTitulo());
		novoObjeto.setDescricao(obj.getDescricao());
		novoObjeto.setObcervacao(obj.getObservacoes());
		novoObjeto.setDataFinalizacao(obj.getDataFinalizacao());
		novoObjeto.setTempoPrevisto(obj.getTempoPrevisto());
		
		return repo.save(novoObjeto);
	}

}
