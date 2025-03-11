/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controleestoque;

import controleestoque.Infrastructure.Config.Config;
import controleestoque.Infrastructure.Drivers.ConnectionFactory;



/**
 *
 * @author max.silva
 */
public class Controleestoque {

    public static void main(String[] args) {
    
        Config instance = Config.getInstance();
        
        System.out.println(instance.getProperty("database.URL"));
    }
}
