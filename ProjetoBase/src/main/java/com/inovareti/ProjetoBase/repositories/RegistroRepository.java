package com.inovareti.ProjetoBase.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inovareti.ProjetoBase.domain.Registro;

@Repository
public interface RegistroRepository extends MongoRepository<Registro,String>{

}
