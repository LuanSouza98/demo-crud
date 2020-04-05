package com.demo.crudsimples.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.demo.crudsimples.entity.Pessoa;
import com.demo.crudsimples.service.PessoaService;

@Controller("cadastrar")
@Scope("view")
public class CadastrarPessoaController extends AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;

	@Autowired
	private PessoaService pessoaService;

	@PostConstruct
	private void init() {
		pessoa = new Pessoa();
	}

	public void salvarPessoa() {
		boolean retorno = pessoaService.savePessoa(getPessoa());
		
		if (retorno) {
			addInfoMessage("Pessoa cadastrada com sucesso!");
			pessoa = new Pessoa();
		} else {
			addErrorMessage("Erro ao cadastrar pessoa!");
		}
	}

	/*
	 * Getters and Setters
	 */

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
