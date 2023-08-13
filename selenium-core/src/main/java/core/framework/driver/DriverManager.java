package core.framework.driver;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class DriverManager {
    private static DriverManager instance;
    /**
     * Map<String, Map<String, WebDriver>>: Chứa danh sách driver trong từng thread
     */

    private static Map<String, Map<String, WebDriver>> list;

    public synchronized static DriverManager init() {
        if (instance == null) {
            instance = new DriverManager();
            list = new HashMap<>();
        }
        return instance;
    }

    /**
     *Them driver vào danh sách quản lý driver
     */
    public synchronized static void add(String threadId, String key, WebDriver newDriver) {
        init();
        if (list.get(threadId) == null) {
            Map<String, WebDriver> mDriver = new HashMap<>();
            mDriver.put(key, newDriver);
            list.put(threadId, mDriver);
        } else {
            list.get(threadId).put(key, newDriver);
        }
    }

    /**
     * Tắt driver và xóa danh sách driver của luồng đó
     * @param threadId
     */
    public static void clear(String threadId) {
        list.get(threadId).forEach((key, driver) -> {
            if (driver != null) driver.quit();
        });
        list.remove(threadId);
    }

    /**
     * get driver theo threadID và name Driver
     * @param threadId
     * @param key
     * @return
     */
    public static WebDriver get(String threadId, String key) {
        return list.get(threadId).get(key);
    }

    /**
     * get driver theo name Driver trong luồn hiện tại

     */
    public static WebDriver get(String key) {
        return get(String.valueOf(Thread.currentThread().getId()), key);
    }
}
