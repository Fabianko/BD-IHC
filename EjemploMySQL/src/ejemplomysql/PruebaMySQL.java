package ejemplomysql;
import java.sql.*;

/*
 * PruebaMySQL.java
 *
 * Programa de prueba para conexión a una base de datos de MySQL.
 * Presupone que el servidor de base de datos está arrancado, disponible,
 * en el puerto por defecto.
 * El usuario y password de conexión con la base de datos debe cambiarse.
 * En la base de datos se supone que hay una base de datos llamada prueba y que
 * tiene una tabla persona con tres campos, de esta manera:
 * mysql> create database prueba;
 * mysql> use prueba;
 * mysql> create table persona (id smallint auto_increment, nombre varchar(60), 
 *      nacimiento date, primary key(id)); 
 * mysql> insert into persona 
 */


/**
 * Clase de prueba de conexión con una base de datos MySQL
 */
public class PruebaMySQL {
    
    /** 
     * Crea una instancia de la clase MySQL y realiza todo el código 
     * de conexión, consulta y muestra de resultados.
     */
    public PruebaMySQL() 
    {
        // Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            try (Connection conexion = DriverManager.getConnection (
                    "jdbc:mysql://localhost:3306/prueba", "root", "")) {
                Statement s = conexion.createStatement();
                
              /*  PreparedStatement preparedStatement = conexion.prepareStatement(
                        "insert into  persona (id_persona, nombre_persona) values (1,?),"
                                + "(2,?), (3,?), (4,?), (5,?), (6,?)");
            // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
            // Parameters start with 1
            preparedStatement.setString(1, "Juan");
            preparedStatement.setString(2, "Celso");
            preparedStatement.setString(3, "David");
            preparedStatement.setString(4, "Fabian");
            preparedStatement.setString(5, "Maximiliano");
            preparedStatement.setString(6, "Ricardo");
            preparedStatement.executeUpdate();*/
                
                
                // Se realiza la consulta. Los resultados se guardan en el
                // ResultSet rs
                
                ResultSet rs = s.executeQuery ("select * from persona");
                
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next())
                {
                    System.out.println (rs.getInt ("id_persona") + " " + rs.getString ("nombre_persona"));
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Método principal, instancia una clase PruebaMySQL
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new PruebaMySQL();
    }
    
}
