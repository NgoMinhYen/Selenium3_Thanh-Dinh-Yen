package core.framework.driver;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Selenium webdriver properties
 * Load data from file -> convert to properties object
 *

 */
@Setter
@Getter
public class DriverProperty {
    private String              mode;
    private String              browser;
    private String              driverPath;
    private List<String>        arguments    = new ArrayList<>();
    private Map<String, String> prefs        = new HashMap<>();
    private Map<String, String> capabilities = new HashMap<>();
    private String              remoteUrl;
    private boolean             headless;
    private Boolean             isRemote;

    public DriverProperty() {
    }

    public void setIsRemote(Boolean remote){
        this.isRemote = remote;
        setMode(getIsRemote() == true ?  "Remote" : "Local");
    }
}
