package utils.common.constants;

import dataobjects.DataAssignLeave;
import dataobjects.User;

import java.io.File;

public class Constant {
    public static final String BROWSER_SETTING      = "browser-setting";
    public static final String BROWSER_SETTING_PATH = "src".concat(File.separator).concat("test").concat(File.separator).concat("resources").concat(File.separator).concat("browsers.setting.json");
    public static final String URL                  = "https://opensource-demo.orangehrmlive.com/";
    public static final int    DEFAULT_TIME_OUT     = 20;

    public static final User USER_ADMIN = new User("Admin", "admin123");


}
