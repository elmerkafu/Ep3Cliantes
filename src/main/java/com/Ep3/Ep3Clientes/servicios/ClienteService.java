package com.Ep3.Ep3Clientes.servicios;

import com.Ep3.Ep3Clientes.entidades.Clientes;
import com.Ep3.Ep3Clientes.entidades.Visitas;
import com.Ep3.Ep3Clientes.exeption.ClienteNoEcontradoExeption;
import com.Ep3.Ep3Clientes.repositorios.ClienteRepository;
import com.Ep3.Ep3Clientes.repositorios.VisitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final VisitaRepository visitaRepository;
    public List<Clientes> obtenerClientes(){
        return clienteRepository.findAll();
    }

    public List<Visitas> obtenerVisitas(){
        return visitaRepository.findAll();
    }
    public Clientes obtenerPorId(Long id) throws Exception{
        Optional<Clientes> clientes = clienteRepository.findById(id);
        if (clientes.isPresent()){
            return clientes.get();
        }else {
            throw new Exception("El alumno no existe");
        }
    }

    public Visitas obtenerPorIdVisitas(Long id) throws Exception{
        Optional<Visitas> visitas = visitaRepository.findById(id);
        if (visitas.isPresent()){
            return visitas.get();
        }else {
            throw new Exception("La visita no existe");
        }
    }

    public  Clientes addCliente(Clientes cliente){
        return clienteRepository.save(cliente);
    }

    public  Visitas addVisita(Visitas visita){

        String dniAfiliado = visita.getDniAfiliado();
        Visitas visitaExistente = visitaRepository.findByDniAfiliado(dniAfiliado);
        if (visitaExistente != null) {
            throw new RuntimeException("El DNI ya está registrado");
        }

        return visitaRepository.save(visita);
    }

    public void eliminar(Long id){
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow(
                ()-> new ClienteNoEcontradoExeption(id)
        ));
    }

    public void eliminarVisita(Long id){
        visitaRepository.delete(visitaRepository.findById(id).orElseThrow(
                ()-> new ClienteNoEcontradoExeption(id)
        ));
    }
}
