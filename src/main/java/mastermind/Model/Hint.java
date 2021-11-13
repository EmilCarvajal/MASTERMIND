package mastermind.Model;

import mastermind.Controlador.MasterMindGame;

import java.util.Arrays;

// Clase que guarda cada pista
public class Hint{

    private String m_hint;

    public Hint() {};
    public Hint(SecretCode secretCode, Code userCode){

        String pistaSortida = "";

        for (int i = 0; i < MasterMindGame.CODE_LENGTH; i++) {
            if (userCode.getCodigo().split("")[i].equals(secretCode.getSecretCode().split("")[i])) {
                pistaSortida += "x";
            } else {
                boolean hiApareix = false;
                for (int j = 0; j <MasterMindGame.CODE_LENGTH ; j++) {
                    if (userCode.getCodigo().split("")[i].equals(secretCode.getSecretCode().split("")[j])) {
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
        this.m_hint = ordenarPista(pistaSortida);

    }
    //Constructor modificado para usarlo usando Mock de SecretCode.
    public Hint(SecretCode_Interface secretCode, Code userCode){

        String pistaSortida = "";

        for (int i = 0; i < MasterMindGame.CODE_LENGTH; i++) {
            if (userCode.getCodigo().split("")[i].equals(secretCode.getSecretCode().split("")[i])) {
                pistaSortida += "x";
            } else {
                boolean hiApareix = false;
                for (int j = 0; j <MasterMindGame.CODE_LENGTH ; j++) {
                    if (userCode.getCodigo().split("")[i].equals(secretCode.getSecretCode().split("")[j])) {
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
        this.m_hint = ordenarPista(pistaSortida);

    }

    public String getHint() { return this.m_hint; }

    private String ordenarPista(String pistaDesordenada) {

        char pistaChars[] = pistaDesordenada.toCharArray();
        Arrays.sort(pistaChars);
        String pistaOrdenada = "";
        //Si Hint no tiene la mida adequada retorna NULL
        if(pistaChars.length != MasterMindGame.CODE_LENGTH) {
            return null;
        }
        else {
            for (int i = 1; i < pistaChars.length + 1; i++) {
                pistaOrdenada += pistaChars[pistaChars.length - i];
            }
            return pistaOrdenada;
        }
    }


}
