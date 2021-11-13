package mastermind;


import mastermind.Controlador.MasterMindGame;
import mastermind.Model.Code;
import mastermind.Model.MockPlayer;
import mastermind.Model.MockPlayer2;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.*;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMasterMind {
    @Test
    public void Test_Update_Code() {
        // Set up mock
        MockPlayer mockPlayer = new MockPlayer();
        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer);

        //Prova i validació
        m_game.update_code();
        System.out.println(m_game.code_answer_correct);
        assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);
    }
/* No esta bien este
    @Test
    public void Test_pairwase() {
        // Test de diversas parejas de colores NO repetidas

        List<String> l_colors = MasterMindGame.COLORS;
        List<String> p_colors = new ArrayList<String>(List.of(""));//= new List<String>(List.of(""));
        //new ArrayList<String>(List.of(
        //"R", "B", "Y", "G", "P", "O","V"))
        for (String color_1 : l_colors) { //y g b r v o
            System.out.println("color1  " + color_1);
            List<String> c_instance;
            String combination = color_1;
            int n_l1 = 1;
            for (int c2 = 0; c2 < l_colors.size(); c2++) {
                combination += l_colors.get(c2);

                n_l1++;
                if (n_l1 == 4) {

                    System.out.println(combination);

                    // iniciar lista
                    if (p_colors.get(0) == "")
                        p_colors.set(0, combination);

                        // comprovar parejas ya creadas
                    else {
                        boolean parella_in = false;
                        // recorrer combinaciones de lista pairwise

                        for (String comb : p_colors) {
                            int c_iguals = 0;
                            // recorrer letras de combinacion pw

                            for (int c = comb.length() - 1; c >= 0; c--) {
                                char lletra = comb.charAt(c);

                                //recorrer letras combinacion actual
                                for (int ca = combination.length() - 1; c >= 0; c--) {
                                    char lletra_ca = comb.charAt(ca);
                                    if (lletra == lletra_ca)
                                        c_iguals += 1;
                                    if (c_iguals == 2) {
                                        parella_in = true;
                                        break;
                                    }


                                }
                                if (parella_in == true)
                                    break;

                            }
                            if (parella_in == true)
                                break; // break for general if
                        }
                        if (parella_in == true)
                            p_colors.add(combination);
                    }
                }
            } // end for pairwise
            System.out.println("__________________________________________");
            System.out.println("Lengt total is: " + p_colors.size());
            for (String p_com : p_colors) {
                System.out.println(p_com);
            }

        }
    }

*/
    @Test //no esta bien
    public void Test_Lista_Codigos(){
        // Set up mock
        MockPlayer2 mockPlayer2 = new MockPlayer2();

        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer2);
        System.out.println(m_game.playerInterface.IntroduceCode());
        //Prova i validació
        m_game.mainGame_Mock();
        System.out.println("hii");
        //System.out.println(m_game.code_answer_correct);
        assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        //assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Pairwise.csv",numLinesToSkip = 1,delimiterString = ";")
    public void Test_PairwiseCSV(final String v1,final String v2,final String v3,final String v4) {
        // COMPROVEM TOTES LES PARELLES DISCRETES DE POSIBLES ENTRADES
        String codigo = v1+v2+v3+v4;
        //List<String> p_colors = new ArrayList<String>(List.of(codigo));
        System.out.println(codigo);


        // Set up mock
        MockPlayer mockPlayer = new MockPlayer();
        mockPlayer.setCode(codigo);

        // Declaració y setup clase que crida al Mock
        MasterMindGame m_game = new MasterMindGame();
        m_game.setPlayer(mockPlayer);
        System.out.println(m_game.playerInterface.IntroduceCode());
        //Prova i validació
        m_game.mainGame_Mock();
        //System.out.println(m_game.code_answer_correct);
        //assertTrue("Code_answer is not correct",m_game.code_answer_correct);
        //assertEquals("Expected code is not correct","ygbr",m_game.Code_Mock);

    }

}
