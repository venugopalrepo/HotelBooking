package testing.models;

import testing.utility.Common;
import testing.utility.Constants;

import java.text.ParseException;
import java.util.HashMap;

public class BookingEntry {
    private static String firstname, surname, checkInDate, checkOutDate, price;
    private static boolean isDeposit;

    public static void setFirstname(String name) {
        firstname = name;
    }

    public static void setSurname(String name) {
        surname = name;
    }

    public static void setCheckInDate(String date) {
        checkInDate = date;
    }

    public static void setCheckOutDate(String date) {
        checkOutDate = date;
    }

    public static void setPrice(String value) {
        price = value;
    }

    public static void setIsDeposit(boolean value) {
        isDeposit = value;
    }

    public static String getFirstname() {
        return firstname;
    }

    public static String getSurname() {
        return surname;
    }

    public static String getCheckInDate() {
        return checkInDate;
    }

    public static String getCheckOutDate() {
        return checkOutDate;
    }

    public static String getPrice() {
        return price;
    }

    public static boolean getIsDeposit() {
        return isDeposit;
    }

    public static void setBookingDetails(String input) throws ParseException {
        HashMap<Object, Object> details = Common.generateKeyValue(input, Constants.DELIM, Constants.DELIM1);
        for (Object key : details.keySet()) {

            if (key.toString().equalsIgnoreCase("firstname")) {
                setFirstname(details.get(key).toString() + Common.getRandomValue());
            }
            if (key.toString().equalsIgnoreCase("surname")) {
                setSurname(details.get(key).toString());
            }
            if (key.toString().equalsIgnoreCase("checkInDate")) {
                setCheckInDate(details.get(key).toString());
            }
            if (key.toString().equalsIgnoreCase("checkOutDate")) {
                setCheckOutDate(details.get(key).toString());
            }
            if (key.toString().equalsIgnoreCase("price")) {
                setPrice(details.get(key).toString());
            }
            if (key.toString().equalsIgnoreCase("isDeposit")) {
                setIsDeposit(Boolean.parseBoolean(details.get(key).toString()));
            }
        }
    }
}
