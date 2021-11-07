package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretCode {

    // ATRIBUTOS
    private final String secretCode;
    public boolean is_secret;

    // METODOS
    public SecretCode(){
        this.secretCode=generateSecretCode();
        this.is_secret = true;
    }
    private String generateSecretCode(){
        String code="";
        Random random = new Random();
        List<String> aux = new ArrayList<String>(MasterMindGame.COLORS);
        for(int i=0; i<MasterMindGame.CODE_LENGTH;i++){
            code += aux.get(random.nextInt(aux.size()));
        }
        return code;
    }
    public String getSecretCode(){
        return this.secretCode;
    }
    public static void main(String[] args) {
        SecretCode code = new SecretCode();
        System.out.println(code.getSecretCode());
    }

}
