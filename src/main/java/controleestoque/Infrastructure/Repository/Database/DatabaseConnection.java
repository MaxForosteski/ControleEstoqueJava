
package controleestoque.Infrastructure.Repository.Database;

import java.sql.Connection;

/**
 *
 * @author max.silva
 */
public interface DatabaseConnection {
    Connection getConnection();
}
