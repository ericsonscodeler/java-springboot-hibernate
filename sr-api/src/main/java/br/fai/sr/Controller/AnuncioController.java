
package br.fai.sr.Controller;

import br.fai.sr.Entity.Anuncio;
import br.fai.sr.Repository.AnuncioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.fai.sr.InterfaceController.IController;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class AnuncioController implements IController<Anuncio>{
    
    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping("/anuncio")
    public List<Anuncio> getAll() {
        return anuncioRepository.findAll();
    }

    @GetMapping("/anuncio/{id}")
    public Anuncio getById(Long id) {
       return anuncioRepository.findAnuncioById(id);
    }
    
    @GetMapping("/anunciotipo/{id}")
    public Anuncio getByServico(Long servico_fk) {
       return anuncioRepository.findAnuncioByServico(servico_fk);
    }

    @PostMapping("/anuncio/criar")
    public Anuncio save(Anuncio entity) {
        entity.setDatahora(new Timestamp(new Date().getTime()));
       return anuncioRepository.save(entity);
    }

    @DeleteMapping("/anuncio/delete")
    public void delete(Anuncio entity) {
        anuncioRepository.delete(entity);
    }

    @PutMapping("/anuncio/update")
    public Anuncio update(Anuncio entity) {
        return anuncioRepository.save(entity);
    }
    
}
