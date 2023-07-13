package core.framework.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverProperties {
    @JsonProperty("windows.chrome.local")
    private DriverProperty chromeLocal;
    @JsonProperty("windows.chrome.local.headless")
    private DriverProperty chromeLocalHeadless;
    @JsonProperty("windows.chrome.remote")
    private DriverProperty chromeRemote;
    @JsonProperty("windows.chrome.remote.headless")
    private DriverProperty chromeRemoteHeadless;
    @JsonProperty("windows.firefox.local")
    private DriverProperty firefoxLocal;
    @JsonProperty("windows.firefox.local.headless")
    private DriverProperty firefoxLocalHeadless;
    @JsonProperty("windows.firefox.remote")
    private DriverProperty firefoxRemote;
    @JsonProperty("windows.firefox.remote.headless")
    private DriverProperty firefoxRemoteHeadless;
    @JsonProperty("windows.edge.local")
    private DriverProperty edgeLocal;
    @JsonProperty("windows.edge.local.headless")
    private DriverProperty edgeLocalHeadless;
    @JsonProperty("windows.edge.remote")
    private DriverProperty edgeRemote;
    @JsonProperty("windows.edge.remote.headless")
    private DriverProperty edgeRemoteHeadless;
    @JsonProperty("linux.chrome.local")
    private DriverProperty linuxChromeLocal;
    @JsonProperty("linux.chrome.local.headless")
    private DriverProperty linuxChromeLocalHeadless;
    @JsonProperty("linux.chrome.remote")
    private DriverProperty linuxChromeRemote;
    @JsonProperty("linux.chrome.remote.headless")
    private DriverProperty linuxChromeRemoteHeadless;
    @JsonProperty("linux.firefox.local")
    private DriverProperty linuxFirefoxLocal;
    @JsonProperty("linux.firefox.local.headless")
    private DriverProperty linuxFirefoxLocalHeadless;
    @JsonProperty("linux.firefox.remote")
    private DriverProperty linuxFirefoxRemote;
    @JsonProperty("linux.firefox.remote.headless")
    private DriverProperty linuxFirefoxRemoteHeadless;
    @JsonProperty("macos.chrome.local")
    private DriverProperty macosChromeLocal;
    @JsonProperty("macos.chrome.local.headless")
    private DriverProperty macosChromeLocalHeadless;
    @JsonProperty("macos.chrome.remote")
    private DriverProperty macosChromeRemote;
    @JsonProperty("macos.chrome.remote.headless")
    private DriverProperty macosChromeRemoteHeadless;
    @JsonProperty("saucelabs.safari.remote")
    private DriverProperty safariRemote;

    public DriverProperty getProperty(String type){
        switch (type){
            case "windows.chrome.local": return getChromeLocal();
        }
        return null;
    }
}
