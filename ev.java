import java.util.Random;
import java.util.Scanner;

git config --global user.email "renanjaques13@gmail.com"public class ev 
{
    public static void main(String[] args){
        
        Random aleatorio = new Random();
        Scanner scan = new Scanner(System.in);

        int valor = aleatorio.nextInt(30); 
        int numero;
        int tentativas = 0;

        do {
            System.out.print("Digite um número: ");
            numero = scan.nextInt();
            tentativas++;

            if(numero < valor){
                System.out.println("Palpite menor");
            }
            else if(numero > valor){
                System.out.println("Palpite maior");
            }
            else{
                System.out.println("Acertou!");
            }
            System.out.println("Número de tentativas: " + tentativas);
             

        } while(numero != valor);

        System.out.println("Número de tentativas: " + tentativas);

    
    }
}