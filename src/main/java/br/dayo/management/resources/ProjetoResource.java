package br.dayo.management.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.dayo.management.domain.Projeto;
import br.dayo.management.dto.ProjetoDTO;
import br.dayo.management.services.ProjetoService;

@RestController
@RequestMapping(value="/projetos")
public class ProjetoResource {

	@Autowired
	private ProjetoService service;
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<Projeto> find(@PathVariable Integer id){
		Projeto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	@CrossOrigin
	@GetMapping(value="/page")
	public ResponseEntity<Page<ProjetoDTO>> findPage(
		@RequestParam(value="page", defaultValue = "0") Integer page,
		@RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,
		@RequestParam(value="orderBy", defaultValue = "nome") String orderBy,
		@RequestParam(value="direction", defaultValue = "ASC") String direction){
		Page<Projeto> objList = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ProjetoDTO> objListDto = objList.map(obj -> new ProjetoDTO(obj.getId(),obj.getCliente().getId(), obj.getNome(), obj.getDataDeCriacao(), obj.getDataDeInicio(), obj.getDataDeEntrega(), obj.getDescricao()));
		
		return ResponseEntity.ok().body(objListDto);
	}
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Validated @RequestBody Projeto obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid ProjetoDTO objDTO){
		Projeto projeto = service.fromDTO(objDTO);
		projeto = service.save(projeto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(projeto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
