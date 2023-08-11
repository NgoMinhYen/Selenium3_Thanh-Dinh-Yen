package utils.common.constants;

import dataobjects.DataAssignLeave;
import dataobjects.User;

import java.io.File;

public class Constant {
    public static final String BROWSER_SETTING      = "browser-setting";
    public static final String BROWSER_SETTING_PATH = "src".concat(File.separator).concat("test").concat(File.separator).concat("resources").concat(File.separator).concat("browsers.setting.json");
    public static final String URL                  = "http://18.232.153.220:10000/login";
    public static final int    DEFAULT_TIME_OUT     = 20;

    public static final User USER_ADMIN = new User("ad@vp.com", "password");

    public static String PROJECT = System.getProperty("user.dir");
    public static String TARGET = System.getProperty("user.dir").concat(File.separator).concat("target");
    public static String PATH = System.getProperty("user.dir") + "/src/test/resources/dataFileUpload/upload_01.png";


}
