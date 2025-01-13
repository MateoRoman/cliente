package com.espe.aula.services;

import com.espe.aula.model.entity.Cliente;
import com.espe.aula.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}