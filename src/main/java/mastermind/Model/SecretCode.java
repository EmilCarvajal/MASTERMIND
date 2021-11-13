package mastermind.Model;

import mastermind.Controlador.MasterMindGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecretCode {

    private  String secretCode;
    public boolean is_secret;

    public SecretCode(){
        this.secretCode=generateSecretCode();
        this.is_secret = true;

    }
    public void setSecretCode(String secretCode) {
        this.secretCode= secretCode;
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
    /*public boolean checkCode(String code) {
        return this.secretCode.equals(code);
    }*/



}

