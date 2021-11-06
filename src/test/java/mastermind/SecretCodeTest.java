package mastermind;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

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
        for(int index=0; index< MasterMindGame.CODE_LENGTH;index++){

            char letter =  generated_code.charAt(index);
            if( letter == 'R' ||  letter == 'B' || letter == 'Y'|| letter == 'G'||letter == 'P' || letter == 'O' ||letter == 'V' ){

            }
            else{
                check = false;
                Assert.assertEquals(check,true);
            }

        }
        Assert.assertEquals(check,true);

    }




}
