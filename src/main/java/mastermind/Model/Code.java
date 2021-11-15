package mastermind.Model;
// Clase de codigos
public class Code {

    private String m_codigo;
    public Code(){};
    public Code(String codi) {
        this.m_codigo = codi.toUpperCase();
    }
    public String getCodigo() {return m_codigo;}
    public boolean checkCode(String code) {
        return this.m_codigo.equals(code);
    }
    public void setCode(String str){ this.m_codigo = str;}

}