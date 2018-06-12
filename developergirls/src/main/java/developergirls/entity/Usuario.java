package developergirls.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(  length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String nome;

    @Column(  length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String sobrenome;

    @Column( length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    
    @NotNull
    private Boolean ativo;

  
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date ultimaAlteracaoSenha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usuario_autoridade",joinColumns=
		{@JoinColumn(name="usuario_id")}, inverseJoinColumns=
		  {@JoinColumn(name="autoridade_id")})
  
    private List<Autoridade> listaAutoridade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void seNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean enabled) {
        this.ativo = enabled;
    }

    public List<Autoridade> getListaAutoridade() {
        return listaAutoridade;
    }

    public void setListaAutoridade(List<Autoridade> listaAutoridade) {
        this.listaAutoridade = listaAutoridade;
    }

    public Date getUltimaAlteracaoSenha() {
        return ultimaAlteracaoSenha;
    }

    public void setUltimaAlteracaoSenha(Date ultimaAlteracaoSenha) {
        this.ultimaAlteracaoSenha = ultimaAlteracaoSenha;
    }
}