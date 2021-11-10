package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.MockMGameConstructorInterface;
import mastermind.Model.MockPlayer;
import mastermind.Model.Player;
import mastermind.Vista.Board;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class MGameConstructorInterfaceTest {
    @Test
    public void Test_Inicialitzar_Variables() {
        System.out.println("------------------------------------");
        System.out.println("Test_Inicialitzar_Variables");
        // Set up mock
        MockMGameConstructorInterface mockMGameConstructor = new MockMGameConstructorInterface();
        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();

        //Prova i validació
        m_game.setMgci(mockMGameConstructor);
        m_game.contructor_mock();
        System.out.println("intentos "+m_game.getIntentos());

        assertEquals("Expected Secretcode is not correct","ygbr".toUpperCase(Locale.ROOT),m_game.getSecretCode());
        assertEquals("Intentos not correct",10,m_game.getIntentos());
        assertFalse("Win not correct",m_game.getWin());
        assertFalse("IsOver not correct",m_game.getisOver());
        System.out.println("------------------------------------");
    }

    @Test
    public void Test_In_Var_and_Play_with_mock_player(){
        System.out.println("Test_In_Var_and_Play_with_mock_player");
        // Set up mocks
        MockPlayer mockPlayer = new MockPlayer();
        MockMGameConstructorInterface mockMGameConstructor = new MockMGameConstructorInterface();

        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer);

        //Prova i validació
        m_game.setMgci(mockMGameConstructor);
        m_game.contructor_mock();
        m_game.update_code();

        m_game.getListaIntentos().add(m_game.Code_Mock);
        m_game.introduceCode(m_game.getListaIntentos().get(0));

        assertEquals("Expected code is not correct","ygbr".toUpperCase(Locale.ROOT),m_game.Code_Mock);
    }
}
