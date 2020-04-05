package com.demo.crudsimples.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crudsimples.entity.Pessoa;
import com.demo.crudsimples.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAllPessoas() {

		Iterable<Pessoa> iterable = pessoaRepository.findAll();
		List<Pessoa> listPessoas = new ArrayList<Pessoa>();

		for (Pessoa pessoa : iterable) {
			listPessoas.add(pessoa);
		}

		return listPessoas;
	}

	public Pessoa findPessoaById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		System.out.println(pessoa.toString());
		
		return pessoa.get();
	}

	public boolean savePessoa(Pessoa pessoa) {

		try {
			pessoaRepository.save(pessoa);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean deletePessoaById(Long id) {
		
		try {
			pessoaRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean deletePessoa(Pessoa pessoa) {
		try {
			pessoaRepository.delete(pessoa);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

}
