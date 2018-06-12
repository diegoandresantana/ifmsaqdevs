package br.com.timao.config.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.timao.entity.Autoridade;
import br.com.timao.entity.Usuario;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }
 
    public static JwtUser create(Usuario user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getNome(),
                user.getSobrenome(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getListaAutoridade()),
                user.getAtivo(),
                user.getUltimaAlteracaoSenha()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Autoridade> listaAutoridade) {
        return listaAutoridade.stream()
                .map(Autoridade -> new SimpleGrantedAuthority(Autoridade.getNome()))
                .collect(Collectors.toList());
    }
}
