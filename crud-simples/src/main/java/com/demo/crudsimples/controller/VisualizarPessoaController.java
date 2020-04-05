package com.demo.crudsimples.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.demo.crudsimples.entity.Pessoa;
import com.demo.crudsimples.service.PessoaService;

@Controller("visualizar")
@Scope("view")
public class VisualizarPessoaController extends AbstractController {

	private List<Pessoa> listPessoas;
	private Pessoa pessoaSelecionada;

	private boolean editarPessoa = false;

	@Autowired
	private PessoaService pessoaService;

	@PostConstruct
	private void init() {
		listPessoas = new ArrayList<Pessoa>();
	}

	public void buscarTodasPessoas() {
		listPessoas = pessoaService.findAllPessoas();

		if (listPessoas.isEmpty()) {
			addInfoMessage("Nenhum registro encontrado!");
		}

	}
	
	public void atualizarPessoa() {
		boolean retorno = pessoaService.savePessoa(getPessoaSelecionada());
		
		if (retorno) {
			setEditarPessoa(false);
			buscarTodasPessoas();
			addInfoMessage("Alterações salvas com sucesso!");
		} else {
			addErrorMessage("Erro ao salvar alterações!");
		}
		
	}
	
	public void deletarPessoa() {
		
		boolean retorno = pessoaService.deletePessoa(getPessoaSelecionada());
		
		if (retorno) {
			listPessoas.remove(getPessoaSelecionada());
			addInfoMessage("Registro deletado com sucesso!");
		} else {
			addErrorMessage("Erro ao deletar registro!");
		}

	}

	/*
	 * Getters and Setters
	 */

	public List<Pessoa> getListPessoas() {
		return listPessoas;
	}

	public void setListPessoas(List<Pessoa> listPessoas) {
		this.listPessoas = listPessoas;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public boolean isEditarPessoa() {
		return editarPessoa;
	}

	public void setEditarPessoa(boolean editarPessoa) {
		this.editarPessoa = editarPessoa;
	}

}
