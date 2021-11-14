package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Player;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerTest {

    public static final int NUMERO_PROVES = 50;

    /*@Test
    public void TestConstructorPlayer(){
        Player p1 = new Player("Eduardo");
        Assert.assertEquals(p1.getName(), "Eduardo");
    }
    @Test
    public void askPlayerName1(){
        //Código para simular un usuario entrando un nombre correcto por teclado.

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("Mario".getBytes());
        System.setIn(in);

        Player p1 = new Player();
        p1.askPlayerName();

        Assert.assertTrue(p1.getName() instanceof String);
        Assert.assertEquals("Mario", p1.getName());

    }

    @Test
    public void askPlayerName2(){

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("    ".getBytes());
        System.setIn(in);

        Player p1 = new Player();
        p1.askPlayerName();

        Assert.assertTrue(p1.getName() instanceof String);
        Assert.assertEquals("JugadorJugando", p1.getName());

    }*/
    /* To test only escriureFitxer()
    @ParameterizedTest
    @ValueSource(strings = {"CorrectCodes.txt","IncorrectCodes.txt"} */

    @Test
    public void TestIntroduceCode(){
        Player p1 = new Player();

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("WWWWWWWWWWWWW".getBytes());
        System.setIn(in);

        Assert.assertNull(p1.IntroduceCode());

        sysInBackup = System.in;
        in = new ByteArrayInputStream("RGBY".getBytes());
        System.setIn(in);
        Assert.assertEquals("RGBY", p1.IntroduceCode());

    }

    @Test
    public void code_corrrectTest(){
        Player p1 = new Player();

        String str = "RYOP";
        p1.correct_code(str);
        Assert.assertTrue( p1.correct_code(str));

        str = "RYYYYOOOO";
        p1.correct_code(str);
        Assert.assertFalse( p1.correct_code(str));

        str = "!!!!!";
        p1.correct_code(str);
        Assert.assertFalse( p1.correct_code(str));

        str = "";
        p1.correct_code(str);
        Assert.assertFalse( p1.correct_code(str));

        str = null;
        p1.correct_code(str);
        Assert.assertFalse( p1.correct_code(str));

        str = "-";
        p1.correct_code(str);
        Assert.assertFalse( p1.correct_code(str));


        /*List<Character> COLORS = Arrays.asList('R', 'B', 'Y', 'G', 'P', 'O','V');

        for (int c = str.length () -1; c>= 0; c--){
            char ch = str.toUpperCase().charAt (c);
            System.out.println (ch);
            assertThat("error valid char",COLORS, Matchers.hasItem(ch));
        }

        assertThat(str, Matchers.isA(String.class));
        Assert.assertEquals(str.toUpperCase(), str.toUpperCase());
        assertThat("tamaño no valido",str, Matchers.hasLength(4)); //comprovar tamaño lista*/

    }


    public String escriureFitxer(String nomFitxer) {
        FileWriter file = null;
        PrintWriter pw = null;
        String filePath = null;
        String code = "";
        List<String> CorrectColorsCode = new ArrayList<String>(MasterMindGame.COLORS);
        List<String> IncorrectColorCode= new ArrayList<String>();
        IncorrectColorCode.add("Esto");
        IncorrectColorCode.add("No");
        IncorrectColorCode.add("Son");
        IncorrectColorCode.add("Colores");
        IncorrectColorCode.add("Reales");
        IncorrectColorCode.add("Intoducirlos");
        IncorrectColorCode.add("Seria");
        IncorrectColorCode.add("un");
        IncorrectColorCode.add("error");
        IncorrectColorCode.add("ya");
        IncorrectColorCode.add("que");
        IncorrectColorCode.add("el");
        IncorrectColorCode.add("jugador");
        IncorrectColorCode.add("solo");
        IncorrectColorCode.add("puede");
        IncorrectColorCode.add("intoducir");
        IncorrectColorCode.add("colores");
        Random random = new Random();
        try
        {
            filePath = "src/main/java//mastermind/Fitxers/"+ nomFitxer;
            file = new FileWriter(filePath);
            pw = new PrintWriter(file);

            //We write 50 corrects codes to "CorrectCodes.txt"
            if (nomFitxer.equals("CorrectCodes.txt")) {
                for (int i = 0; i < NUMERO_PROVES; i++) {
                    for (int j = 0; j < MasterMindGame.CODE_LENGTH; j++) {
                        code += CorrectColorsCode.get(random.nextInt(CorrectColorsCode.size()));
                    }
                    pw.println(code);
                    code= "";
                }
            }

            //We write 50 incorrects codes to "IncorrectCodes.txt"
            else {
                for (int i = 0; i < NUMERO_PROVES; i++) {
                    for (int j = 0; j < MasterMindGame.CODE_LENGTH; j++) {

                        code+= IncorrectColorCode.get(random.nextInt(IncorrectColorCode.size()));
                    }
                    pw.println(code);
                    code = "";
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return filePath;
    }


    @Test
    public void correct_codeTest(){
        String CorrectCodePath = escriureFitxer("CorrectCodes.txt");
        String IncorrectCodePath = escriureFitxer("IncorrectCodes.txt");
        FileReader file1 = null;
        FileReader file2 = null;
        /*Java BufferedReader class is used to read the text from a character-based input stream. It can be used to read data line by line by readLine() method.
        It makes the performance fast.*/
        BufferedReader buffer1;
        BufferedReader buffer2;

        try {
            file1 = new FileReader(CorrectCodePath);
            buffer1 = new BufferedReader(file1);
            file2 =new FileReader(IncorrectCodePath);
            buffer2 = new BufferedReader(file2);

            String CorrectCode;
            String IncorrectCode;
            while(((CorrectCode = buffer1.readLine())!= null )&&((IncorrectCode = buffer2.readLine())!= null)){

            Player p1= new Player("Mario");
            Boolean test_code1= p1.correct_code(CorrectCode);

            Boolean test_code2 = p1.correct_code(IncorrectCode);
            Assert.assertFalse(test_code2);


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(file1!=null){
                file1.close();
            }
            if (file2!=null){
                file2.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
