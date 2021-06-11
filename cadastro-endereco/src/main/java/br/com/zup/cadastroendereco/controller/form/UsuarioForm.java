package br.com.zup.cadastroendereco.controller.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.zup.cadastroendereco.model.endereco;
import br.com.zup.cadastroendereco.model.usuario;
import br.com.zup.cadastroendereco.repository.EnderecoRepository;
//import br.com.zup.cadastroendereco.repository.UsuarioRepository;
import br.com.zup.cadastroendereco.validation.ExisteCPF;
import br.com.zup.cadastroendereco.validation.ExisteEmail;


public class UsuarioForm {
	
	@NotNull @Length(min = 5, max = 120)
	private String nome;
	
	@NotNull @CPF @ExisteCPF @Length(min = 11, max = 11)
	private String cpf;
	
	@NotNull @Email @ExisteEmail
	private String email;
	
	@NotNull @DateTimeFormat
	private Date dataNascimento;

	private endereco cep;
	
	private String cepEndereco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public endereco getCep() {
		return cep;
	}

	public void setCep(endereco cep) {
		this.cep = cep;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	

	public usuario converter(EnderecoRepository enderecoRepository) {
		endereco endereco = enderecoRepository.findByCep(cepEndereco);
		return new usuario(nome, cpf, email, dataNascimento,endereco);
	}
}
