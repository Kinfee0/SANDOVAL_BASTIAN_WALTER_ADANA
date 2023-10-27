package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontoloDaoMemoria implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontoloDaoMemoria.class);
    private List<Odontologo> odotologoRepository;

    public OdontoloDaoMemoria(List<Odontologo> odotologoRepository) {
        this.odotologoRepository = odotologoRepository;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        int id = odotologoRepository.size() + 1;
        odotologoRepository.add(odontologo);
        Odontologo odontologoRegistrado = new Odontologo(id,  odontologo.getNumeroMatricula(), odontologo.getNombre(),odontologo.getApellido());
        LOGGER.info("Odontologo Registrado: " + odontologoRegistrado);


        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {


        return odotologoRepository;
    }

}
