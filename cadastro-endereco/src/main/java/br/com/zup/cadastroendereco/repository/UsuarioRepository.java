package br.com.zup.cadastroendereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.cadastroendereco.model.endereco;
import br.com.zup.cadastroendereco.model.usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Long>{
    usuario findByCpf(String cpfUsuario);

    void save(endereco endereco);
}
