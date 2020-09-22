package com.inovareti.ProjetoBase.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inovareti.ProjetoBase.domain.Funcionario;
import com.inovareti.ProjetoBase.repositories.FuncionarioRepository;
import com.inovareti.ProjetoBase.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private FuncionarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Funcionario func = repo.findByEmail(email);
		
		if(func == null) {
			throw new UsernameNotFoundException(email);
		}else {
			return new UserSS(func.getId(),func.getEmail(),func.getSenha(),func.getPerfis());
		}
		
	}

}
