/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque.Infrastructure.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author max.silva
 */

public class Config {

    private static Properties prop;
    private static Config config;
    
    private Config(){
        try{
            if(prop == null){
                prop = new Properties();
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.properties");
                if(is == null){
                    throw new IOException("Não achou");
                }
                prop.load(is);
            }
            
        }catch(IOException e){
            throw new RuntimeException("Unable to access enviroment variables.",e);
        }
    }
    
    public static Config getInstance(){
        if(config == null){
            config = new Config();
        }
        return config;
    }
    
    public String getProperty(String Key){
        return prop.getProperty(Key);
    }
}
