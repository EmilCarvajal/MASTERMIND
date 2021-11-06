package mastermind;

import java.util.ArrayList;

import static mastermind.MasterMindGame.MAX_OPPORTUNITIES;

//NO NECESSARIA DE TESTEJAR, NOMES FA PRINTS
//clase encargada de printar el tauler mostrant cada intent amb la seva pista corresponent
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
    public String getTablero() {
        return tauler;
    }
    public ArrayList<Code> getCodigosTablero() {
        return this.m_listCodigos;
    }
    public ArrayList<Hint> getPistasTablero() {
        return this.m_listEnciertos;
    }
    public void setTablero(String tablero) {
        this.tauler = tablero;
    }

    // ATRIBUTOS
    private SecretCode CodigoSecreto;
    private String tauler;
    private ArrayList<Code> m_listCodigos;
    private ArrayList<Hint> m_listEnciertos;


    public void mostrarTablero() {
        String tablero = "";
        tablero+="-----------------------------------------\n";
        tablero+="            MASTERMIND\n";
        tablero+="-----------------------------------------\n";

        if (CodigoSecreto.is_secret){
            tablero+= "SEC    SEC    SEC    SEC    | \n";
        }
        else{
            for (String cod : CodigoSecreto.getSecretCode().split("")) {
                tablero += cod + " ";
            }
        }
        /*
        tablero += "+-------------------+\n";
        tablero += "| intents | pistes  |\n";
        tablero += "+-------------------+\n";
        */
        for (int i = 0; i < MAX_OPPORTUNITIES; i++) {
            if (this.m_listCodigos.size() > i) {
                tablero += "| ";
                for (String cod : m_listCodigos.get(i).getCodigo().split("")) {
                    tablero += cod + " ";
                }
                tablero += "| ";
                for (String pista : m_listEnciertos.get(i).getHint().split("")) {
                    tablero += pista + " ";
                }
                tablero += "|\n";
            } else {
                tablero += "| - - - - | - - - - |\n";
            }
            tablero+="-----------------------------------------\n";
        }
        setTablero(tauler);
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

  public static void main(String[] args) {
      Player p1= new Player();
      String answer =  p1.IntroduceCode();
      if(answer!=null){System.out.println(answer);}
      //List<String> codisColorsCorrectes = new ArrayList<String>(MasterMindGame.COLORS);
      //System.out.println(codisColorsCorrectes);
  }

   */

}