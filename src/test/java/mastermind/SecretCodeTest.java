package mastermind;

import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Mocks.MockSecretCode;
import mastermind.Model.SecretCode;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SecretCodeTest {

    SecretCode secretCodeObj;

    @BeforeEach
    void setUp(){
        secretCodeObj = new SecretCode();
    }

    @Test
    public void TestConstructorSecretCode(){

        //Test secretCode length is correct.

        String generated_code = secretCodeObj.getSecretCode();
        Assert.assertEquals(generated_code.length(), MasterMindGame.CODE_LENGTH);

    }

    @Test
    public void TestGenerateSecretCode(){

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
        //comprueva la inicializacion de SecretCodes sin necesidad de una clase SecretCode,
        // se utiliza una SecretCodeOnterface
        MockSecretCode mockSecretCode = new MockSecretCode();
        mockSecretCode.setSecretCode("YGBR");
        MasterMindGame m_game = new MasterMindGame();

        m_game.setSecretCodeInterface(mockSecretCode);
        m_game.introduceCode_Mock_SecretCode("RGOP");

        assertEquals("xo--", m_game.getBoard().getPistasTablero().get(0).getHint());
    }

}
