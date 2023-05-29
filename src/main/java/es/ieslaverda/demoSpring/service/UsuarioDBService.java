package es.ieslaverda.demoSpring.service;

import es.ieslaverda.demoSpring.repository.model.Usuario;
import es.ieslaverda.demoSpring.repository.UsuarioDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioDBService {

    @Autowired
    public UsuarioDBRepository repository;

    public List<Usuario> getAllUsuarios() throws SQLException {
        return repository.getAllUsuarios();
    }

    public Usuario getUsuarioById(int id) throws SQLException{
        return repository.getUsuarioById(id);
    }


    public Usuario addUsuario(Usuario usuario) throws SQLException{
    return repository.addUsuario(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) throws SQLException{
        return repository.updateUsuario(usuario);
    }

    public boolean deleteUsuarioById(int id) throws SQLException{
        return repository.deleteUsuario(id);
    }

}
