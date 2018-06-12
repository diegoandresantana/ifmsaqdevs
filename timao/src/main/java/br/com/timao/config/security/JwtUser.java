package br.com.timao.config.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String nome;
    private final String sobrenome;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean ativo;
    private final Date ultimaAlteracaoSenha;

    public JwtUser(
          Long id,
          String username,
          String nome,
          String sobrenome,
          String email,
          String password, Collection<? extends GrantedAuthority> authorities,
          boolean ativo,
          Date ultimaAlteracaoSenha
    ) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.ativo = ativo;
        this.ultimaAlteracaoSenha = ultimaAlteracaoSenha;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

     

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public boolean isAtivo() {
		return ativo;
	}
	 @JsonIgnore
	public Date getUltimaAlteracaoSenha() {
		return ultimaAlteracaoSenha;
	}

   
     
}
