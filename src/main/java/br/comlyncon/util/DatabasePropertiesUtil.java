package br.comlyncon.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.IOException;

public class DatabasePropertiesUtil {
    private static final String DEFAULT_USER = "postgres";
    private static final String DEFAULT_PASSWORD = "postgres";
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_DATABASE = "channelstracker";
    private static final String DEFAULT_PORT = "5432";
    private static final String CONFIG_DIR = System.getProperty("user.home") + File.separator + ".trackerConfig";
    private static final String CONFIG_PROPERTIES_FILE = CONFIG_DIR + File.separator + "db.properties";


    public static PropertiesConfiguration getDatabaseProperties() throws IOException, ConfigurationException {
        File configFile = DatabasePropertiesUtil.getConfigurationFile();
        PropertiesConfiguration properties = new PropertiesConfiguration(configFile);
        if (properties.isEmpty()) {
            writeDefaultProperties(properties);
        }
        return properties;
    }

    private static File getConfigurationFile() throws IOException {
        createConfigurationDirectory();
        File configFile = new File(CONFIG_PROPERTIES_FILE);
        if (!configFile.isFile() && configFile.createNewFile()) {
            return configFile;
        } else {
            return configFile;
        }
    }

    private static void createConfigurationDirectory() {
        File configDir = new File(CONFIG_DIR);
        if (!configDir.isDirectory() && configDir.mkdir())
            System.out.println("Configuration directory created on: " + CONFIG_DIR);
    }

    private static void writeDefaultProperties(PropertiesConfiguration properties) throws ConfigurationException {
        properties.setProperty("db.user",DEFAULT_USER);
        properties.setProperty("db.password",DEFAULT_PASSWORD);
        properties.setProperty("db.host",DEFAULT_HOST);
        properties.setProperty("db.name",DEFAULT_DATABASE);
        properties.setProperty("db.port",DEFAULT_PORT);
        properties.save();
    }
}
