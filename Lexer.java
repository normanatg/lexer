package lexer;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

import static lexer.Token.Tipos;

public class Lexer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la expresion: ");
        String input = scanner.nextLine();
        ArrayList<Token> tokens = lex(input);
        for (Token token : tokens) {
            System.out.println("(" + token.getTipo() + ": " + token.getValor() + ")");
        }
    }

    private static ArrayList<Token> lex(String input) {
        final ArrayList<Token> tokens = new ArrayList<Token>();
        final StringTokenizer st = new StringTokenizer(input);
        while(st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;
            for (Tipos tokenTipo : Tipos.values()) {
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);
                if(matcher.find()) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tokens.add(tk);
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                throw new RuntimeException("Se encontro un token invalido.");
            }
        }

        return tokens;
    }
}