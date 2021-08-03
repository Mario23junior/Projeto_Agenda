package com.project.agenda.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
		Pessoa save = pessoaRepository.save(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body((save));

	}
	
}
