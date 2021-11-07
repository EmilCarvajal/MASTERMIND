package mastermind;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecretCodeTest {
    @Test
    public void testGenerateSecretCode1(){
        SecretCode code = new SecretCode();
        String generated_code = code.getSecretCode();
        Assert.assertEquals(generated_code.length(),MasterMindGame.CODE_LENGTH);

    }
    @Test
    public void testGenerateSecretCode2(){
        SecretCode code = new SecretCode();
        String generated_code = code.getSecretCode();
        boolean check=true;
        if(generated_code.length()==MasterMindGame.CODE_LENGTH ) {
            for (int index = 0; index < MasterMindGame.CODE_LENGTH; index++) {

                char letter = generated_code.charAt(index);
                if (letter == 'R' || letter == 'B' || letter == 'Y' || letter == 'G' || letter == 'P' || letter == 'O' || letter == 'V') {

                } else {
                    check = false;
                    Assert.assertEquals(check, true);
                }

            }
            Assert.assertEquals(check, true);
        }
        else {
            check = false;
            Assert.assertEquals(check, true);
        }
    }
    @Test
    public void TestCheckCode1(){
        //CODIGOS IGUALES
        SecretCode secretCode = new SecretCode();
        SecretCode compareCode = new SecretCode();
        compareCode.setSecretCode(secretCode.getSecretCode());

        secretCode.checkCode(compareCode.getSecretCode());
    }
    @Test
    public void TestCheckCode2(){
        //CODIGOS DIFERENTES
        SecretCode secretCode = new SecretCode();
        SecretCode compareCode = new SecretCode();

        assertFalse(secretCode.checkCode(compareCode.getSecretCode()));
    }
    @Test
    public void testGenerateHint() {
        SecretCode secretCode = new SecretCode();
        Code code = new Code();
        code.setCode("RGBY");
        assertTrue(secretCode.createHint(code) instanceof Hint);
    }

}
