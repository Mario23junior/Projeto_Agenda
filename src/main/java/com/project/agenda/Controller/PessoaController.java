package com.project.agenda.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
