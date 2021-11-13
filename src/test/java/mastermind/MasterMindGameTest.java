package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.MockPlayer2;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterMindGameTest {

    @Test
    public void testConstructor(){
        MasterMindGame MG= new MasterMindGame();
        boolean test=true;

        if(MG.getWin() || MG.getisOver()){test=false;}
        if(MG.getIntentos() != 0){test=false;}
        if(MG.getListaIntentos().size()!=0 ){test=false;}
        Assert.assertEquals(test,true);

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

        //System.out.println(m_game.code_answer_correct);
        Assert.assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        //assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);

    }
}
