package br.com.zup.cadastroendereco.controller;

import java.net.URI;
import java.util.List;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.cadastroendereco.controller.dto.EnderecoDto;
import br.com.zup.cadastroendereco.controller.dto.UsuarioDto;
import br.com.zup.cadastroendereco.controller.form.EnderecoForm;
import br.com.zup.cadastroendereco.controller.form.UsuarioForm;
import br.com.zup.cadastroendereco.model.endereco;
import br.com.zup.cadastroendereco.model.usuario;
import br.com.zup.cadastroendereco.repository.EnderecoRepository;
//import br.com.zup.cadastroendereco.repository.EnderecoRepository;
import br.com.zup.cadastroendereco.repository.UsuarioRepository;


@RestController
public class Controller {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@PostMapping
	@Transactional
	@RequestMapping("/cadastro-usuario")
	public ResponseEntity<UsuarioDto> registroUsuario(@RequestBody @Valid  UsuarioForm form, UriComponentsBuilder uriBuilder) {
		usuario usuario = form.converter(enderecoRepository);
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/cadastro-usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@PostMapping
	@Transactional
	@RequestMapping("/cadastro-endereco")
	public ResponseEntity<EnderecoDto> registroEndereco(@RequestBody @Valid  EnderecoForm form, UriComponentsBuilder uriBuilder) {
		endereco endereco = form.converter(usuarioRepository);
		enderecoRepository.save(endereco);
		
		URI uri = uriBuilder.path("/cadastro-endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}
	
	@GetMapping("/dados-usuario")
	public ResponseEntity<List<usuario>> getAllUsers() {
		
		List<usuario> usersList = usuarioRepository.findAll();
		
		if (usersList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<usuario>>(usersList, HttpStatus.OK);
		}
	}

}
