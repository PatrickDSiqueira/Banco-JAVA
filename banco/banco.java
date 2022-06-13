package banco;
import java.util.Scanner;
/**
 * main
 */
public class banco {
public static void main (String[]args) {
    Scanner ler = new Scanner(System.in);
    String nomeCliente;
    int numeroContaCorrente, numeroContaPoupanca, opcao = 0;
    double saldoContaCorrente, saldoContaPoupanca;
    
    // System.out.println("Entre com o nome do cliente: ");
    nomeCliente = /*ler.nextLine();*/ "Pedro Dutra";
    // System.out.println("Entre com o número da Conta Corrente: ");
    numeroContaCorrente = /*ler.nextInt();*/ 20330;
    // System.out.println("Entre com o saldo inicial da Conta Corrente "+numeroContaCorrente+": ");
    saldoContaCorrente = /*ler.nextDouble();*/ 100.00;
    // System.out.println("Entre com o número da Conta Poupança: ");
    numeroContaPoupanca = /*ler.nextInt();*/ 20340;
    // System.out.println("Entre com seu saldo inicial da Conta Poupança "+numeroContaPoupanca+": ");
    saldoContaPoupanca = /*ler.nextDouble();*/ 200.00;

    
    menu(opcao, ler);
    ler.close();

}

private static void menu(int opcao, Scanner ler) {
    System.out.println("-------------------------------------------------- \n Qual operação deseja realizar: \n     1 - Creditar \n     2 - Debitar \n     3 - Transferir \n     4 - Saldo \n     5 - Sair");
    System.out.print("Opção -> ");
    opcao = ler.nextInt();

    switch (opcao) {
        case 1:
            System.out.println("Opção -> "+opcao);
            break;
        case 2:
            System.out.println("Opção -> "+opcao);
            break;
        case 3:
            System.out.println("Opção -> "+opcao);
            break;
        case 4:
            System.out.println("Opção -> "+opcao);
            break;
        case 5 :
            System.out.println("Opção -> "+opcao);
            break;
    
        default:
            System.out.println("Opção inválida");
            break;
    }
    
}
}