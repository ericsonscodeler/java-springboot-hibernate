
package br.fai.sr.Entity;

import br.fai.sr.InterfaceController.IBaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_mensagem")
public class Mensagem extends IBaseEntity implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true ,nullable = false)
    private Long id;
    
    @Column(name="TEXTO",nullable = false,length = 100)
    private String texto;
    
    @Column(name="DATAHORA")
    private Date datahora;
    
    
    @ManyToOne
    @JoinColumn(name="USUARIO_ID",nullable = false)
    private Usuario usuarioMensagem;
    
    
    @ManyToOne
    @JoinColumn(name="CHAT_ID",nullable=false)
    private Mensagem chatMensagem;

    public Mensagem() {
    }
    

    public Mensagem(Long id, String texto, Date datahora) {
        this.id = id;
        this.texto = texto;
        this.datahora = datahora;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }
    
    
}
