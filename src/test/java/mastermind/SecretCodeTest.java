package mastermind;
import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Code;
import mastermind.Model.Hint;
import mastermind.Model.SecretCode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecretCodeTest {
    @Test
    public void testGenerateSecretCode1(){
        SecretCode code = new SecretCode();
        String generated_code = code.getSecretCode();
        Assert.assertEquals(generated_code.length(), MasterMindGame.CODE_LENGTH);

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
    public void testGenerateHint1() {
        SecretCode secretCode = new SecretCode();
        Code code = new Code();
        code.setCode("RGBY");
        assertTrue(secretCode.createHint(code) instanceof Hint);
    }
    @Test
    /*Generamos un nuevo codigo que sea igual al código secreto que también generamos, por tanto la funciíon GenerateHint() ha de
     darse cuenta de que coinciden color y posiciones (son iguales) y por tanto retornar 'xxxx'*/
    public void testGenerateHint2() {
        SecretCode secretCode = new SecretCode();
        Code code = new Code();
        code.setCode(secretCode.getSecretCode());

        Hint pista;
        pista= secretCode.createHint(code);
        String str_pista = pista.getHint();
       assertEquals("xxxx",str_pista);
    }
    @Test
    /*Forzamos para que los codigos(code y secretCode) sean diferentes, por tanto la funciíon GenerateHint() ha de
    darse cuenta y retornar 'oooo'*/
    public void testGenerateHint3() {
        SecretCode secretCode = new SecretCode();
        Code code = new Code();
        secretCode.setSecretCode("RGYO");
        code.setCode("OYGR");
        Hint pista;
        pista= secretCode.createHint(code);
        String str_pista= pista.getHint();
        assertEquals("oooo",str_pista);
    }

    @Test
    /*Hacemos que coincida un caracter( el primero por ejemplo), y el resto no,
     por tanto el resultado de la pista ha de ser 'xooo'.*/
    public void testGenerateHint4() {
        SecretCode secretCode = new SecretCode();
        Code code = new Code();
        secretCode.setSecretCode("RGYO");
        code.setCode("RYGR");
        Hint pista;
        pista= secretCode.createHint(code);
        String str_pista= pista.getHint();
        assertEquals("xooo",str_pista);
    }



}
