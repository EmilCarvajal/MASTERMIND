package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;

    public Player(){
        askPlayerName();
    }
    public Player(String name){
        this.name =name;
    }

    public String getName(){
        return name;
    }

    public void askPlayerName(){
        System.out.println("Please, enter you name (Max 10 characters): ");
        Scanner scanner = new Scanner(System.in);//cin. Para introducir por teclado
        this.name = scanner.nextLine();
        System.out.println("Your name is: " + name);
    }

    public String IntroduceCode(){
        System.out.println("Available colors:");
        for(int i=0;i < MasterMindGame.COLORS.size(); i++){
            System.out.println(MasterMindGame.COLORS.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which do you think is the secret code?.Code must be a combination of 4 colors");
        String player_code= scanner.nextLine().toUpperCase();

        //Verificar código introducido
        if(correct_code(player_code)){
            return player_code;
        }
        //Si el codigo introducido por el usuario es incorrecto se devuelve null.
        return null;

    }
    public Boolean correct_code(String code){

        if( code==null || code.length() != MasterMindGame.CODE_LENGTH ){
            System.out.println("Codigo introducido inexistente o de largaria inadequada");
            return false;
        }
        for( int index=0; index < MasterMindGame.CODE_LENGTH; index++){
            char charcterCode= code.charAt(index);
            boolean correct_character=false;
            for(int i=0; i< MasterMindGame.COLORS.size();i++){
                String aux=MasterMindGame.COLORS.get(i);
                if(charcterCode == aux.charAt(0)){
                    correct_character = true;
                }
            }
            if(correct_character){
                //Carcater intoducido es correcto.
            }
            else{
                //El usuario ha introducido un carcater que no representa ha ningún color.
                System.out.println("El caracter '"+ charcterCode +"' no coincide con ninguno de los colores disponibles. Su codigo introducido queda anulado.");
                System.out.println("El codigo ha de ser una convinación de los colores:" + MasterMindGame.COLORS);
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Player p1= new Player();
        String answer =  p1.IntroduceCode();
        if(answer!=null){System.out.println(answer);}
        //List<String> codisColorsCorrectes = new ArrayList<String>(MasterMindGame.COLORS);
        //System.out.println(codisColorsCorrectes);
    }
    // Emil esta in
}
