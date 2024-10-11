package Base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestData {

    public String email;
    public String password;
    public String wrongPassword;
    public String wrongMail;
    public String unregisterMail;
    public String longPassword;
    public String phoneNumber;
    public String insufficientPassword;


    public TestData(){
        Properties prop = new Properties();

        try {
            InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        email = prop.getProperty("EMAIL");
        password = prop.getProperty("PASSWORD");
        wrongPassword = prop.getProperty("WRONG_PASSWORD");
        wrongMail = prop.getProperty("WRONG_MAIL");
        unregisterMail = prop.getProperty("UNREGISTER_MAIL");
        longPassword = prop.getProperty("LONG_PASSWORD");
        phoneNumber = prop.getProperty("PHONE_NUMBER");
        insufficientPassword = prop.getProperty("INSUFFICIENT_PASSWORD");
    }
}
