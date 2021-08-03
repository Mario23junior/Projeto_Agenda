package com.project.agenda.Service;

import org.springframework.stereotype.Service;

import com.project.agenda.Repository.PessoaRepository;

@Service
public class PessoaService {
   
	private PessoaRepository pessoaRepository;
	
	public PessoaService(PessoaRepository pessoaRepository) {
		 this.pessoaRepository = pessoaRepository;
	}
	
	
}
