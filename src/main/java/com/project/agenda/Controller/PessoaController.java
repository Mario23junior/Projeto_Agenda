package com.project.agenda.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.agenda.Model.Pessoa;
import com.project.agenda.Service.PessoaService;

@RestController
@RequestMapping("/v1/api/agenda/pessoa")
public class PessoaController {
   
	private PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
 	}
	
	@GetMapping
	public List<Pessoa> listingAll(){
		return pessoaService.listAllData();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> listById(@PathVariable Long id) {
		return pessoaService.PeopleById(id);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> savePerson(@Valid @RequestBody Pessoa pessoa) {
		return pessoaService.SavingPeople(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		pessoaService.DeletingPeople(id);
	}
	
	@PutMapping("/{id}")
	public void ActualyPerson(@Valid @RequestBody Pessoa pessoa, @PathVariable Long id) {
		  pessoaService.UpdatingPeople(id, pessoa);
	}
}















