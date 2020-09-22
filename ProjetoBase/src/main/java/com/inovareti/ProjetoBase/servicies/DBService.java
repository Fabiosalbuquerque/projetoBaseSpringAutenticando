package com.inovareti.ProjetoBase.servicies;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inovareti.ProjetoBase.domain.Empresa;
import com.inovareti.ProjetoBase.domain.Funcionario;
import com.inovareti.ProjetoBase.enums.Perfil;
import com.inovareti.ProjetoBase.repositories.EmpresaRepository;
import com.inovareti.ProjetoBase.repositories.FuncionarioRepository;

@Service
public class DBService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instantiateTestDatabase() throws ParseException {
		System.out.println("iniciando banco de  dados");
		
		empresaRepository.deleteAll();
		Empresa empresa1= new Empresa(null,"Empresa Fabio","82827332");
		empresaRepository.saveAll(Arrays.asList(empresa1));
		
		funcionarioRepository.deleteAll();
		
		Funcionario func1= new Funcionario(null,"Fabio Silva de Albuquerque","fabiosalbuquerque@gmail.com","05284255798",pe.encode("123"),null);
		func1.setEmpresa(empresa1);
		func1.addPerfil(Perfil.ADMIN);
		
		funcionarioRepository.saveAll(Arrays.asList(func1));
		
		
	}
}
