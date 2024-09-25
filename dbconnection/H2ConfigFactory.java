package org.snoflo.dbconnection;

public class H2ConfigFactory implements DBConfigFactory {

	@Override
	public DBConfig createDBConfig() {
        DBConfig h2Config = new H2Config();
        h2Config.loadProperties();
        return h2Config;
	}
    
}
