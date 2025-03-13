/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Infrastructure.Drivers;

import controleestoque.Infrastructure.Repository.Database.DatabaseConnection;
import controleestoque.Infrastructure.Config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author max.silva
 */


public class ConnectionFactory implements DatabaseConnection {
    Config config = Config.getInstance();
    
    private String URL;
    private String USER;
    private String PASSWORD;
    
    public ConnectionFactory(){
        try{
            this.URL = config.getProperty("database.URL");
            this.USER = config.getProperty("database.USER");
            this.PASSWORD = config.getProperty("database.PASSWORD");
        } catch(Exception e){
            throw new RuntimeException("Error on load properties",e);
        }
    }
    
    @Override
    public Connection getConnection() {
        try {
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred while trying to connect with database", e);
        }
    }

}
