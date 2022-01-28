package testing.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.junit.Assert;

public class Common {
    public static Properties loadPropertiesFile(String filename) {
        Properties props = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(filename);
            props.load(input);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return props;
    }

    public static List<String> convertStringToList(String str, String delim) {

        return Arrays.asList(str.split("\\s*" + delim + "\\s*"));

    }

    public static HashMap<Object, Object> generateKeyValue(String str, String delim1, String delim2) {
        List<String> keyValueL = Common.convertStringToList(str, delim1);
        HashMap<Object, Object> dataConverted = Common.generateKeyValue(keyValueL, delim2);
        return dataConverted;
    }

    public static HashMap<Object, Object> generateKeyValue(List<String> keyValueL, String delim) {
        HashMap<Object, Object> mapL = new HashMap<Object, Object>();
        int index;
        for (String temp : keyValueL) {
            index = temp.indexOf(":");
            if (index < 0)
                Assert.fail("Invalid input");
            mapL.put(temp.substring(0, index), temp.substring(index + 1, temp.length()));
        }
        return mapL;
    }

    public static String getRandomValue() {
        int length = 6;
        String charsToUse = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomValue = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomValue.append(charsToUse.charAt(random.nextInt(charsToUse.length())));
        }
        return randomValue.toString();
    }

}
