package data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    static {
//        config.setJdbcUrl("jdbc:h2:./userDb;DB_CLOSE_DELAY=-1;INIT=runscript from 'classpath:/data.sql'");
        config.setJdbcUrl("jdbc:h2:./userDb;DB_CLOSE_DELAY=-1");
        config.setUsername("user");
        config.setPassword("password");
        dataSource = new HikariDataSource(config);
    }

    private DataSource() {

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
