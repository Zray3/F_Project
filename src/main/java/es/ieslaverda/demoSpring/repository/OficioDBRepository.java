package es.ieslaverda.demoSpring.repository;

import es.ieslaverda.demoSpring.repository.model.MyDataSource;
import es.ieslaverda.demoSpring.repository.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OficioDBRepository implements IOficioRepository {

    @Override
    public Usuario getUsuarioById(int id) throws SQLException {

        Usuario usuario;
        String sql = " {call obtenUsuario(?)}";

        try (Connection con = MyDataSource.getMySQLDataSource().getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            rs.next();
            usuario = Usuario.builder().id(rs.getInt(1)).nombre(rs.getString(2)).apellidos(rs.getString(3)).build();
        }
        return usuario;
    }

    public List<Usuario> getAllUsuarios() throws SQLException {
        ArrayList<Usuario> usuariosDB = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try(Connection connection = MyDataSource.getMySQLDataSource().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query)){

            while(rs.next()){
                usuariosDB.add(Usuario.builder().id(rs.getInt(1)).nombre(rs.getString(2)).apellidos(rs.getString(3)).build());
            }
        }

        return usuariosDB;
    }

}
