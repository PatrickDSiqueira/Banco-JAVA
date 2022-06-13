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
            menu();
            break;
    }
}

private static void debitar() {
    escolheConta();
    if (tipoConta.equals("Corrente")) {
        System.out.print("Qual valor a debitar na conta corrente "+numeroContaCorrente+" -> R$ ");
        saldoContaCorrente -= ler.nextDouble();
        System.out.printf("Saldo atual na Conta Corrente "+numeroContaCorrente+" -> R$ %.2f", saldoContaCorrente);
    } else if (tipoConta.equals("Poupança")) {
        System.out.print("Qual valor a debitar na conta corrente "+numeroContaPoupanca+" -> R$ ");
        debitarContaPoupanca(ler.nextDouble());
        System.out.printf("Saldo atual na Conta Corrente "+numeroContaPoupanca+" -> R$ %.2f", saldoContaPoupanca);
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
        System.out.printf("Saldo atual na Conta Corrente %d -> R$ %.2f\n", numeroContaCorrente, saldoContaCorrente);
    } else if (tipoConta.equals("Poupança")) {
        System.out.print("Qual valor a creditar na conta Poupança "+numeroContaPoupanca+" -> R$ ");
        saldoContaPoupanca += ler.nextDouble();
        System.out.printf("Saldo atual na Conta Poupança %d -> R$ %.2f\n", numeroContaPoupanca, saldoContaPoupanca);
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