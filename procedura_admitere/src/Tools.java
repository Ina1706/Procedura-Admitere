import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    public boolean emailMatcher(String x){

        String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern r = Pattern.compile(pattern);


        Matcher m = r.matcher(x);
        return m.find();
    }

}
