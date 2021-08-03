package com.project.agenda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.project.agenda.Exception.DuplicateBusinessRule;
import com.project.agenda.Model.Pessoa;
import com.project.agenda.Repository.PessoaRepository;

@Service
public class PessoaService {
   
	private PessoaRepository pessoaRepository;
	
	public PessoaService(PessoaRepository pessoaRepository) {
		 this.pessoaRepository = pessoaRepository;
	}
	
	public List<Pessoa> listAllData() {
		List<Pessoa> listAll = pessoaRepository.findAll();
		return listAll;
	}
	
	public ResponseEntity<Pessoa> PeopleById(Long id) {
		Optional<Pessoa> listId = pessoaRepository.findById(id);
		return listId.isPresent() 
				? ResponseEntity.ok(listId.get()) 
				: ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Pessoa> SavingPeople(Pessoa pessoa) {
		ValidateDuplicateData(pessoa);
		Pessoa save = pessoaRepository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body((save));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeletingPeople(Long id) {
		pessoaRepository.deleteById(id);	
	}
	
	 public void UpdatingPeople(Long id, Pessoa pessoa) {
		 pessoaRepository
		                .findById(id)
		                .map(updatePessoa -> {
		                	pessoa.setId(updatePessoa.getId());
		                	ValidateDuplicateData(pessoa);
  		                	pessoaRepository.save(pessoa);
		                	return updatePessoa;
		                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Nenhuma informação encontrada para ser deletada"));
	 }
	 
	 
	 public void ValidateDuplicateData(Pessoa pessoa) {
		 Pessoa findPerson = pessoaRepository.findByEmail(pessoa.getEmail());
		 if(findPerson != null && findPerson.getEmail() != pessoa.getEmail()) {
			 throw new DuplicateBusinessRule(String.format("O Cliente %s ja está cadastrado",pessoa.getNome()));
		 }
	 }	
}




