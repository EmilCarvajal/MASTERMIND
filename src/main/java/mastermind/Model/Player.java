package mastermind.Model;

import mastermind.Controlador.MasterMindGame;

import java.util.Scanner;

public class Player {

    public Player(){}
    public String IntroduceCode(){
        System.out.println("Available colors:");
        for(int i = 0; i < MasterMindGame.COLORS.size(); i++){
            System.out.print(MasterMindGame.COLORS.get(i)+ " ");
        }
        System.out.println();
        System.out.println("Which do you think is the secret code?.Code must be a combination of 4 colors");
        Scanner scanner = new Scanner(System.in);
        String player_code= scanner.nextLine().toUpperCase();

        //Verificar código introducido
        if(correct_code(player_code)){
            return player_code;
        }
        //Si el codigo introducido por el usuario es incorrecto se devuelve null.
        return null;

    }
    public Boolean correct_code(String code){
        if( code == null || code.length() != MasterMindGame.CODE_LENGTH ){
            System.out.println("Codigo introducido inexistente o de largaria inadequada");
            return false;
        }
        for( int index = 0; index < MasterMindGame.CODE_LENGTH; index++){
            char charcterCode = code.charAt(index);
            boolean correct_character = false;
            for(int i = 0; i< MasterMindGame.COLORS.size(); i++){
                String aux =  MasterMindGame.COLORS.get(i);
                if(charcterCode == aux.charAt(0)){
                    correct_character = true;
                }
            }
            if(!correct_character){
                //El usuario ha introducido un carcater que no representa ha ningún color.
                System.out.println("El caracter '"+ charcterCode +"' no coincide con ninguno de " +
                        "los colores disponibles. Su codigo introducido queda anulado.");
                System.out.println("El codigo ha de ser una convinación de los colores:" + MasterMindGame.COLORS);
                return false;
            }
        }
        return true;
    }



}
