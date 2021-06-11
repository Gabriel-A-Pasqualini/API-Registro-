package br.com.zup.cadastroendereco.controller.form;


import javax.validation.constraints.NotNull;
import br.com.zup.cadastroendereco.model.endereco;
import br.com.zup.cadastroendereco.model.usuario;
import br.com.zup.cadastroendereco.repository.UsuarioRepository;



public class EnderecoForm {
	
	@NotNull
	private String logradouro;
	
	@NotNull
	private String numero;
	
	private String complemento;
	
	@NotNull
	private String bairro;
	
	@NotNull
	private String cidade;
	
	@NotNull
	private String estado;
	
	@NotNull
	private String cep;

	private String cpfUsuario;


	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCpfUsuario() {
		return cpfUsuario;
	}
	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public endereco converter(UsuarioRepository usuarioRepository) {
		usuario usuario = usuarioRepository.findByCpf(cpfUsuario);
		return new endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, usuario);
	}
}