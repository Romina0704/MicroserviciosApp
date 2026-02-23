package com.microservicio.cliente.controller;

import com.microservicio.cliente.entity.Cliente;
import com.microservicio.cliente.servicie.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // ← Saca este método del @RequestMapping("/clientes")
    // agregando la ruta completa aquí:
    @GetMapping("/vista")   // ← Cambia a /clientes/vista
    public String verPagina(){
        return "clientes";
    }

    @PostMapping
    @ResponseBody
    public Cliente crear(@RequestBody Cliente cliente){
        return service.guardar(cliente);
    }

    @GetMapping
    @ResponseBody
    public List<Cliente> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Cliente obtener(@PathVariable Long id){
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @GetMapping("/cedula/{cedula}")
    @ResponseBody
    public Cliente buscarCedula(@PathVariable String cedula){
        return service.buscarPorCedula(cedula)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }

}