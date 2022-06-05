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
import br.dayo.management.dto.ClienteDTO;
import br.dayo.management.repositories.ClienteRepository;
import br.dayo.management.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + "Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) {
		Cliente cliente;
		try {
			cliente = new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getSobre(), objDTO.getEmail(), objDTO.getCpf(), objDTO.getCnpj(),  objDTO.getTelefone(), objDTO.getCep(), objDTO.getEndereco() );
		}catch (Exception e) {
			cliente = null;
			e.printStackTrace();
		}			
		return cliente;
	}
	
	@Transactional
    public Cliente save(Cliente cliente) {
		cliente.setId(null);
		cliente = repo.save(cliente);
        return cliente;
    }

	public void delete(Integer id) throws Exception{
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e){						
			throw new Exception("Não foi possivel excluir este cliente");						
		}
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private Cliente updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setCnpj(obj.getCnpj());
		newObj.setSobre(obj.getSobre());
		newObj.setEndereco(obj.getEndereco());
		newObj.setCpf(obj.getCpf());
		newObj.setTelefone(obj.getTelefone());
		
		return repo.save(newObj);
	}
	
}
