package mastermind;


import mastermind.Controlador.MasterMindGame;
import mastermind.Model.MockPlayer;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMasterMind {

    @Test
    public void Test_Update_Code() {
        // Set up mock
        MockPlayer mockPlayer = new MockPlayer();
        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer);

        //Prova i validació
        m_game.update_code();
        System.out.println(m_game.code_answer_correct);
        assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);
    }
}
