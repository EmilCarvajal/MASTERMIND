package mastermind.Model;

import java.util.Hashtable;
import java.util.Locale;

public class MockPlayer implements PlayerInterface {
    public String code = "ygbr".toUpperCase(Locale.ROOT);

    public String IntroduceCode(){return code ;}
    public Boolean correct_code(String st ){
        return true;}
}
