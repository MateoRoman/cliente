package com.espe.aula.controllers;

import com.espe.aula.model.entity.Cliente;
import com.espe.aula.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aula")
public class ClienteController {
    @Autowired
    private ClienteService service;

    // Endpoint para crear un cliente
    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = service.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    // Endpoint para listar todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = service.findAll();
        return ResponseEntity.ok(clientes);
    }

    // Endpoint para obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> clienteOpt = service.findById(id);
        return clienteOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint para actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteExistente = service.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente clienteActualizado = clienteExistente.get();
            clienteActualizado.setNombre(cliente.getNombre());
            clienteActualizado.setEmail(cliente.getEmail());
            clienteActualizado.setTelefono(cliente.getTelefono());
            clienteActualizado.setFechaRegistro(cliente.getFechaRegistro());
            return ResponseEntity.ok(service.save(clienteActualizado));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Endpoint para eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Optional<Cliente> clienteExistente = service.findById(id);

        if (clienteExistente.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
