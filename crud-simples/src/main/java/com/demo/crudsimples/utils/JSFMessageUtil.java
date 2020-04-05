package com.demo.crudsimples.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFMessageUtil {

	private JSFMessageUtil() {
	}

	public static void sendInfoMessageToUser(String titulo, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, titulo, message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendInfoMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendErrorMessageToUser(String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, message);
		addMessageToJsfContext(facesMessage);
	}

	public static void sendErrorMessageToUser(String titulo, String message) {
		FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_ERROR, titulo, message);
		addMessageToJsfContext(facesMessage);
	}

	private static FacesMessage createMessage(Severity severity, String tituloErro, String mensagemErro) {
		return new FacesMessage(severity, tituloErro, mensagemErro);
	}

	private static FacesMessage createMessage(Severity severity, String mensagemErro) {
		return new FacesMessage(severity, mensagemErro, mensagemErro);
	}

	private static void addMessageToJsfContext(FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

}
