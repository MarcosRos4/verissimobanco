package ContaCorrenteProjeto.view;
// importa a classe scanner para imput do usuario
import java.util.Scanner;
public class AppView {
    // instancia a classe scanner
    private Scanner scanner = new Scanner(System.in);

    // simula um Jlabel ao imprimir um texto no terminal
    public void imprimir(String texto){
        System.out.print(texto);
    }
    // recebe um imput do tipo float
    public float receberFloat(){
        return scanner.nextFloat();
    }
    // recebe um imput do tipo String
    public String receberString(){
        return scanner.next();
    }
}
