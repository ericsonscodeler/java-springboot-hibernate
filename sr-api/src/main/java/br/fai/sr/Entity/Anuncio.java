
package br.fai.sr.Entity;

import br.fai.sr.InterfaceController.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="tb_anuncio")
public class Anuncio extends IBaseEntity implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name="DESCRICAO", unique = false, nullable = true , length = 500)
    private String descricao;
    
    @Column(name = "TITULO", unique = false, nullable = false, length = 15)
    private String titulo;
    
    @Column(name = "DATAHORA", unique = false, nullable = true)
    private Timestamp datahora;
    
    @ManyToOne
    @JoinColumn(name="USUARIO_ID",nullable = false)
    @JsonIgnore
    private Usuario usuarioAnuncio; // varios anuncios pertence a uma pessoa 

    @ManyToOne
    @JoinColumn(name="SERVICO_ID",nullable = false)
    private Servico servico; //
    
    @OneToMany (mappedBy = "anuncioChat",orphanRemoval = true) // orphan reval indica se for deletado um usuario , sera deletado o anuncio referente aquela pessoa
    @Cascade(CascadeType.ALL)
    private List<Chat> listChatAnuncio = new ArrayList<>();
    
    @OneToMany (mappedBy = "anuncioSolicitado",orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    private List<Solicita> listSolicitado = new ArrayList<>();
    
    public Anuncio() {
    }
    
    
    public Anuncio(Long id, String descricao, String titulo, Timestamp datahora) {
        this.id = id;
        this.descricao = descricao;
        this.titulo = titulo;
        this.datahora = datahora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }

    public Usuario getUsuario() {
        return usuarioAnuncio;
    }

    public void setUsuario(Usuario usuarioAnuncio) {
        this.usuarioAnuncio = usuarioAnuncio;
    }
    
    
    
}
