package com.espe.aula.services;

import com.espe.aula.model.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    void deleteById(Long id);
}
