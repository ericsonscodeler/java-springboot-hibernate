package br.fai.sr.Controller;

import br.fai.sr.Entity.Mensagem;
import br.fai.sr.InterfaceController.IController;
import br.fai.sr.Repository.MensagemRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MensagemController implements IController<Mensagem>{
    
    private MensagemRepository mensagemRepository;

    @Override
    @GetMapping("/chat")
    public List<Mensagem> getAll() {
      return mensagemRepository.findAll();
    
    }

    @Override
    @GetMapping("/chat/{id}")
    public Mensagem getById(Long id) {
        return mensagemRepository.findMensagemById(id);
    }

    @Override
    public Mensagem save(Mensagem entity) {
       return mensagemRepository.save(entity);
    }

    @Override
    public void delete(Mensagem entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mensagem update(Mensagem entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
