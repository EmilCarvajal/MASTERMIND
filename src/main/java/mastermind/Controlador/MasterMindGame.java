package mastermind.Controlador;

import mastermind.Model.*;
import mastermind.Vista.Board;

import java.util.ArrayList;
import java.util.List;


public class MasterMindGame {

    //CONSTANTES
    public static int MAX_OPPORTUNITIES = 10;
    public static int CODE_LENGTH = 4;
    public static final  List<String> COLORS = new ArrayList<String>(List.of("R", "B", "Y", "G", "P", "O","V"));

    // ATRIBUTOS
    private int intentos;
    private SecretCode secretCode;
    private boolean Win;
    private boolean isOver;
    private Board board;
    private Player player;
    private ArrayList<String> listaIntentos;

    // METODOS
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
    public String getSecretCode(){return this.secretCode.getSecretCode();}

    // SETS PARA MOCKS
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    private void setPrivVar(SecretCode secretCode, int intentos, boolean win, boolean isOver, Board board, Player player
        , ArrayList listaIntentos) {
        this.secretCode = secretCode;
        this.intentos = intentos;
        this.board = board;
        this.isOver = isOver;
        this.listaIntentos = listaIntentos;
        this.Win = win;
        this.player = player;
    }
    //--

    void icrementaIntentos(){
        this.intentos++;
    }

    public void mainGame(){
        this.intentos=0;
        while(!isOver){
            if(this.intentos < MAX_OPPORTUNITIES){
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
            this.board.mostrarTablero(secretCode);
        }
        else{
            this.board.añadirCodigosTablero(new Code(code));
            this.board.añadirPistasTablero((Hint) this.secretCode.createHint(new Code(code)));
            this.board.mostrarTablero(secretCode);
            this.isOver = true;
            System.out.println("YOU WON !!");
            this.Win = true;

        }
    }
    // MOCK PLAYER --
    public PlayerInterface playerInterface;
    public void setPlayer(PlayerInterface jugador){this.playerInterface = jugador;}
    public String Code_Mock;
    public boolean code_answer_correct;
    public void update_code(){
        Code_Mock = playerInterface.IntroduceCode();
        code_answer_correct = playerInterface.correct_code(Code_Mock);
    }
    // --

    // MOCK CONSTRUCTOR & Play with 1 defined code & MOCK PLAYER--
    public MGameConstructorInterface mgci ;
    public void setMgci(MGameConstructorInterface mcgii){this.mgci = mcgii;}
    public void contructor_mock(){
        /*
        int intentos = ;
        SecretCode secretCode = new SecretCode();
        boolean Win = false;
        boolean isOver = false;
        Board board =new Board();
        Player player = new Player();
        ArrayList<String> listaIntentos = new ArrayList<>();
        */
        int int_ret = mgci.MasterMindGame_Constructor(secretCode, intentos,Win,isOver,
                board,player,listaIntentos);

        int n_intentos = mgci.MasterMindGame_Constructor(this.secretCode,this.intentos,this.Win,this.isOver,
                this.board, this.player, this.listaIntentos);
        setIntentos(n_intentos);
        System.out.println("intentos "+intentos);
        //setPrivVar(secretCode,intentos,Win,isOver,board,player,listaIntentos);
    }
    // --


}
