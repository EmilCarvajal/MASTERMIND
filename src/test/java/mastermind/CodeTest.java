package mastermind;

import mastermind.Model.Code;
import mastermind.Model.SecretCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hamcrest.Matchers;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class CodeTest {

    Code t_codigo;

    @Test
    void contructor_test_lenth(){
        t_codigo = new Code("holaa");
        assertNotEquals("tamaño no valido",t_codigo.getCodigo(), Matchers.hasLength(4)); //comprovar tamaño lista

    }

    @Test
    void contructor_test_mayusculas(){
        t_codigo = new Code("holaa");
        Assert.assertEquals( t_codigo.getCodigo().toUpperCase(),t_codigo.getCodigo());
    }

    @Test
    void contructor_test_type(){
        t_codigo = new Code("hola");
        assertThat(t_codigo.getCodigo(), Matchers.isA(String.class));
    }

    @Test
    void contructor_test_valid_chars(){

        t_codigo = new Code("brg");

        List<Character> COLORS = Arrays.asList('R', 'B', 'Y', 'G', 'P', 'O','V');

        for (int c = t_codigo.getCodigo().length () -1; c>= 0; c--){
            char ch = t_codigo.getCodigo().toUpperCase(Locale.ROOT).charAt (c);
            System.out.println (ch);
            assertThat("error valid char",COLORS, Matchers.hasItem(ch));
        }
    }

    @Test
    public void TestCheckCode1(){

        SecretCode secretCodeObj;
        secretCodeObj = new SecretCode();

        //Verifica si introduciendo codigos igualespara comparar retorna true

        Code compare = new Code();
        compare.setCode(secretCodeObj.getSecretCode());

        assertTrue(compare.checkCode(secretCodeObj.getSecretCode()));
    }

    @Test
    public void TestCheckCode2(){

        SecretCode secretCodeObj;
        secretCodeObj = new SecretCode();

        //Verifica si introduciendo codigos diferentes para comparar retorna false

        Code compareCode = new Code();
        compareCode.setCode("FFFF"); //La variable secretCode de compareCode != a la variable secretCodede de secretCodeObj

        assertFalse(compareCode.checkCode(secretCodeObj.getSecretCode()));
    }

    @Test
    void code_corrrectTest(){
        t_codigo = new Code("brg");


        List<Character> COLORS = Arrays.asList('R', 'B', 'Y', 'G', 'P', 'O','V');

        for (int c = t_codigo.getCodigo().length () -1; c>= 0; c--){
            char ch = t_codigo.getCodigo().toUpperCase(Locale.ROOT).charAt (c);
            System.out.println (ch);
            assertThat("error valid char",COLORS, Matchers.hasItem(ch));
        }

        assertThat(t_codigo.getCodigo(), Matchers.isA(String.class));
        Assert.assertEquals( t_codigo.getCodigo().toUpperCase(),t_codigo.getCodigo().toUpperCase(Locale.ROOT));
        assertThat("tamaño no valido",t_codigo.getCodigo(), Matchers.hasLength(4)); //comprovar tamaño lista

    }
}
