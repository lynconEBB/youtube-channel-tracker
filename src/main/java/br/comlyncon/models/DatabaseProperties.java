package br.comlyncon.models;

import br.comlyncon.util.DatabasePropertiesUtil;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.IOException;

public class DatabaseProperties {
    private final PropertiesConfiguration propertiesConfiguration;

    public DatabaseProperties(String user,String host,String port,String name,String password) throws IOException, ConfigurationException {
        this.propertiesConfiguration = DatabasePropertiesUtil.getDatabaseProperties();
        this.setHost(host);
        this.setName(name);
        this.setPort(port);
        this.setUser(user);
        this.setPassword(password);
    }
    public void saveChanges() throws ConfigurationException {
        this.propertiesConfiguration.save();
    }

    public DatabaseProperties() throws IOException, ConfigurationException {
        this.propertiesConfiguration = DatabasePropertiesUtil.getDatabaseProperties();
    }

    public String getHost() {
        return (String) propertiesConfiguration.getProperty("db.host");
    }

    public void setHost(String host) {
        if(!host.equals(""))
            this.propertiesConfiguration.setProperty("db.host",host);
    }

    public String getPassword() {
        return (String) propertiesConfiguration.getProperty("db.password");
    }

    public void setPassword(String password) {
        if(!password.equals(""))
            this.propertiesConfiguration.setProperty("db.password",password);
    }

    public String getPort() {
        return (String) propertiesConfiguration.getProperty("db.port");
    }

    public void setPort(String port) {
        if(!port.equals(""))
            this.propertiesConfiguration.setProperty("db.port",port);
    }

    public String getUser() {
        return (String) propertiesConfiguration.getProperty("db.user");
    }

    public void setUser(String user) {
        if(!user.equals(""))
            this.propertiesConfiguration.setProperty("db.user",user);
    }

    public String getName() {
        return (String) propertiesConfiguration.getProperty("db.name");
    }

    public void setName(String name) {
        if(!name.equals(""))
            this.propertiesConfiguration.setProperty("db.name",name);
    }

}
