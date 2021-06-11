package br.com.zup.cadastroendereco.controller.dto;

import java.util.Date;

import br.com.zup.cadastroendereco.model.usuario;

public class UsuarioDto {
	
	private Long id;
	private String nome;
    private String cpf;
    private Date dataNascimento;
    private String email;
    
    public UsuarioDto(usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.email = usuario.getEmail();
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}
    
    
}
