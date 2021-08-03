package com.project.agenda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.agenda.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
	Pessoa findByEmail(String email);
}
