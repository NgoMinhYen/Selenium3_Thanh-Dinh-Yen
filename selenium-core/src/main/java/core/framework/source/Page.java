package core.framework.source;

import core.framework.elements.Element;
import core.framework.elements.IElement;
import core.framework.elements.ListElement;
import core.framework.locator.Locator;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page {

    private static String TEST_RESOURCES = System.getProperty("user.dir").concat(File.separator)
            .concat("src").concat(File.separator).concat("test")
            .concat(File.separator).concat("resources")
            .concat(File.separator).concat("pages").concat(File.separator);

    private static Properties read(String file) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {

            inputStream = new FileInputStream(TEST_RESOURCES + file);

            // load properties from file
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close objects
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static void init(Object page){
        Class<?> clone = page.getClass();
        ResourcePage sourcePage = clone.getAnnotation(ResourcePage.class);
        Properties data = read(sourcePage.file());


        for (Field field : clone.getDeclaredFields()) {
            Find find = field.getAnnotation(Find.class);
            if(find != null){
                Object value = data.get(find.key());
                Locator locator = getLocator(value);
                Object element = null;
                if(field.getType().getSimpleName().equalsIgnoreCase("IElement")){
                    element = new Element(locator);
                }else{
                    element = new ListElement(locator);
                }

                field.setAccessible(true);
                try {
                    field.set(page, element);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }



    private static List<String> extract(Object value){
        if(value != null){
            Pattern pattern = Pattern.compile("(.*)#(.*)");
            Matcher matcher = pattern.matcher(value.toString());
            if (matcher.find())
            {
                return Arrays.asList(matcher.group(1), matcher.group(2));
            }
        }
        return null;
    }

    private static Locator getLocator(Object value){

        if(value != null){
           List<String> data =  extract(value);
           switch (data.get(0).toLowerCase()){
               case "name" : return Locator.name(data.get(1));
               case "id" : return Locator.id(data.get(1));
               case "xpath" : return Locator.xpath(data.get(1));
               case "className" : return Locator.className(data.get(1));
               case "tagName" : return Locator.tagName(data.get(1));
               case "dynamicXPath" : return Locator.dynamicXPath(data.get(1));

           }
        }
        return null;
    }
}
