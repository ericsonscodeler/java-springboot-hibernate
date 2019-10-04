
package br.fai.sr.Entity;

import br.fai.sr.InterfaceController.IBaseEntity;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="tb_chat")
public class Chat extends IBaseEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true ,nullable = false)
    private Long id;
   
    @Column(name = "DATAHORA", unique = false, nullable = true)
    private Timestamp datahora;
   
    @OneToMany(mappedBy = "chatMensagem",orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    private List<Mensagem> listMensagemChat = new ArrayList<>();
    
    
    @ManyToOne
    @JoinColumn (name="ANUNCIO_ID")
    private Anuncio anuncioChat; 
    
    @ManyToOne
    @JoinColumn (name="USUARIO_ID")
    private Usuario usuarioChat;
}
