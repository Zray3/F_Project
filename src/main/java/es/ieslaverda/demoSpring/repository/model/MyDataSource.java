package es.ieslaverda.demoSpring.repository.model;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class MyDataSource {

    public static DataSource getMySQLDataSource() {
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("jdbc:mysql://localhost:3306/java");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("1234");

        return mysqlDS;

    }

}
