package mastermind;

import mastermind.Model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CodeTest {

    Code t_codigo;
    @Test
    void TestConstructorCode(){
        t_codigo = new Code("STRING");
        assertEquals("STRING", t_codigo.getCodigo());
    }
    @Test
    public void TestCheckCode(){

        Code code = new Code("YYYY");

        //Verifica si introduciendo codigos iguales para comparar retorna true
        assertTrue(code.checkCode("YYYY"));

        //Verifica si introduciendo codigos  no iguales para comparar retorna false
        assertFalse(code.checkCode("FFFF"));

    }

}
