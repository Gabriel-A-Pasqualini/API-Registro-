package br.com.zup.cadastroendereco.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.cadastroendereco.model.endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<endereco, Long>{
    endereco findByCep(String cepEndereco);;
    
}

