package br.dayo.management.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.dayo.management.domain.Cliente;
import br.dayo.management.dto.ClienteDTO;
import br.dayo.management.repositories.ClienteRepository;
import br.dayo.management.resources.exception.FieldMessage;
import br.dayo.management.services.validation.utils.CBR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteDTO>{
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert obj) {	}
	
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(CBR.isValidCPF(objDto.getCpf()) || CBR.isValidCNPJ(objDto.getCpf())) {
			list.add(new FieldMessage("CpfOuCnpj", "CPF ou CNPJ Inválido!"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		
		if(aux != null)
			list.add(new FieldMessage("email", "O e-mail já existe!"));
		for(FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}
}
