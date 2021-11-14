package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Code;
import mastermind.Model.Mocks.MockPlayer2;
import mastermind.Model.SecretCode;
import mastermind.Vista.Board;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

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
             assertEquals(added_codeToBoard.getCodigo(), compareCode.getCodigo()); //Codigo a�adido al tablero ha de coincidir con el que ha introduciso el usuario
         }

        indexListCodigos ++;
        str_code = MG.getSecretCode(); //Codigo introducido por usuario es el mismo que el codigo secreto. Usuaio debe ganar y Over == true;
        MG.introduceCode(str_code);

        compareCode =  new Code(str_code);
        added_codeToBoard = MG.getBoard().getListCodigos().get(indexListCodigos);

        assertTrue(MG.getWin()); //Usuario ha ganado
        assertTrue(MG.getisOver()); //La partida se ha acabado
        assertEquals(added_codeToBoard.getCodigo(), compareCode.getCodigo()); //Codigo a�adido al tablero ha de coincidir con el que ha introduciso el usuario

    }

    @Test
    public void Test_Lista_Codigos(){
        // Set up mock
        MockPlayer2 mockPlayer2 = new MockPlayer2();

        // Declaraci� y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer2);
        //String str = m_game.playerInterface.IntroduceCode();
       // System.out.println(str);
        //Prova i validaci�
        m_game.mainGame_Mock();

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
        //(n-1), n passades pel loop (n �s el nombrem�xim de passades) on n �s el nombre m�xim possible de passades
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
        //(n-1), n passades pel loop (n �s el nombrem�xim de passades) on n �s el nombre m�xim possible de passades
        contador_Test_Deseado = 99;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestSimpleLoop2(1) );

    }

    @Test
    public void TestAniuatLoop1(){
        /*
        � Comen�ar amb un test simple pel loop m�s interior, fixant els dem�s loops al valor m�nim
        � Testejar un loop m�s extern (com si fos un loop simple) mantenint el nombre d�iteracions
        dels loops interiors a valors habituals. */

        MasterMindGame PruebaLoopMMG= new MasterMindGame();
        //---------------LOOP INTERN-------------------------
        //Evitar el loop
        int contador_Test_Deseado = 0;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,10));

        //Una passada pel loop
        contador_Test_Deseado = 1;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,9));

        //Dues passades pel loop
        contador_Test_Deseado = 2;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,8));

        //m passades pel loop m<n
        contador_Test_Deseado = 6;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(9,4));

        //(n-1), n passades pel loop (n �s el nombrem�xim de passades) on n �s el nombre m�xim possible de passade
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

        //(n-1), n passades pel loop (n �s el nombrem�xim de passades) on n �s el nombre m�xim possible de passade
        contador_Test_Deseado = 9 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop1(1,5));


    }

    @Test
    public void  TestAniuatLoop2(){

                /*
        � Comen�ar amb un test simple pel loop m�s interior, fixant els dem�s loops al valor m�nim
        � Testejar un loop m�s extern (com si fos un loop simple) mantenint el nombre d�iteracions
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
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(9,4));

        //(n-1), n passades pel loop (n �s el nombrem�xim de passades) on n �s el nombre m�xim possible de passade
        contador_Test_Deseado = 9;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(9,1));

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

        //(n-1), n passades pel loop (n �s el nombrem�xim de passades) on n �s el nombre m�xim possible de passade
        contador_Test_Deseado = 9 * 5;
        assertEquals(contador_Test_Deseado,PruebaLoopMMG.TestAniuatLoop2(1,5));



    }
}
