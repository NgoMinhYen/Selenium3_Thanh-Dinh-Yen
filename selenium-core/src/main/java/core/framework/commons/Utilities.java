package core.framework.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import core.framework.driver.DriverProperty;
import core.framework.driver.DriverProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Utilities {
    private static Logger logger = LogManager.getLogger(Utilities.class);

    /**
     * Load browser setting from file
     *
     * @param pathFile:       path file configurations
     * @param browserSetting: browser setting key
     * @return driver property
     */
    public static synchronized DriverProperty loadBrowserSetting(String pathFile, String browserSetting) {
        logger.info("Load configuration from file " + pathFile);
        logger.info("Get configurations browser " + browserSetting);
        Gson gson = new Gson();
        try {
            Reader reader               = Files.newBufferedReader(Paths.get(pathFile));
            JsonObject jsonObject           = gson.fromJson(reader, JsonObject.class);
            JsonObject     browserSettingObject = jsonObject.getAsJsonObject(browserSetting);
            DriverProperty    driverProperty       = gson.fromJson(browserSettingObject, DriverProperty.class);

//            ObjectMapper objectMapper = new ObjectMapper();
//            File fileJson = new File(pathFile);
//            DriverProperties driverProperties = objectMapper.readValue(fileJson, DriverProperties.class);
//            driverProperty = driverProperties.getProperty(browserSetting);

            driverProperty.setIsRemote(driverProperty.getIsRemote());
            return driverProperty;
        } catch (Exception ex) {
            logger.error("Read file configuration has error: " + ex.getMessage());
            return null;
        }
    }

    public static void delay(double timeInSecond) {
        try {
            Thread.sleep((long)(timeInSecond * 1000.0));
        } catch (Exception var3) {
            logger.error("An error occurred when delay: " + var3.getMessage());
        }

    }
}
