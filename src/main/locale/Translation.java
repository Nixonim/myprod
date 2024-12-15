package locale;

import java.util.*;
import java.util.ResourceBundle;

public class Translation {
    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        ResourceBundle r = ResourceBundle.getBundle("translation", locale);
        System.out.println(r.getString("page.login.password"));
    }
}
