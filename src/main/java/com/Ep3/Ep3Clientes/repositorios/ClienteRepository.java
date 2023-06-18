package com.Ep3.Ep3Clientes.repositorios;

import com.Ep3.Ep3Clientes.entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
