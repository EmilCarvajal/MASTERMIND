package mastermind.Model;

import mastermind.Vista.Board;

import java.util.ArrayList;


public interface MGameConstructorInterface {
    public int MasterMindGame_Constructor(SecretCode secretCode, int intentos, boolean win, boolean isOver,
                                          Board tablero, Player player, ArrayList listaIntentos);

}
