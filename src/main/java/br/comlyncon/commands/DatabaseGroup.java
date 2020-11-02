package br.comlyncon.commands;

import br.comlyncon.models.DatabaseProperties;
import org.apache.commons.configuration.ConfigurationException;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;

@ShellComponent()
@ShellCommandGroup("Database Configuration")
public class DatabaseGroup {

    @ShellMethod("Command to configure database credentials")
    public String databaseConfigure (@ShellOption(defaultValue = "") String user,@ShellOption(defaultValue = "") String host,
                               @ShellOption(defaultValue = "")String port,@ShellOption(defaultValue = "")String name,
                               @ShellOption(defaultValue = "")String password) throws IOException, ConfigurationException {
        DatabaseProperties databaseProperties = new DatabaseProperties(user,host,port,name,password);
        databaseProperties.saveChanges();
        return "All changes successfully executed, restart the application to apply changes!";
    }

    @ShellMethod("Command to dump database configuration information")
    public void databaseInfo() throws IOException, ConfigurationException {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        System.out.println("DataBase properties Configured");
        System.out.println("Database name = " + databaseProperties.getName());
        System.out.println("Database host = " + databaseProperties.getHost());
        System.out.println("Database port = " + databaseProperties.getPort());
        System.out.println("Database user = " + databaseProperties.getUser());
        System.out.println("Database password = " + databaseProperties.getPassword());
    }


}
