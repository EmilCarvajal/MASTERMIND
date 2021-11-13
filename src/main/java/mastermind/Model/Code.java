package mastermind.Model;


import java.util.Locale;

// Clase de codigos
public class Code {
    public Code() {}
    public Code(String codi) {
        this.m_codigo = codi.toUpperCase();
    }
    public String getCodigo() {return m_codigo;}
    public void setCode(String code){ this.m_codigo=  code.toUpperCase(); }

    private String m_codigo;

}