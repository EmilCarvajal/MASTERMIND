package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindGame {
    static int MAX_OPPORTUNITIES = 10;
    static int CODE_LENGTH = 4;
    static final List<String> COLORS = new ArrayList<String>(List.of("R", "B", "Y", "G", "P", "O","V"));

    private int intentos;
    private SecretCode secretCode;
    private boolean Win;
    private boolean isOver;
    private Board board;
    private Player player;
    private ArrayList<String> listaIntentos;

    public MasterMindGame(){
        secretCode = new SecretCode();
        intentos = 0;
        Win = false;
        isOver = false;
        board = new Board();
        player = new Player();
        listaIntentos = new ArrayList<>();
    }
    public boolean getisOver(){
        return this.isOver;
    }
    public boolean getWin(){return this.Win;}
    public ArrayList<String> getListaIntentos(){return this.listaIntentos;}
    public int getIntentos(){return this.intentos;}

    void icrementaIntentos(){
        this.intentos++;
    }
    public void mainGame(){
        this.intentos=0;
        while(!isOver){
            if(this.intentos <= MAX_OPPORTUNITIES){
                String code_answer = this.player.IntroduceCode();
                this.listaIntentos.add(code_answer);
                //Si el codigo introducido no es valido se devuelve null.
                while ( code_answer == null){
                    //Volvemos a pedir que introduzca el código si el código introducido por el usuario no preseta el formato valido.
                    code_answer = this.player.IntroduceCode();
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
    //FUNCION IMPORTANTE
    public void introduceCode(String code){
        if(!this.secretCode.checkCode(code)){
            System.out.println("Has fallat!");
            this.board.añadirCodigosTablero(new Code(code));
            this.board.añadirPistasTablero((Hint) this.secretCode.createHint(new Code(code)));
            this.board.mostrarTablero();
            this.board.mostrarTablero();
        }
        else{
            this.board.añadirCodigosTablero(new Code(code));
            this.board.añadirPistasTablero((Hint) this.secretCode.createHint(new Code(code)));
            this.board.mostrarTablero();
            this.isOver = true;
            System.out.println("YOU WON !!");
            this.Win = true;

        }
    }



}
