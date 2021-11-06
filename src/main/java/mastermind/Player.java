
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
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
        System.out.println("Your name is: " + name);
    }

    public String IntroduceCode(){
        System.out.println("Available colors:");
        for(int i=0;i < MasterMindGame.COLORS.size(); i++){
            System.out.println(MasterMindGame.COLORS.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which do you think is the secret code?");
        String player_code= scanner.nextLine().toUpperCase();

        //Verificar código introducido
        if(correct_code(player_code)){
            return player_code;
        }
        return null;

    }
    public Boolean correct_code(String code){

        if(code==null || code.length() !=4 ){
            return false;
        }
        //FALTA...
        return true;
    }

    /*public static void main(String[] args) {
        Player p1= new Player();
        String answer =  p1.IntroduceCode();
        System.out.println(answer);
        List<String> codisColorsCorrectes = new ArrayList<String>(MasterMindGame.COLORS);
        System.out.println(codisColorsCorrectes);
    }*/
    // Emil esta in
}
