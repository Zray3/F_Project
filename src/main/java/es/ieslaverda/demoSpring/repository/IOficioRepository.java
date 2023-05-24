package es.ieslaverda.demoSpring.repository;

import es.ieslaverda.demoSpring.repository.model.Oficio;
import es.ieslaverda.demoSpring.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IOficioRepository {

    String getImageUrl(int id);
    Oficio getOficioById(int id) throws SQLException;
    List<Oficio> getAllOficios() throws SQLException;
}
