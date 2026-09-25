package org.example;

import java.sql.Connection;

public interface DAO {
    Connection conectarse();
    String alumno_mayor_drama();
    String excusa_animal();
    String registros_sin_fecha();
    String registros_avamzados();
}
