package Settings;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
public class Settings extends IOException {
    private static Properties properties;

    public Settings()
    {
        properties=new Properties();
        try {
            FileInputStream input = new FileInputStream("settings.properties");
            properties.load(input);
        }catch (IOException E)
        {
            E.printStackTrace();
        }
    }
    public static String getPropertyTest(String key)
    {
        return properties.getProperty(key);
    }
    public void updateProperty(String key,String value)
    {
        properties.setProperty(key,value);
        try (OutputStream output = new FileOutputStream("settings.properties")) {
            properties.store(output, "Updated properties");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
