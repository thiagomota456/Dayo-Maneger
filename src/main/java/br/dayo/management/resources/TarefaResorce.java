package br.dayo.management.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dayo.management.domain.Tarefa;
import br.dayo.management.dto.TarefaDTO;
import br.dayo.management.services.TarefaService;

@RestController
@RequestMapping(value="/tarefas")
public class TarefaResorce {

	@Autowired
	private TarefaService service;
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<Tarefa> find(@PathVariable Integer id){
		Tarefa tarefa = service.find(id);
		return ResponseEntity.ok().body(tarefa);
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Tarefa> save(@RequestBody @Valid TarefaDTO tarefaDTO){
		Tarefa tarefa = service.fromDTO(tarefaDTO);
		
		tarefa = service.save(tarefa);
		
		return ResponseEntity.ok().body(tarefa);
	}
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void>  delete(@PathVariable Integer id) throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Tarefa> update(@Validated @RequestBody TarefaDTO tarefaDTO,@PathVariable Integer id){
		Tarefa tarefa = service.fromDTO(tarefaDTO);
		
		Tarefa tarefaIntermediaria = service.find(id);
		tarefa.setId(tarefaIntermediaria.getId());
		
		if(tarefa.getObservacoes() == null) {
			tarefa.setObcervacao(tarefaIntermediaria.getObservacoes());
		}
		
		tarefa = service.update(tarefa);
		
		return ResponseEntity.ok().body(tarefa);
	}
	
	@CrossOrigin
	@PostMapping(value="/observacao/{id}")
	public ResponseEntity<Tarefa> AddObservacao(@RequestBody @Valid String observacao , @PathVariable Integer id){
		Tarefa tarefa = service.find(id);
		tarefa.setObservacao(observacao);
		
		return ResponseEntity.ok().body(service.save(tarefa));
	}
	
}
