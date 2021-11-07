package mastermind;

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
    public static void main(String[] args) {
       /* SecretCode secretCode = new SecretCode();
        System.out.println(secretCode.getSecretCode());
        Hint pista;
        Code code = new Code(secretCode.getSecretCode());
        pista = secretCode.createHint(code);
        System.out.println(pista.getHint());*/
        SecretCode secretCode = new SecretCode();
        Code code = new Code();
        secretCode.setSecretCode("RGYO");
        code.setCode("RYGR");
        Hint pista;
        pista= secretCode.createHint(code);
        String str_pista= pista.getHint();
        System.out.println(str_pista);

    }

    public boolean checkCode(String code) {
        return this.secretCode.equals(code);
    }
    public Hint createHint(Code code) {

        String pistaSortida = "";

        for (int i = 0; i < MasterMindGame.CODE_LENGTH; i++) {
            if (code.getCodigo().split("")[i].equals(this.secretCode.split("")[i])) {
                pistaSortida += "x";
            } else {
                boolean hiApareix = false;
                for (int j = 0; j <MasterMindGame.CODE_LENGTH ; j++) {
                    if (code.getCodigo().split("")[i].equals(this.secretCode.split("")[j])) {
                        pistaSortida += "o";
                        hiApareix = true;
                        break;
                    }
                }
                if (!hiApareix) {
                    pistaSortida += "-";
                }
            }
        }
        return new Hint(ordenarPista(pistaSortida));
    }

    private String ordenarPista(String pistaDesordenada) {
        char pistaChars[] = pistaDesordenada.toCharArray();
        Arrays.sort(pistaChars);
        String pistaOrdenada = "";
        //Si Hint no tiene la mida adequada retorna NULL
        if(pistaChars.length != MasterMindGame.CODE_LENGTH) {
            return null;
        } else {
            for (int i = 1; i < pistaChars.length + 1; i++) {
                pistaOrdenada += pistaChars[pistaChars.length - i];
            }
            return pistaOrdenada;
        }
    }


}

