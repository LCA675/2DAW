package com.u4p3.lauracalle.repositorio;

import com.u4p3.lauracalle.modelo.Caseta;
import com.u4p3.lauracalle.modelo.ClaveCaseta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasetaRepositorio extends JpaRepository<Caseta, ClaveCaseta> {


}
