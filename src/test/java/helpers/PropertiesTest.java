package helpers;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PropertiesTest {

    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("app.properties"));
        String urlFromProperty = System.getProperties().getProperty("url");
        String nameFromProperty = System.getProperties().getProperty("name");
        System.out.println(urlFromProperty);
        System.out.println(nameFromProperty);
        // app.properties
        //url=https://at-sandbox.workbench.lanit.ru/
        //name=John Doe
    }

    @Test
    public void readFromConf(){
        String urlFromConf = ConfigProvider.URL;
        System.out.println(urlFromConf);
        Allure.step("Check admin permission", () -> Assertions.assertTrue(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")));
//        if(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")){
//            System.out.println("User has admin permission");
//        }
//        else {
//            System.out.println("User has no permission");
//        }
    }
}
