package es.ieslaverda.demoSpring.repository;

import es.ieslaverda.demoSpring.repository.model.MyDataSource;
import es.ieslaverda.demoSpring.repository.model.Oficio;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OficioDBRepository implements IOficioRepository {




    public List<Oficio> getAllOficios() throws SQLException {
        ArrayList<Oficio> oficiosDB = new ArrayList<>();
        String query = "{call obtener_oficios(?)}";

        try(Connection connection = MyDataSource.getMySQLDataSource().getConnection(); CallableStatement cs = connection.prepareCall(query)){
            cs.setNull(1,4);
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                oficiosDB.add(Oficio.builder().idOficio(rs.getInt(1)).descripcion(rs.getString(2)).imageUrl(rs.getString(4)).build());
            }
        }

        return oficiosDB;
    }


}
