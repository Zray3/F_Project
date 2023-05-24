package es.ieslaverda.demoSpring.repository;

import es.ieslaverda.demoSpring.repository.IUsuarioRepository;
import es.ieslaverda.demoSpring.repository.model.MyDataSource;
import es.ieslaverda.demoSpring.repository.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDBRepository implements IUsuarioRepository {

    @Override
    public Usuario addUsuario(Usuario usuario) throws SQLException {

        int actualizados=0;
        DataSource ds = MyDataSource.getMySQLDataSource();
        String sql = "{call insertEmpleado(?,?,?,?,?,?,?,?,?)}";

        try(Connection connection = ds.getConnection();
            CallableStatement cs = connection.prepareCall(sql);){

            actualizados = cs.executeUpdate(sql);

            return usuario;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws SQLException {


        return null;
    }

    @Override
    public boolean deleteUsuario(int id) throws SQLException {

        int actualizados=0;
        DataSource ds = MyDataSource.getMySQLDataSource();

        try(Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();){

            String query = "DELETE FROM empleado WHERE id = '" + id + "'";
            actualizados = statement.executeUpdate(query);
            return true;

        } catch (SQLException e){
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public Usuario getUsuarioById(int id) throws SQLException {

        Usuario usuario = null;
        DataSource ds = MyDataSource.getMySQLDataSource();
        String query = "select * from empleado where id = ?";

        try(Connection con = ds.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);
        ){

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                usuario = new Usuario(rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellidos"));
            }
        } catch (SQLException exception){
            exception.printStackTrace();
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
