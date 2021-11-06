import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretCode {

    private final String secretCode;

    public SecretCode(){
        this.secretCode=generateSecretCode();

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
