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
@Table(name="tb_solicita")
public class Solicita extends IBaseEntity implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true ,nullable = false)
    private Long id;
    
    @Column(name = "STATUS", unique = false ,nullable = false)
    private String status;
    
    @Column(name = "COMENTARIO", unique = false ,nullable = true, length = 300)
    private String comentario;
    
    @Column(name = "DATAHORA")
    private Date datahora;
    
    @Column(name = "AVALIACAO")
    private Integer avaliacao;
    
    @ManyToOne
    @JoinColumn(name="USUARIO_ID",nullable = false)
    private Usuario usuarioSolicitado;
    
    @ManyToOne
    @JoinColumn(name="SERVICO_ID",nullable = false)
    private Anuncio anuncioSolicitado;
    

    public Solicita() {
    }

    
    public Solicita(Long id, Long anuncio_id, Long usuario_id, String status, String comentario, Date datahora, Integer avaliacao) {
        this.id = id;
        this.status = status;
        this.comentario = comentario;
        this.datahora = datahora;
        this.avaliacao = avaliacao;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
}
