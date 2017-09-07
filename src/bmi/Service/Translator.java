package bmi.Service;

import java.util.ResourceBundle;

public class Translator implements bmi.Interface.TranslatorInterface {
    private ResourceBundle resourceBundle;

    public Translator() {
        resourceBundle = ResourceBundle.getBundle("bmi");
    }

    private ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    @Override
    public String translate(String key) {
        return getResourceBundle().getString(key);
    }
}
