package project.model.da;

import src.tamrin03.model.entity.Brand;
import src.tamrin03.model.entity.Product;
import src.tamrin03.model.utils.JdbcProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDa implements AutoCloseable {
    private  Connection connection;
    private PreparedStatement preparedStatement;
    private  JdbcProvider jdbcProvider = new JdbcProvider();


    public ProductDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Product product) throws SQLException {
        product.setId(jdbcProvider.getNextId("PRODUCT_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUCT1 VALUES(?,?,?,?,?)"
        );
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getProduct());
        preparedStatement.setInt(3, product.getCount());
        preparedStatement.setString(5, product.getBrand().name()) ;
        preparedStatement.setDouble(4, product.getPrice());
        preparedStatement.execute();
    }

    public void edit(Product product) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE PRODUCT1 SET PRODUCT=?, COUNT=?, PRICE=?, BRAND=? WHERE ID=?"
        );

        preparedStatement.setString(1, product.getProduct());
        preparedStatement.setInt(2, product.getCount());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setString(4, product.getBrand().name());
        preparedStatement.setInt(5, product.getId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PRODUCT1 WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Product> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT1 ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> productList = new ArrayList<>();

        while (resultSet.next()) {
            Product product =
                    Product
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .product(resultSet.getString("NAME"))
                            .brand(Brand.valueOf(resultSet.getString("BRAND")))
                            .count(resultSet.getInt("COUNT"))
                            .price(resultSet.getInt("PRICE"))
                            .build();
            productList.add(product);
        }
        return productList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
