package com.u4p3.lauracalle.servicio;


import com.u4p3.lauracalle.modelo.Caseta;
import com.u4p3.lauracalle.modelo.ClaveCaseta;
import com.u4p3.lauracalle.repositorio.CasetaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CasetaService {

    private final CasetaRepositorio casetaRepositorio;


    public CasetaService(CasetaRepositorio casetaRepositorio) {
        this.casetaRepositorio = casetaRepositorio;
    }

    public List<Caseta> obtenerTodos() {
        return casetaRepositorio.findAllOrdenadosPorCalle();
    }
//Funcion que guarda los datos de la caseta nueva que vamos a registrar con elformulario
    @Transactional
    public Caseta registrar(
            String calle,
            Integer numeroCalle,
            Long numSocios,
            String nombre,
            String descripcion,
            String foto,
            BigDecimal metrosCuadrados,
            LocalDate fechaAlta,
            boolean publica) {
        Caseta cas = new Caseta();
        ClaveCaseta clave = new ClaveCaseta(calle, numeroCalle);
        //Controlamos que no se escriba casetas con la misma calle y numero
        if (casetaRepositorio.existsById(clave)) {
            throw new CasetaDuplicadaException(
                    "Ya existe una caseta en " + calle + ", número " + numeroCalle + ".");
        }
        cas.setCalle(calle);
        cas.setNumeroCalle(numeroCalle);
        cas.setNumSocios(numSocios);
        cas.setNombre(nombre);
        cas.setDescripcion(descripcion);
        cas.setFoto(foto);
        cas.setMetrosCuadrados(metrosCuadrados);
        cas.setFechaAlta(fechaAlta);
        cas.setPublica(publica);

        return casetaRepositorio.save(cas);
    }

}


