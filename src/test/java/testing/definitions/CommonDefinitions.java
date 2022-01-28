package testing.definitions;


import cucumber.api.java.Before;
import testing.utility.Session;

public class CommonDefinitions {
    static boolean firstScenario = true;
    public static String env = "";

    @Before
    public void setup() {
        if (firstScenario) {
            firstScenario = false;
            if (System.getProperty("env") != null) {
                env = System.getProperty("env");
            }
            firstScenario = false;
            Session.setupEnvProps(env);
        }
    }
}
