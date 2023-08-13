package utils.email;

import utils.common.Utilities;

public class EmailConfig {
    public static final String HOST = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "@gmail.com";
    public static final String PASSWORD = "password";

    public static final String[] TO = {"@gmail.com"};
    public static final String SUBJECT = "Test Result Report " + Utilities.toDate("MM/dd/yyyy");
}