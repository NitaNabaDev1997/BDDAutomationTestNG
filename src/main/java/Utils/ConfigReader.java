package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;
    //return prop object
    public Properties initializeProperties() throws IOException {
        prop= new Properties();
        FileInputStream fileInputStream= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/config.properties");
        prop.load(fileInputStream);

        return prop;
    }
}
