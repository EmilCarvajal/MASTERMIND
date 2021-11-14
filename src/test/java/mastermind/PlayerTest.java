package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Mocks.MockSecretCode;
import mastermind.Model.Player;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    public static final int NUMERO_PROVES = 50;

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
        assertFalse( p1.correct_code(str));

        str = "!!!!!";
        p1.correct_code(str);
        assertFalse( p1.correct_code(str));

        str = "";
        p1.correct_code(str);
        assertFalse( p1.correct_code(str));

        str = null;
        p1.correct_code(str);
        assertFalse( p1.correct_code(str));

        str = "-";
        p1.correct_code(str);
        assertFalse( p1.correct_code(str));


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
    @ParameterizedTest
    @CsvFileSource(resources = "/DatasetValorsLimits.csv",numLinesToSkip = 1,delimiterString = ";")
    public void Test_Particio_Equivalent_CSV
            (final String v0,final String v2,
             final String v3,final String v4v,
             final String v4nv,final String v5,
             final String v6,final String v20) {
        Player p1 = new Player();
        //Valors nulls
        boolean code_correct = p1.correct_code(v0);
        assertFalse(code_correct);

        //Limit 2
        code_correct = p1.correct_code(v2);
        assertFalse(code_correct);

        //Limit 3
        code_correct = p1.correct_code(v3);
        assertFalse(code_correct);

        //Limit 4 validos
        code_correct = p1.correct_code(v4v);
        assertTrue(code_correct);

        //Limit 4 no validos
        code_correct = p1.correct_code(v4nv);
        assertFalse(code_correct);

        //Limit 5 no validos
        code_correct = p1.correct_code(v5);
        assertFalse(code_correct);

        //Limit 6
        code_correct = p1.correct_code(v6);
        assertFalse(code_correct);

        //Limit 20
        code_correct = p1.correct_code(v20);
        assertFalse(code_correct);

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
                assertFalse(test_code2);


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

   /* @Test
    public void TestCorrectCode_Decision_Condition_Cov(){

    }*/

}

