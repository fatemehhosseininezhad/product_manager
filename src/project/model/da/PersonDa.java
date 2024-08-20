package project.model.da;

import project.model.tools.JdbcProvider;
import project.model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDa implements AutoCloseable {
        private Connection connection;
        private PreparedStatement preparedStatement;

    public void save(Person person) throws SQLException {
//        connection = JdbcProvider.getJdbcProvider().getConnection();
//        preparedStatement = connection.prepareStatement("INSERT INTO");
//        preparedStatement.execute();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
