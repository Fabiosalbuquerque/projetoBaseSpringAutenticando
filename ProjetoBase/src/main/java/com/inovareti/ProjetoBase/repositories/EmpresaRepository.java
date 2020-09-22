package com.inovareti.ProjetoBase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inovareti.ProjetoBase.domain.Empresa;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa,String>{

}
