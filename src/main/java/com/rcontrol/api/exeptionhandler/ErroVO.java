package com.rcontrol.api.exeptionhandler;

public class ErroVO {

	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
	public ErroVO(String mensagemUsuario, String mensagemDesenvolvedor) {
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

}
