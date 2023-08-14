package utils.email;

import utils.common.Utilities;

public class EmailConfig {
    public static final String HOST = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "duyenthanh412@gmail.com";
    public static final String PASSWORD = "hkoeououcrfoccrq";

    public static final String[] TO = {"minhyen1311414@gmail.com"};
    public static final String SUBJECT = "Test Result Report " + Utilities.toDate("MM/dd/yyyy");
    public static final String MESSAGE = "\"Please refer to the attached file for more details\"";
}