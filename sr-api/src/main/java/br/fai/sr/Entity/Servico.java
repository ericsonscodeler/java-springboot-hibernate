package br.fai.sr.Entity;

import br.fai.sr.InterfaceController.IBaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="tb_servico")
public class Servico extends IBaseEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TIPO", unique = false, nullable = true, length = 15)
    private String tipo;
    
    @OneToMany (mappedBy = "servico",orphanRemoval = true) // orphan reval indica se for deletado um usuario , sera deletado o anuncio referente aquela pessoa
    @Cascade(CascadeType.ALL)
    private List<Anuncio> listAnuncioServico = new ArrayList<>();

    public Servico() {
    }
    
    public Servico(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
