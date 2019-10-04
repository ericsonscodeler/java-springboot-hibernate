package br.fai.sr.Entity;


import br.fai.sr.InterfaceController.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_usuario", uniqueConstraints = {
@UniqueConstraint(columnNames = "CPF"),
@UniqueConstraint(columnNames = "EMAIL") })
public class Usuario extends IBaseEntity implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true ,nullable = false)
    private Long id;
    
    @Column(name = "CPF", unique = true, nullable = false)
    private String cpf;
    
    @Column(name = "NOME", nullable = false, length = 100)
    private String userName;
    
    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email; 
    
    @Column(name = "ENDERECO", unique = false , nullable = true, length = 100)
    private String lagradouro;
    
    @Column (name = "SENHA", unique = false, nullable = false, length = 100)
    private String pass;
    
    @Column (name = "INFORMACAO", unique = false, nullable = false, length = 500)
    private String informacao;
    
    @Column (name = "TELEFONE", unique = true , nullable = true , length = 20)
    private String telefone;
    
    @Column (name = "CIDADE", unique = false , nullable = false, length = 50)
    private String cidade;
    
    @Column (name = "CEP", unique = false , nullable = false, length = 15)
    private String cep;
    
    @Column ()
    private String estado;
    
    @OneToMany (mappedBy = "usuarioAnuncio",orphanRemoval = true) // orphan reval indica se for deletado um usuario , sera deletado o anuncio referente aquela pessoa
    @Cascade(CascadeType.ALL)
    @JsonIgnore
    private List<Anuncio> listAnuncioUsuario = new ArrayList<>();// um usuario pode conter varios anuncios
    
    
    @OneToMany (mappedBy = "usuarioMensagem",orphanRemoval = true) 
    @Cascade(CascadeType.ALL)
    private List<Mensagem> listMensagemUsuario = new ArrayList<>();
    
    
    @OneToMany (mappedBy = "usuarioChat",orphanRemoval = true) 
    @Cascade(CascadeType.ALL)
    private List<Chat> listUsuarioChat = new ArrayList<>();
    
    @OneToMany (mappedBy = "usuarioSolicitado",orphanRemoval = true) 
    @Cascade(CascadeType.ALL)
    private List<Solicita> listUsuarioSolicita = new ArrayList<>();

    public Usuario() {
    }

    public String toString() {
        return "Usuario{" + "id=" + id + ", cpf=" + cpf + ", nome=" + userName + ", email=" + email + ", lagradouro=" + lagradouro + ", senha=" + pass + ", informacao=" + informacao + ", telefone=" + telefone + ", cidade=" + cidade + ", cep=" + cep + ", estado=" + estado + ", listAnuncioUsuario=" + listAnuncioUsuario + ", listMensagemUsuario=" + listMensagemUsuario + ", listUsuarioChat=" + listUsuarioChat + ", listUsuarioSolicita=" + listUsuarioSolicita + '}';
    }

    public Usuario(Long id, String cpf, String userName, String email, String lagradouro, String pass, String informacao, String telefone, String cidade, String cep, String estado) {
        this.id = id;
        this.cpf = cpf;
        this.userName = userName;
        this.email = email;
        this.lagradouro = lagradouro;
        this.pass = pass;
        this.informacao = informacao;
        this.telefone = telefone;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLagradouro() {
        return lagradouro;
    }

    public void setLagradouro(String lagradouro) {
        this.lagradouro = lagradouro;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Anuncio> getListAnuncioUsuario() {
        return listAnuncioUsuario;
    }

    public void setListAnuncioUsuario(List<Anuncio> listAnuncioUsuario) {
        this.listAnuncioUsuario = listAnuncioUsuario;
    }

    public List<Mensagem> getListMensagemUsuario() {
        return listMensagemUsuario;
    }

    public void setListMensagemUsuario(List<Mensagem> listMensagemUsuario) {
        this.listMensagemUsuario = listMensagemUsuario;
    }

    public List<Chat> getListUsuarioChat() {
        return listUsuarioChat;
    }

    public void setListUsuarioChat(List<Chat> listUsuarioChat) {
        this.listUsuarioChat = listUsuarioChat;
    }

    public List<Solicita> getListUsuarioSolicita() {
        return listUsuarioSolicita;
    }

    public void setListUsuarioSolicita(List<Solicita> listUsuarioSolicita) {
        this.listUsuarioSolicita = listUsuarioSolicita;
    }

    

    
    
}
