package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Hint;
import mastermind.Model.Mocks.MockPlayer2;
import mastermind.Model.Mocks.MockSecretCode;
import mastermind.Model.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
        boolean code_correct = p1.correct_code(null);
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
    @Test //simulacion de una partida completa con una lista determinada de codigos 1 un SecretCode determinado.
    public void Test_Lista_Codigos(){
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

}

