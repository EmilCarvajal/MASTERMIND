package mastermind;
import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Code;
import mastermind.Model.Hint;
import mastermind.Model.Mocks.MockPlayer2;
import mastermind.Model.Mocks.MockSecretCode;
import mastermind.Model.Player;
import mastermind.Model.SecretCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class SecretCodeTest {

    SecretCode secretCodeObj;

    @BeforeEach
    void setUp(){
        secretCodeObj = new SecretCode();
    }

    @Test
    public void testGenerateSecret1(){

        //Test secretCode length is correct.

        String generated_code = secretCodeObj.getSecretCode();
        Assert.assertEquals(generated_code.length(), MasterMindGame.CODE_LENGTH);

    }

    @Test
    public void testGenerateSecretCode2(){

        //Test if letters of SecretCode are within the possible letters that represent colors (RBYGPOV)

        String generated_code = secretCodeObj.getSecretCode();
        boolean check = true;
        if(generated_code.length() == MasterMindGame.CODE_LENGTH) {
            for (int index = 0; index < MasterMindGame.CODE_LENGTH; index++) {

                char letter = generated_code.charAt(index);
                if (letter == 'R' || letter == 'B' || letter == 'Y' || letter == 'G' || letter == 'P' || letter == 'O' || letter == 'V') {

                } else {
                    check = false;
                    Assert.assertTrue(check);
                }

            }
            Assert.assertTrue(check);
        }
        else {
            check = false;
            Assert.assertTrue(check);
        }
    }

    @Test
    public void testSecretCodeMain(){

        MockSecretCode mockSecretCode = new MockSecretCode();
        MockPlayer2 mockPlayer2 = new MockPlayer2();
        MasterMindGame m_game = new MasterMindGame();
       /* // Set up mock
        MockPlayer2 mockPlayer2 = new MockPlayer2();

        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer2);
        //String str = m_game.playerInterface.IntroduceCode();
        // System.out.println(str);
        //Prova i validació
        m_game.mainGame_Mock();*/
    }



}
