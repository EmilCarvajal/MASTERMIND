package mastermind;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterMindGameTest {

    @Test
    public void testConstructor(){
        MasterMindGame MG= new MasterMindGame();
        boolean test=true;

        if(MG.getWin() || MG.getisOver()){test=false;}
        if(MG.getIntentos() != 0){test=false;}
        if(MG.getListaIntentos().size()!=0 ){test=false;}
        Assert.assertEquals(test,true);

    }
}
