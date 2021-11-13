package mastermind;
import mastermind.Controlador.MasterMindGame;
import mastermind.Model.MockPlayer;
import mastermind.Model.MockPlayer2;
import mastermind.Model.Mock_2_MGame;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MasterMind_Partida_Fake_Test {
    @Test
    public void  PartidaSimulation(){
        //Simula partida. Para imitar las inputs de un usuario hay un alista definida en MOCK_2_MGAME.



        //CASE 1
        Mock_2_MGame mockMasterMind = new Mock_2_MGame();
        mockMasterMind.setCodigosPlayer( new ArrayList<String>(List.of("RRRR", "RBRR", "RBGR", "RBGO", "RBGP", "RBGG","FFFF")));
        mockMasterMind.getSecretCodeObject().setSecretCode("RBGG");
        mockMasterMind.mainGame();
        int intentos = mockMasterMind.getIntentos();
        assertEquals(6,intentos);
        //assertTrue(mockMasterMind.getWin());

        //CASE 2
        Mock_2_MGame mockMasterMind2 = new Mock_2_MGame();
        mockMasterMind2.setCodigosPlayer( new ArrayList<String>(List.of("FFFF", "FFFF", "FFFF", "FFFF", "FFFF", "FFFF","FFFF", "FFFF","FFFF", "FFFF", "FFFF", "FFFF", "FFFF","FFFF","FFFF")));
        mockMasterMind2.getSecretCodeObject().setSecretCode("RBGG");
        mockMasterMind2.mainGame();
        int intentos2 = mockMasterMind2.getIntentos();
        assertEquals(MasterMindGame.MAX_OPPORTUNITIES,intentos2);
       // assertFalse(mockMasterMind2.getWin());

    }

}
