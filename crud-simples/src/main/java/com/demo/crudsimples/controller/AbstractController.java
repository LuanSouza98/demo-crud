package com.demo.crudsimples.controller;

import org.primefaces.PrimeFaces;

import com.demo.crudsimples.utils.JSFMessageUtil;

public class AbstractController {
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	public AbstractController() {
		super();
	}

	protected void addErrorMessage(String message) {
		JSFMessageUtil.sendErrorMessageToUser(message);
	}

	protected void addErrorMessage(String titulo, String message) {
		JSFMessageUtil.sendErrorMessageToUser(titulo, message);
	}

	protected void addInfoMessage(String message) {
		JSFMessageUtil.sendInfoMessageToUser(message);
	}

	protected void addInfoMessage(String titulo, String message) {
		JSFMessageUtil.sendInfoMessageToUser(titulo, message);
	}

	protected void closeDialog() {
		PrimeFaces.current().ajax().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}

	protected void keepDialogOpen() {
		PrimeFaces.current().ajax().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}

}