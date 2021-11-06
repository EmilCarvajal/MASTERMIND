package mastermind;

import java.util.ArrayList;

import static mastermind.MasterMindGame.MAX_OPPORTUNITIES;

//NO NECESSARIA DE TESTEJAR, NOMES FA PRINTS
//clase encargada de printar el tauler mostrant cada intent amb la seva pista corresponent
public class Board{

    //	historial de codis introduits per el jugador
    private ArrayList<Code> m_listCodigos;
    //	historial de pistes introduits per el jugador
    private ArrayList<Hint> m_listEnciertos;
    private String tauler;

    public Board() {
//		inicialitzacio de les variable
        m_listCodigos = new ArrayList<Code>();
        m_listEnciertos = new ArrayList<Hint>();
    }

    //	GETTER
    public ArrayList<Code> getCodigosTablero() {
//		retorna el historial de codis com una ArrayList
        return this.m_listCodigos;
    }

    public ArrayList<Hint> getPistasTablero() {
//		retorna el historial de pistes com una ArrayList
        return this.m_listEnciertos;
    }

    //	SETTER
    public void añadirCodigosTablero(Code codigo) {
        this.m_listCodigos.add(codigo);
    }

    //	SETTER
    public void añadirPistasTablero(Hint pista) {
        this.m_listEnciertos.add(pista);

    }

    public void mostrarTablero() {
        String tablero = "";
        tablero+="-----------------------------------------\n";
        tablero+="            MASTERMIND\n";
        tablero+="-----------------------------------------\n";
        tablero += "+-------------------+\n";
        tablero += "| intents | pistes  |\n";
        tablero += "+-------------------+\n";
        for (int i = 0; i < MAX_OPPORTUNITIES; i++) {
            if (this.m_listCodigos.size() > i) {
                tablero += "| ";
                for (String codiChar : m_listCodigos.get(i).getCodigo().split("")) {
                    tablero += codiChar + " ";
                }
                tablero += ": ";
                for (String pistaChar : m_listCodigos.get(i).getPista().split("")) {
                    tablero += pistaChar + " ";
                }
                tablero += "|\n";
            } else {
                tablero += "| - - - - : - - - - |\n";
            }
        }
        tauler += "+-------------------+";
        setTauler(tauler);
    }
  /*
    public void setTauler() {
        String tauler = "";
        tauler += "+-------------------+\n";
        tauler += "| intents | pistes  |\n";
        tauler += "+-------------------+\n";
        for (int i = 0; i < Mastermind.MAX_INTENTS; i++) {
            if (this.historialCodis.size() > i) {
                tauler += "| ";
                for (String codiChar : historialCodis.get(i).getCodi().split("")) {
                    tauler += codiChar + " ";
                }
                tauler += ": ";
                for (String pistaChar : historialPistes.get(i).getPista().split("")) {
                    tauler += pistaChar + " ";
                }
                tauler += "|\n";
            } else {
                tauler += "| - - - - : - - - - |\n";
            }
        }
        tauler += "+-------------------+";
        setTauler(tauler);
    }
*/
    public String getTauler() {
        return tauler;
    }

    public void setTauler(String tauler) {
        this.tauler = tauler;
    }


}