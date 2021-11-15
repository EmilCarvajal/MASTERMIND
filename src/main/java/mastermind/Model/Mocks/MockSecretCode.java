package mastermind.Model.Mocks;
import mastermind.Model.SecretCode_Interface;

public class MockSecretCode implements SecretCode_Interface {

    public String secretCode = "PPPP"; //Para que nunca este en null.
    public boolean is_secret;

    public void setSecretCode(String secretCode){
        this.secretCode = secretCode; //Lista que se pasa desde el Test
    }
    public String generateSecretCode(){
        return this.secretCode;
    }
    public String getSecretCode(){
        return this.secretCode;
    }


}
