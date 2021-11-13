package mastermind.Model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;

public class MockPlayer2 implements PlayerInterface {
    public String code = "ygbr".toUpperCase(Locale.ROOT);
    public static final List<String> codigosPlayer  = new ArrayList<String>(List.of("RRRR", "RBRR", "RBGR", "RBGO", "RBGP", "RBGG","FFFF","GYRO","BRVO","RBGO","GOPR"));//----
    public int cont_c = 0;
    public String IntroduceCode(){
        if (cont_c == this.codigosPlayer.size())
            this.cont_c =0;
        int cont_actual = this.cont_c;
        this.cont_c++;
        System.out.println("Actual: "+this.codigosPlayer.get(cont_actual));
        return this.codigosPlayer.get(cont_actual) ;
    }
    public Boolean correct_code(String st ){
        return true;}

    public void setCode(String code) {
        this.code = code;
    }
}