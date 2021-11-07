package mastermind;


// Clase de codigos
public class Code {
    public Code() {}
    public Code(String codi) {
        this.m_codigo = codi;
    }
    public String getCodigo() {return m_codigo;}
    public void setCode(String code){ this.m_codigo=  code; }

    private String m_codigo;

}