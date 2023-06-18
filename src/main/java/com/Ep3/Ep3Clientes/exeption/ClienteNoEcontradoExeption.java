package com.Ep3.Ep3Clientes.exeption;

public class ClienteNoEcontradoExeption extends RuntimeException{

    public ClienteNoEcontradoExeption(Long id){
        super("Cliente no existe");
    }
}
