
package br.fai.sr.Repository;

import br.fai.sr.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
    public Usuario findUsuarioById(Long id);
    
    public Usuario readByUserNameAndPass(String userName, String pass);
}
