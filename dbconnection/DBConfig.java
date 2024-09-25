package org.snoflo.dbconnection;

public interface DBConfig {
    
    void loadProperties();

    String getJdbcUrl();

    String getUser();

    String getPassword();
}
