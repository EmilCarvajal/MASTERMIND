package mastermind.Model.Mocks;

import mastermind.Model.MGameConstructorInterface;
import mastermind.Model.Player;
import mastermind.Model.SecretCode;
import mastermind.Vista.Board;

import java.util.ArrayList;
import java.util.Locale;


public class MockMGameConstructorInterface implements MGameConstructorInterface {
    public int MasterMindGame_Constructor(SecretCode secretCode, int intentos, boolean win, boolean isOver,
                                          Board tablero, Player player, ArrayList listaIntentos){

        secretCode.setSecretCode("ygbr".toUpperCase(Locale.ROOT));
        intentos = 0;

        player = new Player();
        player.setName("Juan");
        listaIntentos = new ArrayList<>();
        return intentos;
    }
}
