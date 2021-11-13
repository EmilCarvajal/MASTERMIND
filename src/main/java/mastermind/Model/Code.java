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
    public boolean checkCode(String code) {
        return this.m_codigo.equals(code);
    }

    private String m_codigo;

}