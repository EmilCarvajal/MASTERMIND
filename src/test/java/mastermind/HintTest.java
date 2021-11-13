package mastermind;

import org.junit.jupiter.api.Test;

public class HintTest {
    @Test
    public void TestCheckCode1(){

        //Verifica si introduciendo codigos igualespara comparar retorna true

        SecretCode secretCode = new SecretCode();
        compareCode.setSecretCode(secretCodeObj.getSecretCode());

        assertTrue(secretCodeObj.checkCode(compareCode.getSecretCode()));
    }

    @Test
    public void TestCheckCode2(){

        //Verifica si introduciendo codigos diferentes para comparar retorna false

        SecretCode compareCode = new SecretCode();
        compareCode.setSecretCode("FFFF"); //La variable secretCode de compareCode != a la variable secretCodede de secretCodeObj

        assertFalse(secretCodeObj.checkCode(compareCode.getSecretCode()));
    }
    @Test
    public void testGenerateHint() {
        Code code = new Code();
        code.setCode("RGBY");
        assertTrue(secretCodeObj.createHint(code) instanceof Hint);
    }

    @Test
    public void test_OrdenaPista_GenerateHint_1() {
        /*Forzamos para que los codigos(code y secretCode) sean diferentes pero con colores correctos, por tanto
        la funciíon GenerateHint() ha de darse cuenta y retornar 'oooo' */

        Code code = new Code();
        code.setCode("OYGR");

        secretCodeObj.setSecretCode("RGYO");

        Hint pista;
        pista = secretCodeObj.createHint(code);
        String str_pista = pista.getHint();

        assertEquals("oooo", str_pista);
    }

    @Test
    public void test_OrdenaPista_GenerateHint_2() {
        /*Hacemos que coincida un caracter y el resto no,
        por tanto el resultado de la pista ha de ser 'xooo' */

        Code code = new Code();
        code.setCode("RYGR");

        secretCodeObj.setSecretCode("RGYO");

        Hint pista;
        pista = secretCodeObj.createHint(code);
        String str_pista = pista.getHint();
        System.out.println( pista.getHint());

        assertEquals("xooo", str_pista);
    }

    @Test
    public void test_OrdenaPista_GenerateHint_3() {
        /*Hacemos que coincidan dos caracteres y el resto no,
        por tanto el resultado de la pista ha de ser 'xxoo' */

        Code code = new Code();
        code.setCode("OOOO");

        secretCodeObj.setSecretCode("RROO");

        Hint pista;
        pista = secretCodeObj.createHint(code);
        String str_pista = pista.getHint();

        assertEquals("xxoo", str_pista);
    }

    @Test
    public void test_OrdenaPista_GenerateHint_4() {
        /*Hacemos que coincidan tres caracteres, por tanto
         el resultado de la pista ha de ser 'xxxo' */

        Code code = new Code();
        code.setCode("OOOO");

        secretCodeObj.setSecretCode("ROOO");

        Hint pista;
        pista = secretCodeObj.createHint(code);
        String str_pista = pista.getHint();

        assertEquals("xxxo", str_pista);
    }

    @Test
    public void test_OrdenaPista_GenerateHint_5() {
        /*Hacemos que coincidan todos los carácter,
        pos tanto el resultado ha de ser 'xxxx' */

        Code code = new Code();
        code.setCode("OOOO");

        secretCodeObj.setSecretCode("OOOO");

        Hint pista;
        pista = secretCodeObj.createHint(code);
        String str_pista = pista.getHint();

        assertEquals("xxxx", str_pista);
    }

    @Test
    public void test_OrdenaPista_GenerateHint_6() {
        /*Test en el que nada coincide en quanto a los colores introducidos.
         El usuario no acierta nada, por tanto se retorna "----" */

        Code code = new Code();
        code.setCode("YOPG");

        secretCodeObj.setSecretCode("RRRR");

        Hint pista;
        pista = secretCodeObj.createHint(code);
        String str_pista = pista.getHint();

        assertEquals("----", str_pista);
    }
}
