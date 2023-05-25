package es.ieslaverda.demoSpring.service;

import es.ieslaverda.demoSpring.repository.OficioDBRepository;
import es.ieslaverda.demoSpring.repository.model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OficioDBService {

    @Autowired
    public OficioDBRepository repository;

    public List<Oficio> getAllOficios() throws SQLException {
        return repository.getAllOficios();
    }
}
