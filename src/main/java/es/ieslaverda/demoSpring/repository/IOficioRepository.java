package es.ieslaverda.demoSpring.repository;

import es.ieslaverda.demoSpring.repository.model.Oficio;

import java.sql.SQLException;
import java.util.List;

public interface IOficioRepository {
    List<Oficio> getAllOficios() throws SQLException;
}
