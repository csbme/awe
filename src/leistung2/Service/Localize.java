package leistung2.Service;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localize {
    private static final Localize ourInstance = new Localize();
    private ResourceBundle messages;

    private Localize() {
        Locale currentLocale = Locale.US;
        setMessages(ResourceBundle.getBundle("leistung2/MessagesBundle", currentLocale));
    }

    @SuppressWarnings("SameReturnValue")
    private static Localize getInstance() {
        return ourInstance;
    }

    public static String msg(String message) {
        return getInstance().getMessages().getString(message);
    }

    private ResourceBundle getMessages() {
        return messages;
    }

    private void setMessages(ResourceBundle messages) {
        this.messages = messages;
    }
}
