package com.project.agenda.Service;

import java.util.List;

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
	
}
