package lexer;


public class Token {

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private Tipos tipo;
    private String valor;

    enum Tipos {
        ENTERO("int"),
        CARACTER("char"),
        FLOTANTE("float"),
        REAL("double"),
        RESERVADA_CORTA("short"),
        RESERVADA_LARGO("long"),
        VACIO("void"),
        BOLEANO("float"),
        EXPONENCIALES("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?"),
        NUMERO_DECIMAL("[0-9]+([\\.][0-9]+)"),
        NUMERO_SIGNO("[+|-]+[0-9]+([,][0-9]*)?"),
        NUMERO ("[0-9]+"),
        LITERAL("[a-zA-Z]+"),
        OPERADOR_TERMINO("[;]"),
        OPERADOR_ASIGNACION("[=]"),
        OPERADOR_BINARIO("[*|/|+|-]");
        
        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }
}