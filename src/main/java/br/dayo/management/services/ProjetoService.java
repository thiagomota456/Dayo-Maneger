package br.dayo.management.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.dayo.management.domain.Cliente;
import br.dayo.management.domain.Projeto;
import br.dayo.management.dto.ProjetoDTO;
import br.dayo.management.repositories.ProjetoRepository;
import br.dayo.management.services.exception.ObjectNotFoundException;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository repo;
	
	@Autowired
	private ClienteService clienteService;
	
	public Projeto find(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public List<Projeto> findAll(){
		return repo.findAll();
	}
	
	public Page<Projeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
	
	public Projeto fromDTO(ProjetoDTO objDTO) {
		Projeto projeto = new Projeto(objDTO.getId(), objDTO.getNome(), objDTO.getDataDeCriacao(), objDTO.getDataDeInicio(), objDTO.getDataDeEntrega(), objDTO.getDescricao());
		Cliente cliente = clienteService.find(objDTO.getClienteID());
		projeto.setCliente(cliente);
		cliente.getProjetos().add(projeto);
		return projeto;
	}
	
	@Transactional
	public Projeto save(Projeto obj) {
		return repo.save(obj);
	}
	
	public void delete(Integer id) throws Exception{
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e){						
			throw new Exception("Não foi possivel excluir este Projeto");						
		}
	}
	
	public Projeto update(Projeto obj) {
		Projeto newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Projeto newObj, Projeto obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setDataDeCriacao(obj.getDataDeCriacao());
	}
	
}
