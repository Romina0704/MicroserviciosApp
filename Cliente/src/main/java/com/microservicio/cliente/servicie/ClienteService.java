package com.microservicio.cliente.servicie;

import com.microservicio.cliente.entity.Cliente;
import com.microservicio.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public Cliente guardar(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> listar(){
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Optional<Cliente> buscarPorCedula(String cedula){
        return repository.findByCedula(cedula);
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}