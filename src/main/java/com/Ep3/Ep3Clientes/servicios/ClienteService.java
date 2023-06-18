package com.Ep3.Ep3Clientes.servicios;

import com.Ep3.Ep3Clientes.entidades.Clientes;
import com.Ep3.Ep3Clientes.exeption.ClienteNoEcontradoExeption;
import com.Ep3.Ep3Clientes.repositorios.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    public List<Clientes> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public Clientes obtenerPorId(Long id) throws Exception{
        Optional<Clientes> clientes = clienteRepository.findById(id);
        if (clientes.isPresent()){
            return clientes.get();
        }else {
            throw new Exception("El alumno no existe");
        }
    }

    public  Clientes addCliente(Clientes cliente){
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id){
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow(
                ()-> new ClienteNoEcontradoExeption(id)
        ));
    }
}
