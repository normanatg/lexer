import java.util.Scanner;

public class Lexer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la expresion: ");
        String input = scanner.nextLine();
        if (scaner(input) == 0){
            System.out.println("Expresion mal formada");
        }else{
            System.out.println("Expresion valida");
        }
    }
    public static int mover(int estado, char c){
       if (estado == 0){
            return 0;
        }
        if(estado == 1){
            if(digito(c)){
                return 2;
            }else if(c == '+'||c == '-'){
                return 3;
            }else if(letra(c)){
                return 6;
            }
        }
        if(estado == 2){
            if(digito(c)){
                return 2;
            }else if(c == '.'){
                return 4;
            } else if(c == ';'){
                return 99;
            } else if(c == 'e' || c == 'E' || c == '^'){
                return 7;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if(estado == 3){
            if(digito(c)){
                return 2;
            }
        }
        if (estado == 4){
            if(digito(c)){
                return 5;
            }
        }
        if(estado == 5){
            if(digito(c)){
                return 5;
            } else if(c == ';'){
                return 99;
            } else if(c == 'e' || c == 'E' || c == '^'){
                return 7;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if(estado == 6){
            if(letra(c)){
                return 6;
            }else if (c == ';'){
                return 99;
            }else if(c == '_'){
                return 12;
            }else if(digito(c)){
                return 13;
            }else if(c == ' '){
                return 15;
            }else if(c == '='){
                return 16;
            }
        }
        if (estado == 7){
            if(digito(c)){
                return 8;
            }else if(c == '+'||c == '-'){
                return 11;
            }
        }
        if (estado == 8){
            if (digito(c)){
                return 8;
            }else if(c == '.'){
                return 9;
            }else if(c == ';'){
                return 99;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if (estado == 9){
            if(digito(c)){
                return 10;
            }
        }
        if (estado == 10){
            if(digito(c)){
                return 10;
            }else if(c == ';'){
                return 99;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if (estado == 11){
            if(digito(c)){
                return 8;
            }
        }
        if (estado == 12){
            if(letra(c)){
                return 14;
            }else if(c == '_'){
                return 12;
            }else if(digito(c)){
                return 13;
            }else if(c == ';'){
                return 99;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if(estado == 13){
            if(letra(c)){
                return 14;
            }else if(c == '_'){
                return 12;
            }else if(digito(c)){
                return 13;
            }else if(c == ';'){
                return 99;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if(estado == 14){
             if(letra(c)){
                return 14;
            }else if(c == '_'){
                return 12;
            }else if(digito(c)){
                return 13;
            }else if(c == ';'){
                return 99;
            }else if(c == ' '){
                return 18;
            }else if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }
        }
        if(estado == 15){
            if(c == '='){
                return 16;
            }else if(letra(c)){
                return 6;
            }
        }
        if(estado == 16){
            if(digito(c)){
                return 2;
            }else if(letra(c)){
                return 14;
            }else if(c == ' '){
                return 17;
            }else if(c == '+'||c == '-'){
                return 3;
            }
        }
        if(estado == 17){
            if(digito(c)){
                return 2;
            }else if(letra(c)){
                return 14;
            }else if(c == '+'||c == '-'){
                return 3;
            }
        }
        if (estado == 18){
            if(c == '+' || c == '-' || c == '/'||c == '*'){
                return 19;
            }else if(c == '='){
                return 16;
            }
        }
        if (estado == 19){
            if(digito(c)){
                return 2;
            }else if(letra(c)){
                return 14;
            }else if(c == ' '){
                return 20;
            }else if(c == '+'||c == '-'){
                return 3;
            }
        }
        if(estado == 20){
            if(digito(c)){
                return 2;
            }else if(letra(c)){
                return 14;
            }else if(c == '+'||c == '-'){
                return 3;
            }
        }
        return 0;
    }

    public static int scaner(String expresion){
        int i = 0;
        int x__x = 0;
        int estado = 1; //Estado inicial
        int tam = expresion.length();
        System.out.print("Recorido: "+estado);
        for(char c :expresion.toCharArray()){
            estado = mover(estado, c);
            System.out.print("-"+estado);
            i++;
        }
        System.out.println(" ");
        if (estado == 99 && tam == i)
            return 1;
        
        return 0;
    }

    public static boolean digito(char c){
        if(c == '1'||c == '2'||c == '3'||c == '4'||c == '5'||c == '6'||c == '7'||c == '8'||c == '9'||c == '0'){
            return true;
        }
        return false;
    }
    public static boolean letra(char c){
        int i = (int)c;
        if((i >= 65 && i<=90) || (i>= 97 && i <= 122)){
            return true;
        }
        return false;
    }
}