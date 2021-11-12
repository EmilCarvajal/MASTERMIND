package mastermind.Model;

public interface PlayerInterface {
    // en la interfaz solo ponemos los metodos que queremos simular y no los declaramos
    String IntroduceCode();
    Boolean correct_code(String code);


}
