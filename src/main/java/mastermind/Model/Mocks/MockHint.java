package mastermind.Model.Mocks;

import mastermind.Model.HintInterface;

public class MockHint implements HintInterface {
    String pista = "xooo";
    public String getHint() {
        return this.pista;
    }
    public String ordenarPista(String pistaDesordenada){
        return "xxxo";
    }
}
