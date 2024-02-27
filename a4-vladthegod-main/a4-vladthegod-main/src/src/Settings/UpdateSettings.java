package Settings;

import java.io.*;
import java.util.Properties;
public class UpdateSettings {
private static final String FILE_PATH= "settings.properties";

    public static void main(String[] args)
    {
        updateProperty("BirthdayCakeRepository","binary");
        updateProperty("BirthdayCakeFilePath","NewBirhdayCakes.bin");
    }

    private static void updateProperty(String key,String value)
    {
            Properties properties=new Properties();

        try (InputStream input = new FileInputStream(FILE_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty(key,value);//we uipdate it

        try (OutputStream output = new FileOutputStream(FILE_PATH)) {
            properties.store(output, "Updated properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
