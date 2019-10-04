
package br.fai.sr.Controller;

import br.fai.sr.Entity.Usuario;
import br.fai.sr.InterfaceController.IController;
import br.fai.sr.Repository.UsuarioRepository;
import java.util.List;
import static org.apache.maven.wagon.PathUtils.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class UsuarioController implements IController<Usuario>{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    

    @GetMapping("/usuario")
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario getById(Long id) {
        return usuarioRepository.findUsuarioById(id);
    }

    @PostMapping("/usuario/criar")
    public Usuario save(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    @DeleteMapping("/usuario/delete")
    public void delete(Usuario entity) {
        usuarioRepository.delete(entity);
    }

    @PutMapping("/usuario")
    public Usuario update(Usuario entity) {
        return usuarioRepository.save(entity);
    }
    
    @GetMapping("/verify")
    public ResponseEntity getVerify(@RequestHeader (value="user") String userName, @RequestHeader (value="pass") String userPass){
        
        Usuario usuario = usuarioRepository.readByUserNameAndPass(userName, userPass);
        
        if (usuario != null){
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
