package org.snoflo.dbconnection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class H2Config implements DBConfig {

    private String jdbcUrl;
    private String user;
    private String password;

    private final String DATABASE = "h2";

    @Override
    public void loadProperties() {

        Properties properties = new Properties();

        StringBuilder sb = new StringBuilder()
                .append("application")
                .append("-")
                .append(DATABASE)
                .append(".")
                .append("properties");

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(sb.toString())) {

            properties.load(input);

            this.jdbcUrl = properties.getProperty("jdbc.url");
            this.user = properties.getProperty("jdbc.user");
            this.password = properties.getProperty("jdbc.password");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getJdbcUrl() {
        return this.jdbcUrl;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

}
