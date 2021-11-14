package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Code;
import mastermind.Model.Mocks.MockPlayer2;
import mastermind.Vista.Board;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import mastermind.Model.Hint;
import mastermind.Model.Mocks.MockPlayer;
import mastermind.Model.Mocks.MockSecretCode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MasterMindGameTest {

    @Test
    public void testConstructor(){
        MasterMindGame MG = new MasterMindGame();
        boolean test = true;

        if(MG.getWin() || MG.getisOver()){ test = false;}
        if(MG.getIntentos() != 0){ test = false;}
        if(MG.getListaIntentos().size()!= 0 ){ test = false;}

        assertTrue(MG.getBoard() instanceof Board);
        Assert.assertEquals(test,true);

    }

    @Test
    public void TestIntroduceCode(){

        MasterMindGame MG = new MasterMindGame();
        String str_code = "RGBY";
        int indexListCodigos = 0;
        Code compareCode;
        Code added_codeToBoard;

         if(MG.getSecretCode() != "RGBY") { //Codigo Introducido por Usuario diferente a codigo secreto.

             MG.introduceCode(str_code);

             compareCode = new Code(str_code);
             added_codeToBoard = MG.getBoard().getListCodigos().get(indexListCodigos);

             assertFalse(MG.getWin()); //Usuario aun no ha ganado
             assertFalse(MG.getisOver()); //Partida aun no se ha acabado
             assertEquals(added_codeToBoard.getCodigo(), compareCode.getCodigo()); //Codigo añadido al tablero ha de coincidir con el que ha introduciso el usuario
         }

        indexListCodigos ++;
        str_code = MG.getSecretCode(); //Codigo introducido por usuario es el mismo que el codigo secreto. Usuaio debe ganar y Over == true;
        MG.introduceCode(str_code);

        compareCode =  new Code(str_code);
        added_codeToBoard = MG.getBoard().getListCodigos().get(indexListCodigos);

        assertTrue(MG.getWin()); //Usuario ha ganado
        assertTrue(MG.getisOver()); //La partida se ha acabado
        assertEquals(added_codeToBoard.getCodigo(), compareCode.getCodigo()); //Codigo añadido al tablero ha de coincidir con el que ha introduciso el usuario

    }


    @Test
    public void Test_mainGame_Paths(){
        //PATHS = nodos-arestas+2 = 14-12+2 = 4paths
        MasterMindGame m_game = new MasterMindGame();
        //PATH1: 1-2-12
        int intentos = MasterMindGame.MAX_OPPORTUNITIES;
        int n_paths;
        boolean isOver = true;
        n_paths = m_game.mainGame_Paths(isOver,intentos,"YGBR","");
        assertEquals(3,n_paths);

        //PATH2: 1-2-3-4-5-6-8-9-2-12
        intentos = MasterMindGame.MAX_OPPORTUNITIES-1;
        isOver = false;
        n_paths = m_game.mainGame_Paths(isOver,intentos,"YGBR","");
        assertEquals(10,n_paths);

        //PATH3: 1-2-3-4-5-6-7-8-9-2-12
        intentos = MasterMindGame.MAX_OPPORTUNITIES-1;
        isOver = false;
        n_paths = m_game.mainGame_Paths(isOver,intentos,null,"YGBR");
        assertEquals(12,n_paths);

        //PATH4: 1-2-3-10-11-2-12
        intentos = MasterMindGame.MAX_OPPORTUNITIES;
        isOver = false;
        n_paths = m_game.mainGame_Paths(isOver,intentos,"YGBR",null);
        assertEquals(7,n_paths);
    }
    @Test
    public void Test_introduceCode_Paths(){
        //PATHS = 5 - 5 + 2 = 2
        MasterMindGame m_game = new MasterMindGame();
        //PATH1: 1-2-3-5
        String mensage;
        mensage= m_game.introduceCode_Paths("YGBR");
        assertEquals("YOU WON !!",mensage);

        //PATH2: 1-2-4-5
        mensage= m_game.introduceCode_Paths("YGHR");
        assertEquals("Has fallat!",mensage);
    }

    @Test //simulaci?n de una partida completa con una lista determinada de codigos 1 un SecretCode determinado.
    public void Test_Lista_Codigoss(){
        List<String> pistas_correctas  = new ArrayList<String>(List.of(
                "xooo", "xooo", "xoo-", "ooo-", "oo--", "oo--", "----", "oo--", "xxoo", "ooo-"));
        // Set up mock
        MockPlayer2 mockPlayer2 = new MockPlayer2();

        // Declaraci? y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        MockSecretCode mockSecretCode = new MockSecretCode();
        mockSecretCode.setSecretCode("BOVR");
        m_game.setPlayer(mockPlayer2);
        m_game.setSecretCodeInterface(mockSecretCode);
        //System.out.println(m_game.playerInterface.IntroduceCode());
        //Prova i validaci?
        m_game.mainGame_Mock();
        int c= 0;
        for (Hint p: m_game.getBoard().getPistasTablero()) {
            assertEquals(pistas_correctas.get(c),p.getHint());
            c++;
        }


    }

    @Test
    public void Test_Update_Code() {
        // Set up mock
        MockPlayer mockPlayer = new MockPlayer();
        // Declaraci? y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer);

        //Prova i validaci?
        m_game.update_code();
        System.out.println(m_game.code_answer_correct);
        Assert.assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);
    }

    @Test
    public void TestSimpleLoop1(){
        MasterMindGame PruebaLoopMMG= new MasterMindGame();
        //Evitar el loop
        int contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop1(10) );
        //Una passada pel loop
        contador_Test_Deseado = 1;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop1(9) );
        //Dues passades pel loop
        contador_Test_Deseado = 2;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop1(8) );
        //m passades pel loop m<n
        contador_Test_Deseado = 6;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop1(4) );
        //(n-1), n passades pel loop (n és el nombremàxim de passades) on n és el nombre màxim possible de passades
        contador_Test_Deseado = 9;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop1(1) );


    }
    @Test
    public void TestSimpleLoop2(){
        MasterMindGame PruebaLoopMMG= new MasterMindGame();
        //Evitar el loop
        int contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop2(-5000) );
        //Una passada pel loop
        contador_Test_Deseado = 1;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop2(99) );
        //Dues passades pel loop
        contador_Test_Deseado = 2;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop2(98) );
        //m passades pel loop m<n
        contador_Test_Deseado = 60;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop2(40) );
        //(n-1), n passades pel loop (n és el nombremàxim de passades) on n és el nombre màxim possible de passades
        contador_Test_Deseado = 99;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop2(1) );

    }

    @Test
    public void TestAniuatLoop1(){
        /*
        • Començar amb un test simple pel loop més interior, fixant els demés loops al valor mínim
        • Testejar un loop més extern (com si fos un loop simple) mantenint el nombre d’iteracions
        dels loops interiors a valors habituals. */

        MasterMindGame PruebaLoopMMG= new MasterMindGame();
        //---------------LOOP INTERN-------------------------
        //Evitar el loop
        int contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado, PruebaLoopMMG.TestAniuatLoop1(9,10));

        //Una passada pel loop
        contador_Test_Deseado = 1;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,9));

        //Dues passades pel loop
        contador_Test_Deseado = 2;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,8));

        //m passades pel loop m<n
        contador_Test_Deseado = 6;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,4));

        //(n-1), n passades pel loop (n és el nombremàxim de passades) on n és el nombre màxim possible de passade
        contador_Test_Deseado = 9;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,1));

        //---------------------LOOP EXTERN--------------------------
        //Evitar el loop
        contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(10,5));

        //Una passada pel loop
        contador_Test_Deseado = 1 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,5));

        //Dues passades pel loop
        contador_Test_Deseado = 2 * 5;
        int aux = PruebaLoopMMG.TestAniuatLoop1(8,5);
        assertEquals(contador_Test_Deseado, aux );

        //m passades pel loop m<n
        contador_Test_Deseado = 6 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(4,5));

        //(n-1), n passades pel loop (n és el nombremàxim de passades) on n és el nombre màxim possible de passade
        contador_Test_Deseado = 9 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(1,5));


    }

    @Test
    public void  TestAniuatLoop2(){

                /*
        • Començar amb un test simple pel loop més interior, fixant els demés loops al valor mínim
        • Testejar un loop més extern (com si fos un loop simple) mantenint el nombre d’iteracions
        dels loops interiors a valors habituals. */

        MasterMindGame PruebaLoopMMG= new MasterMindGame();
        //---------------LOOP INTERN-------------------------
        //Evitar el loop
        int contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(9,10));

        //Una passada pel loop
        contador_Test_Deseado = 1;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(9,9));

        //Dues passades pel loop
        contador_Test_Deseado = 2;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(9,8));

        //m passades pel loop m<n
        contador_Test_Deseado = 6;
        assertEquals(contador_Test_Deseado, PruebaLoopMMG.TestAniuatLoop2(9,4));

        //(n-1), n passades pel loop (n és el nombremàxim de passades) on n és el nombre màxim possible de passade
        contador_Test_Deseado = 9;
        assertEquals(contador_Test_Deseado, PruebaLoopMMG.TestAniuatLoop2(9,1));

        //---------------------LOOP EXTERN--------------------------
        //Evitar el loop
        contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(10,5));

        //Una passada pel loop
        contador_Test_Deseado = 1 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(9,5));

        //Dues passades pel loop
        contador_Test_Deseado = 2 * 5;
        int aux = PruebaLoopMMG.TestAniuatLoop1(8,5);
        assertEquals(contador_Test_Deseado, aux );

        //m passades pel loop m<n
        contador_Test_Deseado = 6 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(4,5));

        //(n-1), n passades pel loop (n és el nombremàxim de passades) on n és el nombre màxim possible de passade
        contador_Test_Deseado = 9 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(1,5));



    }
}
