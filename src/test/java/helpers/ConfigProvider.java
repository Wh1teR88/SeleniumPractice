package helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("app.conf");
    }

    String URL = readConfig().getString("url");
    Integer VERSION = readConfig().getInt("version");
    String ADMIN_LOGIN = readConfig().getString("usersParams.admin.login");
    String DEMO_PASSWORD = readConfig().getString("usersParams.demo.password");
    Boolean IS_DEMO_ADMIN = readConfig().getBoolean("usersParams.demo.isAdmin");
}
