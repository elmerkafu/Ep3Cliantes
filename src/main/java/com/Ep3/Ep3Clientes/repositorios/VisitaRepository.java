package com.Ep3.Ep3Clientes.repositorios;

import com.Ep3.Ep3Clientes.entidades.Clientes;
import com.Ep3.Ep3Clientes.entidades.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visitas, Long> {
    Visitas findByDniAfiliado(String dniAfiliado);
}
