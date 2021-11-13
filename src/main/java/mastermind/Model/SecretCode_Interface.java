package mastermind.Model;

import mastermind.Controlador.MasterMindGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public interface SecretCode_Interface {

    public void setSecretCode(String secretCode);
    public String generateSecretCode();
    public String getSecretCode();
    //public Hint createHint(Code code);
   // public String ordenarPista(String pistaDesordenada);

}
