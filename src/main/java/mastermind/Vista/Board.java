package mastermind.Vista;

import mastermind.Controlador.MasterMindGame;

import mastermind.Model.Code;
import mastermind.Model.Hint;
import mastermind.Model.SecretCode;

import java.util.ArrayList;
public class Board{
    // METODOS
    public Board() {
        m_listCodigos = new ArrayList<Code>();
        m_listEnciertos = new ArrayList<Hint>();
    }

    public void añadirCodigosTablero(Code codigo) {
        this.m_listCodigos.add(codigo);
    }
    public void añadirPistasTablero(Hint pista) {
        this.m_listEnciertos.add(pista);
    }

    public ArrayList<Hint> getPistasTablero() {
        return this.m_listEnciertos;
    }
    public void setTablero(String tablero) {
        this.tauler = tablero;
    }
    public ArrayList<Code> getListCodigos(){ return m_listCodigos; } //Se usa para test de Mastermind IntroduceCode

    // ATRIBUTOS
    private SecretCode CodigoSecreto;
    private String tauler;
    private ArrayList<Code> m_listCodigos;
    private ArrayList<Hint> m_listEnciertos;


    public void mostrarTablero(SecretCode CodigoSecreto) {
        String tablero = "";
        tablero+="-----------------------------------------------------\n";
        tablero+="                    MASTERMIND\n";
        tablero+="-----------------------------------------------------\n";

        if (CodigoSecreto.is_secret){
            tablero+= "| SEC    SEC    SEC    SEC    | \n";
        }
        //else{
        if (CodigoSecreto.is_secret){
            tablero += "| ";
            for (String cod : CodigoSecreto.getSecretCode().split("")) {
                tablero +=  cod + "      ";
            }
            tablero += "|\n";
        }
        tablero+="-----------------------------------------------------\n";

        for (int i = 0; i < MasterMindGame.MAX_OPPORTUNITIES; i++) {
            if (this.m_listCodigos.size() > i) {
                tablero += "| ";
                for (String cod : m_listCodigos.get(i).getCodigo().split("")) {
                    tablero += cod + "      ";
                }
                tablero += "| ";
                for (String pista : m_listEnciertos.get(i).getHint().split("")) {
                    tablero += pista + "    ";
                }
                tablero += "|\n";
            } else {
                tablero += "| -      -      -      -      | -    -    -    -    |\n";
            }
            tablero+="-----------------------------------------------------\n";
        }
        setTablero(tablero);
        System.out.println(tablero);
    }

}