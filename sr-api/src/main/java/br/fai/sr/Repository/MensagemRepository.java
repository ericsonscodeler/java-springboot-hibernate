package br.fai.sr.Repository;

import br.fai.sr.Entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem,Long>{
    
    
    public Mensagem findMensagemById (Long id);
}
