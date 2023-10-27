package com.backend.parcial.test;

import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private OdontologoService odontologoService;

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("jdbc:h2:~/Parcial");
            connection = DriverManager.getConnection("jdbc:h2:~/Parcial;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaAgregarUnOntologo(){

        Odontologo odontologo = new Odontologo( 1, 142,"Nombre","Apellido");

        Odontologo odontologoRegistrado = OdontologoService.registrarOdontologo(odontologo);

        Assertions.assertTrue(odontologoRegistrado.getId() != 0);

    }

    @Test
    void deberiaRetornarUnaListaNoVacia(){

        assertFalse(odontologoService.listarOdontologos().isEmpty());

    }

}