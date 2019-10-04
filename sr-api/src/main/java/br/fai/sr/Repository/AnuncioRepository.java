package br.fai.sr.Repository;

import br.fai.sr.Entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio,Long> {
    
    public Anuncio findAnuncioById(Long id);
    
    public Anuncio findAnuncioByServico(Long servico_fk);
    }
