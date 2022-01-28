package testing.utility;

import java.util.Properties;

public class Session {
    private static Properties urlProps;
    private static String baseUrl = "";

    public static void setupEnvProps(String env) {
        urlProps = Common.loadPropertiesFile(Constants.ENVIRONMENT_LOCATION + env + ".url.properties");
        baseUrl = urlProps.getProperty("url");
    }

    public static Properties getUrlProps() {
        return urlProps;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}
