package mastermind.Model.Mocks;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Player;
import mastermind.Model.SecretCode;
import mastermind.Vista.Board;

import java.util.ArrayList;

public class MGConstructor {
    private int intentos;
    private SecretCode secretCode;
    private boolean Win;
    private boolean isOver;
    private Board board;
    private Player player;
    private ArrayList<String> listaIntentos;

    public MGConstructor(){
        secretCode = new SecretCode();
        intentos = 0;
        Win = false;
        isOver = false;
        board = new Board();
        player = new Player();
        listaIntentos = new ArrayList<>();
    }
    public void tranferStatus(MasterMindGame m_game){
        m_game.setPrivVar(secretCode,intentos,Win,isOver,board,player,listaIntentos);
    }

}
