package utils.common.constants;

import dataobjects.DataAssignLeave;
import dataobjects.User;

import java.io.File;

public class Constant {
    public static final String BROWSER_SETTING      = "browser-setting";
    public static final String BROWSER_SETTING_PATH = "src".concat(File.separator).concat("test").concat(File.separator).concat("resources").concat(File.separator).concat("browsers.setting.json");
    public static final String URL                  = "https://www.digikey.com/";
    public static final int    DEFAULT_TIME_OUT     = 20;

    public static final User USER_ADMIN = new User("minhyen1311414@gmail.com", "Selenium3@");

    public static String PROJECT = System.getProperty("user.dir");
    public static String TARGET = System.getProperty("user.dir").concat(File.separator).concat("target");


}
