package util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
//se realiza la conexion a la base de datos de MySQL workbench
public class DBConnection {

    static int port = 3306;
    static String DBname = "alkewallet_M5";
    private final static String URL = "jdbc:mysql://localhost:" + port + "/" + DBname;
    private static String user = "root"; //bd usuario
    private static String pass = "310915"; //pass usuario bd
    private static BasicDataSource pool;


    //metodo para almacenar las configuraciones para la conexion
    public static BasicDataSource getPool() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource(); //creando un objeto
            pool.setUrl(URL); //envia URL como ruta de acceso
            pool.setUsername(user); //enviar usuario de la BD
            pool.setPassword(pass);//enviar password usuario BD
            pool.setInitialSize(3); //valor de los parámetros iniciales que recibirá
            pool.setMinIdle(3); // establece tiempo minimo de 3 segundos de espera
            pool.setMaxIdle(10);// establece tiempo maximo de 10 segundos de espera
        }
        return pool;
    }
    //metodo para obtener la conexion con la base de datos
    public static Connection getConnection() throws SQLException {
        return getPool().getConnection(); //retornar una conexion
    }

    //verificación por consola del resultado del metodo anterior
    public static void main(String[] args) throws SQLException {
        Connection pool = getConnection();
        if (pool == null) {
            System.out.println("Conexion fallida");
        } else {
            System.out.println("Conexion exitosa");
        }
    }
}

