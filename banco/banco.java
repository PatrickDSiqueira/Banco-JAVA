package banco;
import java.util.Scanner;
public class banco {
    public static Scanner ler = new Scanner(System.in);
    public static String nomeCliente = "classBanco", tipoConta="";
    public static int numeroContaCorrente, numeroContaPoupanca, opcao = 0;
    public static double saldoContaCorrente, saldoContaPoupanca;
public static void main (String[]args) {
    incio();
    menu();
}

private static void incio() {
    // System.out.println("Entre com o nome do cliente: ");
    nomeCliente = /*ler.nextLine();*/ "Pedro Dutra";
    System.out.println("Entre com o número da Conta Corrente: ");
    numeroContaCorrente = /*ler.nextInt();*/ 20330;
    // System.out.println("Entre com o saldo inicial da Conta Corrente "+numeroContaCorrente+": ");
    saldoContaCorrente = /*ler.nextDouble();*/ 100.00;
    // System.out.println("Entre com o número da Conta Poupança: ");
    numeroContaPoupanca = /*ler.nextInt();*/ 20340;
    // System.out.println("Entre com seu saldo inicial da Conta Poupança "+numeroContaPoupanca+": ");
    saldoContaPoupanca = /*ler.nextDouble();*/ 200.00;
}

private static  void menu() {
    System.out.println("-------------------------------------------------- \n Qual operação deseja realizar: \n     1 - Creditar \n     2 - Debitar \n     3 - Transferir \n     4 - Saldo \n     5 - Sair");
    System.out.print("Opção -> ");
    opcao = ler.nextInt();

    switch (opcao) {
        case 1:
            creditar();
            menu();        
            break;
        case 2:
            debitar();
            menu();
            break;
        case 3:
            transferir();
            menu();
            break;
        case 4:
            System.out.println("Opção -> "+opcao);
            break;
        case 5 :
            System.out.println("Opção -> "+opcao);
            break;
    
        default:
            System.out.println("Opção inválida");
            menu();
            break;
    }
}

private static void transferir() {
    escolheOpcaoTransferencia();
    mostraSaldo("ambas");
}

private static void escolheOpcaoTransferencia() {
    System.out.print("Entre:\n    1 - Conta corrente e poupança\n    2 - Poupança e conta corrente\n     Opção -> ");
    opcao = ler.nextInt();
    switch (opcao) {
        case 1:
            opcao = 1;
            break;
        case 2:
             opcao = 2;
             break;
        default:
            System.out.println("Opção inválida");
            escolheOpcaoTransferencia();
            break;
    }
}

private static void mostraSaldo(String conta) {
    switch (conta) {
        case "ambas":            
            System.out.printf("Saldo atual na Conta Corrente %d -> R$ %.2f \n", numeroContaCorrente, saldoContaCorrente);
            System.out.printf("Saldo atual na Conta Poupança %d -> R$ %.2f \n", numeroContaPoupanca, saldoContaPoupanca);
            break;

        case "corrente":
            System.out.printf("Saldo atual na Conta Corrente %d -> R$ %.2f", numeroContaCorrente, saldoContaCorrente);
            break;
        
        case "poupanca":
            System.out.printf("Saldo atual na Conta Poupança %d -> R$ %.2f", numeroContaPoupanca, saldoContaPoupanca);
            break;

        default:
            break;
    }
}

private static void debitar() {
    escolheConta();
    if (tipoConta.equals("Corrente")) {
        System.out.print("Qual valor a debitar na conta corrente "+numeroContaCorrente+" -> R$ ");
        saldoContaCorrente -= ler.nextDouble();
        mostraSaldo("corrente");
    } else if (tipoConta.equals("Poupança")) {
        System.out.print("Qual valor a debitar na conta corrente "+numeroContaPoupanca+" -> R$ ");
        debitarContaPoupanca(ler.nextDouble());
        mostraSaldo("poupanca");
    }
}

private static void debitarContaPoupanca(double valorRetirar) {
    if (valorRetirar > saldoContaPoupanca) {
        System.out.println("SALDO INSUFICIENTE");
    }else{
        saldoContaPoupanca -= valorRetirar;    
    }
}

private static void creditar() {
    escolheConta();
    if (tipoConta.equals("Corrente")) {
        System.out.print("Qual valor a creditar na conta "+tipoConta+" "+numeroContaCorrente+" -> R$ ");
        saldoContaCorrente += ler.nextDouble();
        mostraSaldo("corrente");
    } else if (tipoConta.equals("Poupança")) {
        System.out.print("Qual valor a creditar na conta Poupança "+numeroContaPoupanca+" -> R$ ");
        saldoContaPoupanca += ler.nextDouble();
        mostraSaldo("poupanca");
    }
}

private static String escolheConta() {
    System.out.println("Qual conta:\n    1 - Corrente\n    2 - Poupança");
    System.out.print(" Opção -> ");
    opcao = ler.nextInt();
   switch (opcao) {
       case 1:
           tipoConta = "Corrente";
           break;
       case 2:
            tipoConta = "Poupança";
            break;
       default:
           System.out.println("Opção inválida");
           escolheConta();
           break;
   }
return tipoConta;
}
}