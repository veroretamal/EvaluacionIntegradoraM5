package repository;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//se utiliza la interface Repository para implementar el CRUD
public interface Repository<T>{
    //Create
    void create (T t) throws SQLException;

        //Read
    List<T> read() throws SQLException;

    //Update
    void update(T t) throws SQLException;

    //Delete
    void delete(int id) throws SQLException;


}
