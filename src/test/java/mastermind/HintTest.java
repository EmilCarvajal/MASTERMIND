package mastermind;

import mastermind.Model.Code;
import mastermind.Model.Hint;
import mastermind.Model.SecretCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HintTest {

    SecretCode secretCodeObj;
    Code code;
    @BeforeEach
    void setUp(){
        secretCodeObj = new SecretCode();
        code = new Code();
    }
    @Test
    public void TestConstructorHint() {
        /*Forzamos para que los codigos(code y secretCode) sean diferentes pero con colores correctos, por tanto
        la funci?on GenerateHint() ha de darse cuenta y retornar 'oooo' */

        code.setCode("OYGR");
        secretCodeObj.setSecretCode("RGYO");

        Hint pista = new Hint(secretCodeObj,code);
        String str_pista = pista.getHint();

        assertEquals("oooo", str_pista);

        /*Hacemos que coincida un caracter y el resto no,
        por tanto el resultado de la pista ha de ser 'xooo' */

        code.setCode("RYGR");
        secretCodeObj.setSecretCode("RGYO");

        pista = new Hint(secretCodeObj,code);
        str_pista = pista.getHint();

        assertEquals("xooo", str_pista);

        /*Hacemos que coincidan dos caracteres y el resto no,
        por tanto el resultado de la pista ha de ser 'xxoo' */

        code.setCode("OOOO");
        secretCodeObj.setSecretCode("RROO");

        pista= new Hint(secretCodeObj,code);
        str_pista = pista.getHint();

        assertEquals("xxoo", str_pista);

        /*Hacemos que coincidan tres caracteres, por tanto
         el resultado de la pista ha de ser 'xxxo' */

        code.setCode("OOOO");
        secretCodeObj.setSecretCode("ROOO");

        pista= new Hint(secretCodeObj,code);
         str_pista = pista.getHint();

        assertEquals("xxxo", str_pista);

        /*Hacemos que coincidan todos los car?cter,
        pos tanto el resultado ha de ser 'xxxx' */

        code.setCode("OOOO");
        secretCodeObj.setSecretCode("OOOO");

        pista= new Hint(secretCodeObj,code);
        str_pista = pista.getHint();

        assertEquals("xxxx", str_pista);

        /*Test en el que nada coincide en quanto a los colores introducidos.
         El usuario no acierta nada, por tanto se retorna "----" */

        code.setCode("YOPG");
        secretCodeObj.setSecretCode("RRRR");

        pista = new Hint(secretCodeObj,code);
        str_pista = pista.getHint();

        assertEquals("----", str_pista);
    }
    @Test
    public void TestSortHint(){

        Hint pista = new Hint();
        String Unsorted_Hint = "-oxo";
        String Sorted_Hint = "xoo-";
        String returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertEquals(Sorted_Hint, returned_Hint);

        Unsorted_Hint = "-xoo";
        Sorted_Hint = "xoo-";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertEquals(Sorted_Hint, returned_Hint);

        Unsorted_Hint = "---o";
        Sorted_Hint = "o---";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertEquals(Sorted_Hint, returned_Hint);

        Unsorted_Hint = "ooox";
        Sorted_Hint = "xooo";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertEquals(Sorted_Hint, returned_Hint);

        Unsorted_Hint = "xo--";
        Sorted_Hint = "xo--";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertEquals(Sorted_Hint, returned_Hint);

        Unsorted_Hint = "----";
        Sorted_Hint = "----";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertEquals(Sorted_Hint, returned_Hint);

        Unsorted_Hint = "-oxo----";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertNull(returned_Hint);


        Unsorted_Hint = "oxo";
        returned_Hint = pista.ordenarPista(Unsorted_Hint);
        assertNull(returned_Hint);

    }





}