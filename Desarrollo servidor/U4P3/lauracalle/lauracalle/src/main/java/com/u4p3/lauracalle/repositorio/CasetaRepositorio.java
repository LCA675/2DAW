package com.u4p3.lauracalle.repositorio;

import com.u4p3.lauracalle.modelo.Caseta;
import com.u4p3.lauracalle.modelo.ClaveCaseta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CasetaRepositorio extends JpaRepository<Caseta, ClaveCaseta> {

//    Select para coger todas las casetas ordenadas por la calle y el numero
    @Query("SELECT c FROM Caseta c ORDER BY c.calle, c.numeroCalle ASC")
    List<Caseta> findAllOrdenadosPorCalle();
}
