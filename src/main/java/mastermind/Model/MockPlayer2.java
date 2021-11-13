package mastermind.Model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

public class MockPlayer2 implements PlayerInterface {
    public String code = "ygbr".toUpperCase(Locale.ROOT);
    public static final List<String> codigosPlayer  = new ArrayList<String>(List.of("RRRR", "RBRR", "RBGR", "RBGO", "RBGP", "RBGG","FFFF"));//----
    public int cont_c = 0;
    public String IntroduceCode(){
        cont_c++;
        if (cont_c == codigosPlayer.size())
            cont_c =0;
        return codigosPlayer.get(cont_c) ;}
    public Boolean correct_code(String st ){
        return true;}

    public void setCode(String code) {
        this.code = code;
    }
}