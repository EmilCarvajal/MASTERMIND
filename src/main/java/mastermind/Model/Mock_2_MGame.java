package mastermind.Model;

import mastermind.Controlador.MasterMindGame;
import mastermind.Vista.Board;

import java.util.ArrayList;
import java.util.List;

public class Mock_2_MGame extends MasterMindGame {

    public int intentos;
    private SecretCode secretCode;
    private boolean Win;
    private boolean isOver;
    private Board board;
    private Player player;
    private ArrayList<String> listaIntentos;
    public List<String> codigosPlayer;//  = new ArrayList<String>(List.of("RRRR", "RBRR", "RBGR", "RBGO", "RBGP", "RBGG","FFFF"));//----

    public Mock_2_MGame(){
        intentos = 0;
        secretCode = new SecretCode();
        Win = false;
        isOver = false;
        board = new Board();
        player = new Player();
        listaIntentos= new ArrayList<String>();
    }
    public void setCodigosPlayer(ArrayList<String> str_list){
         this.codigosPlayer= str_list;
    }

    public SecretCode getSecretCodeObject(){
        return this.secretCode;//Returns a String of the secret Code
    }

    public int getIntentos() {return this.intentos; }
    public boolean getWin() {return this.Win; }
    public void mainGame(){

        while(!isOver){

            if(this.intentos < MasterMindGame.MAX_OPPORTUNITIES){
                String code_answer = codigosPlayer.get(intentos); //---
                this.listaIntentos.add(code_answer);

                if(code_answer == secretCode.getSecretCode()){
                    this.isOver=true;
                }
                introduceCode(code_answer);
                this.intentos++;
            }
            else{
                this.isOver=true;
                System.out.println("NO MORE OPPORTUNITIES LEFT. END OF THE GAME. ");
            }
        }
    }


}
