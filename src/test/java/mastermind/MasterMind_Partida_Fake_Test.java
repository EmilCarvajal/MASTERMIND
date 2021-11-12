package mastermind;

import mastermind.Model.MockPlayer;
import mastermind.Model.MockPlayer2;
import mastermind.Model.Mock_2_MGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MasterMind_Partida_Fake_Test {
    @Test
    public void  PartidaSimulation(){
        //Simula partida. Para imitar las inputs de un usuario hay un alista definida en MOCK_2_MGAME.

        //MOCKS
        Mock_2_MGame mockMasterMind = new Mock_2_MGame();
        MockPlayer2 Player = new MockPlayer2();

        mockMasterMind.mainGame();
        int intentos = mockMasterMind.getIntentos();
        assertEquals(6,intentos);






    }

}
