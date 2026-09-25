package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Consulta implements DAO {
    private int id;
    private String alumno;
    private String curso;
    private String excusa;
    private int dias_retraso;
    private int credibilidad;
    private String fecha_entrega;
    private int aprobada_por_profesor;
    private int nivel_drama;


    public Consulta(int nivel_drama, int aprobada_por_profesor, String fecha_entrega, int credibilidad, int dias_retraso, String excusa, String curso, String alumno, int id) {
        this.nivel_drama = nivel_drama;
        this.aprobada_por_profesor = aprobada_por_profesor;
        this.fecha_entrega = fecha_entrega;
        this.credibilidad = credibilidad;
        this.dias_retraso = dias_retraso;
        this.excusa = excusa;
        this.curso = curso;
        this.alumno = alumno;
        this.id = id;
    }

    public Consulta() {
        this.id = 0;
        this.alumno = "alumno";
        this.curso = "curso";
        this.excusa = "excusa";
        this.dias_retraso = 0;
        this.credibilidad = 0;
        this.fecha_entrega = "1/1/2001";
        this.aprobada_por_profesor = 0;
        this.nivel_drama = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getExcusa() {
        return excusa;
    }

    public void setExcusa(String excusa) {
        this.excusa = excusa;
    }

    public int getDias_retraso() {
        return dias_retraso;
    }

    public void setDias_retraso(int dias_retraso) {
        this.dias_retraso = dias_retraso;
    }

    public int getCredibilidad() {
        return credibilidad;
    }

    public void setCredibilidad(int credibilidad) {
        this.credibilidad = credibilidad;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getAprobada_por_profesor() {
        return aprobada_por_profesor;
    }

    public void setAprobada_por_profesor(int aprobada_por_profesor) {
        this.aprobada_por_profesor = aprobada_por_profesor;
    }

    public int getNivel_drama() {
        return nivel_drama;
    }

    public void setNivel_drama(int nivel_drama) {
        this.nivel_drama = nivel_drama;
    }


    @Override
    public Connection conectarse() {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        if (conn == null) {
            System.out.println("No se ha podido establecer conexión con la base de datos.");
            return null;
        }
        return conn;
    }

    @Override
    public String alumno_mayor_drama() {
        Connection conn = conectarse();
        if (conn == null) {
            return "No se pudo ejecutar la consulta porque no hay conexión a la base de datos.";
        }

        String sql = "SELECT ALUMNO, EXCUSA, DIAS_RETRASO, NIVEL_DRAMA FROM excusa_entrega ORDER BY NIVEL_DRAMA DESC";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String alumno = rs.getString("ALUMNO");
                String excusa = rs.getString("EXCUSA");
                int diasRetraso = rs.getInt("DIAS_RETRASO");
                int nivelDrama = rs.getInt("NIVEL_DRAMA");

                System.out.println("alumno: " + alumno + " | excusa: " + excusa +
                        " | dias_retraso: " + diasRetraso + " | nivel_drama: " + nivelDrama);
            }

        } catch (Exception e) {
            System.err.println("Error al consultar: " + e.getMessage());
            return "Error al consultar: " + e.getMessage();
        }

        return sql;
    }

    @Override
    public String excusa_animal() {

        Connection conn = conectarse();
        if (conn == null) {
            return "No se pudo ejecutar la consulta porque no hay conexión a la base de datos.";
        }
        String sql = "SELECT ALUMNO, EXCUSA, DIAS_RETRASO FROM excusa_entrega WHERE (UPPER(EXCUSA) LIKE '%PERRO%' OR UPPER(EXCUSA) LIKE '%GATO%') AND DIAS_RETRASO BETWEEN 2 AND 6 ORDER BY DIAS_RETRASO";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String alumno = rs.getString("ALUMNO");
                String excusa = rs.getString("EXCUSA");
                int diasRetraso = rs.getInt("DIAS_RETRASO");

                System.out.println("alumno: " + alumno + " | excusa: " + excusa +
                        " | dias_retraso: " + diasRetraso );
            }

        } catch (Exception e) {
            System.err.println("Error al consultar: " + e.getMessage());
            return "Error al consultar: " + e.getMessage();
        }
        return sql;
    }

    @Override
    public String registros_sin_fecha() {
        Connection conn = conectarse();
        if (conn == null) {
            return "No se pudo ejecutar la consulta porque no hay conexión a la base de datos.";
        }
        String sql = "SELECT * FROM excusa_entrega WHERE FECHA_ENTREGA IS NULL AND (CREDIBILIDAD < 4 OR NIVEL_DRAMA >= 9)";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String alumno = rs.getString("ALUMNO");
                String excusa = rs.getString("EXCUSA");
                int diasRetraso = rs.getInt("DIAS_RETRASO");
                int credibilidad = rs.getInt("credibilidad");
                int aprobada_por_profesor = rs.getInt("aprobada_por_profesor");
                int nivel_drama = rs.getInt("nivel_drama");

                System.out.println("id "+id+ "alumno: " + alumno + " | excusa: " + excusa + " | dias_retraso: " + diasRetraso
                +"Credibilidad"+credibilidad+"aprobada por profesor" +aprobada_por_profesor+"nivel de drama"+nivel_drama);
            }

        } catch (Exception e) {
            System.err.println("Error al consultar: " + e.getMessage());
            return "Error al consultar: " + e.getMessage();
        }
        return sql;
    }

    @Override
    public String registros_avamzados() {
        Connection conn = conectarse();
        if (conn == null) {
            return "No se pudo ejecutar la consulta porque no hay conexión a la base de datos.";
        }
        String sql = "SELECT * FROM excusa_entrega WHERE (NIVEL_DRAMA >= 8 AND CREDIBILIDAD <= 3) OR ((DIAS_RETRASO BETWEEN 2 AND 5) AND UPPER(EXCUSA) LIKE '%PERRO%')";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String alumno = rs.getString("ALUMNO");
                String excusa = rs.getString("EXCUSA");
                int diasRetraso = rs.getInt("DIAS_RETRASO");
                int credibilidad = rs.getInt("credibilidad");
                int aprobada_por_profesor = rs.getInt("aprobada_por_profesor");
                int nivel_drama = rs.getInt("nivel_drama");

                System.out.println("id"+id+ "alumno: " + alumno + " | excusa: " + excusa + " | dias_retraso: " + diasRetraso
                        +"Credibilidad"+credibilidad+"aprobada por profesor" +aprobada_por_profesor+"nivel de drama"+nivel_drama);
            }

        } catch (Exception e) {
            System.err.println("Error al consultar: " + e.getMessage());
            return "Error al consultar: " + e.getMessage();
        }
        return sql;
    }
}






















