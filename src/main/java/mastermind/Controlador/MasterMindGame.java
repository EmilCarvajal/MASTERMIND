package mastermind.Controlador;

import mastermind.Model.*;
import mastermind.Vista.Board;

import java.util.ArrayList;
import java.util.List;


public class MasterMindGame {

    //CONSTANTES
    public static int MAX_OPPORTUNITIES = 10;
    public static int CODE_LENGTH = 4;
    public static final  List<String> COLORS = new ArrayList<>(List.of("R", "B", "Y", "G", "P", "O","V"));

    // ATRIBUTOS
    private int intentos;
    private final SecretCode secretCode;
    private boolean Win;
    private boolean isOver; //juego a terminado
    private final Board board;
    private final Player player;
    private final ArrayList<String> listaIntentos; //guarda codigos del jugador
    private Hint pista;

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

    // MAIN DEL JUEGO
    public void mainGame(){
        while(!isOver){
            if(this.intentos < MAX_OPPORTUNITIES){
                String code_answer = this.player.IntroduceCode();
                this.listaIntentos.add(code_answer);
                //Si el codigo introducido no es valido se devuelve null.
                while (code_answer == null){
                    //Volvemos a pedir que introduzca el código si el código introducido por el usuario no preseta el formato valido.
                    code_answer = this.player.IntroduceCode();
                }
                introduceCode(code_answer);
                this.intentos++;
            }
            else{
                this.isOver = true;
                System.out.println("NO MORE OPPORTUNITIES LEFT. END OF THE GAME. ");
            }
        }
    }

    //ACTUALIZAR DATOS DEL JUEGO
    public void introduceCode(String code){
        // Actualiza variables en fucion si ha encertado el código o no
        Code user_code =  new Code(code);

        if(!user_code.checkCode(this.secretCode.getSecretCode())){
            System.out.println("Has fallat!");
            this.board.añadirCodigosTablero(new Code(code));
            pista = new Hint(this.secretCode, user_code);
            this.board.añadirPistasTablero(pista);
            this.board.mostrarTablero(secretCode);
        }
        else{
            this.board.añadirCodigosTablero(new Code(code));
            pista = new Hint(this.secretCode, user_code);
            this.board.añadirPistasTablero(pista);
            this.board.mostrarTablero(secretCode);
            this.isOver = true;
            System.out.println("YOU WON !!");
            this.Win = true;
        }
    }
    // ------- FINAL CODIGO EJECUTABLE REAL DEL JUEGO ----------

    // ------- INICIO CÓDIGO PARA TESTS ------------------------

    public boolean getisOver(){
        return this.isOver;
    }
    public boolean getWin(){return this.Win;}
    public ArrayList<String> getListaIntentos(){return this.listaIntentos;}
    public int getIntentos(){return this.intentos;}
    public Board getBoard() {
        return board;
    }
    public String getSecretCode(){return this.secretCode.getSecretCode();}

    // MOCK PLAYER --
    public PlayerInterface playerInterface;
    public void setPlayer(PlayerInterface jugador){this.playerInterface = jugador;}
    public String Code_Mock;
    public boolean code_answer_correct;

    public void update_code(){
        // inicializa code del jugador con el code de un mock
        Code_Mock = playerInterface.IntroduceCode();
        code_answer_correct = playerInterface.correct_code(Code_Mock);
    }

    public void mainGame_Mock(){
        /*Es el main del juego normal pero adaptada para poder utilizar las clases
        layerInterface y SecretCode_Interface. De esta manera podemos simular el
        juego completo sin conocer el código secreto aleatório ni las entradas del
        usuario*/
        this.intentos = 0;
        while(!isOver){
            //this.isOver=true;
            if(this.intentos < MAX_OPPORTUNITIES){
                String code_answer = this.playerInterface.IntroduceCode();
                this.listaIntentos.add(code_answer);

                System.out.println("l intentos: "+this.listaIntentos.get(0));
                //Si el codigo introducido no es valido se devuelve null.
                while ( code_answer == null){
                    System.out.println("is null");
                    //Volvemos a pedir que introduzca el código si el código introducido por el usuario no preseta el formato valido.
                    code_answer = this.playerInterface.IntroduceCode();
                }
                introduceCode_Mock_SecretCode(code_answer);
                this.intentos++;
            }
            else{
                this.isOver = true;
                System.out.println("NO MORE OPPORTUNITIES LEFT. END OF THE GAME. ");
            }
        }
    }

    //Mock SecretCode
    public SecretCode_Interface SecretCodeInterface;
    public void setSecretCodeInterface(SecretCode_Interface MockSCode){ this.SecretCodeInterface = MockSCode ;}

    public void introduceCode_Mock_SecretCode(String code){
        //  Se ha adaptado a la versión original para que funcione con Mocks.
        Code user_code =  new Code(code);
        if(!user_code.checkCode(SecretCodeInterface.getSecretCode())){
            System.out.println("Has fallat!");
            this.board.añadirCodigosTablero(new Code(code));
            pista= new Hint(SecretCodeInterface, user_code);
            this.board.añadirPistasTablero(pista);
            this.board.mostrarTablero(secretCode);
        }
        else{
            this.board.añadirCodigosTablero(new Code(code));
            pista= new Hint(SecretCodeInterface, user_code);
            this.board.añadirPistasTablero(pista);
            this.board.mostrarTablero(secretCode);
            this.isOver = true;
            System.out.println("YOU WON !!");
            this.Win = true;
        }
    }

    public int mainGame_Paths(boolean isOver, int intentos,String code_user,String code_user_null){
        /*Utilizamos esta función modificada de mainGame() para poder testar mediante un
        test el path coverage del método mainGame() */
        int estados = 1;
        estados++;
        while(!isOver){
            estados++;
            if(intentos < MAX_OPPORTUNITIES){
                estados++;
                String code_answer = code_user; estados++;
                this.listaIntentos.add(code_answer); estados++;
                //Si el codigo introducido no es valido se devuelve null.
                while (code_answer == null){
                    estados++;
                    //Volvemos a pedir que introduzca el código si el código introducido por el usuario no preseta el formato valido.
                    code_answer = code_user_null; estados++;
                }
                if(code_answer != null)estados++;
                introduceCode(code_answer); estados++;
                intentos++; estados++; isOver = true;
            }
            else{
                estados++;
                isOver = true; estados++;
                System.out.println("NO MORE OPPORTUNITIES LEFT. END OF THE GAME. "); estados++;
            }
        }
        estados++;
        return estados;
    }

    public String introduceCode_Paths(String code){
        /*Utilizamos esta función simplificada de introduce_code() para
         poder realizar un Path Coverage que cubra los posibles casos*/
        String m_final;
        Code user_code =  new Code(code);
        if(!user_code.checkCode("YGBR")){
            System.out.println("Has fallat!");
            m_final ="Has fallat!";
        }
        else{
            System.out.println("YOU WON !!");
            m_final ="YOU WON !!";
        }
        return m_final;
    }


    //LOOP TESTING:  Funciones para hacer loop testing
    public int TestSimpleLoop1(int input){
        int contador = 0;
        for(; input < 10; input++){
            contador ++;
        }
        return  contador;

    }
    public int TestSimpleLoop2(int input){
        int contador = 0;
        while(input < 100 && input > 0){
            input ++;
            contador ++;
        }
        return contador;
    }

    public int TestAniuatLoop1(int input1, int input2){

        int contador = 0;
        int aux_input2 = input2;
        for(; input1 < 10; input1++){
            for (;input2 < 10; input2++){
                contador ++;
            }
            input2 = aux_input2;
        }
        return  contador;
    }
    public int TestAniuatLoop2(int input1, int input2){
        int contador = 0;
        int aux_input2 = input2;
        while(input1 < 10){
            while(input2< 10){

                input2 ++;
                contador ++;
            }
            input1 ++;
            input2 = aux_input2;
        }
        return contador;
    }

    // Funcion para hacer un tercer caso de test de decision y conditional coverage
    public int DecConCoverage3(int input1, int input2){
        int contador = 0;
        if (input1 >4 || input1<2 ) {//no -inf a 2
            if (input2 <0)
                contador = -2;
            else
                contador = 100;
        }
        else
            if (input2 >0)
                contador = 10;
            else
                contador = 80;
        return contador;
    }
}
