package com.Ep3.Ep3Clientes;

import com.Ep3.Ep3Clientes.entidades.Clientes;
import com.Ep3.Ep3Clientes.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ApiClientes")
public class Api {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/lista-clientes")
    public List<Clientes> get(){
        return clienteRepository.findAll();
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/add-Cliente")
    public ResponseEntity<HashMap<String, String>> add(){
        HashMap<String,String> resp = new HashMap<>();

        try {
            Clientes clientes = new Clientes();
            clientes.setApellido("Paucarpura");
            clientes.setCelular("967469757");
            clientes.setCorreo("correo2@gmail.com");
            clientes.setNombre("Elmer kafu");
            clientes.setFechaCreacion(LocalDate.now().toString());

            clienteRepository.save(clientes);

            resp.put("Codigo", "200");
            resp.put("mensaje", String.format("Cliente añadido", clientes.getNombre()));

            return ResponseEntity.ok(resp);
        }catch (Exception e){
            resp.put("Codigo", "500");
            resp.put("mensaje", String.format("error", e.getMessage()));
            return ResponseEntity.internalServerError().body(resp);
        }
    }
}
