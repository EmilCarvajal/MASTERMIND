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
    public void Test_Lista_Codigos(){
        // Set up mock
        MockPlayer2 mockPlayer2 = new MockPlayer2();

        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer2);
        //String str = m_game.playerInterface.IntroduceCode();
       // System.out.println(str);
        //Prova i validació
        m_game.mainGame_Mock();



    }
}
