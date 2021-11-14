package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Mocks.MockPlayer2;
import org.junit.Assert;
import org.junit.Test;

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
        //Assert.assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        //assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);

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
}
