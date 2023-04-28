import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String nomeDoTitular = "Estevam Rainer";
        String tipoDaConta = "Corrente";
        double saldo = 2500.500;
        String mensagemInicial;
        mensagemInicial = """
                ***********************************************
                Dados Iniciais do Cliente:
                
                Nome do Titual : %s
                Tipo de Conta : %s
                Saldo : %s
                ***********************************************
                """ .formatted(nomeDoTitular, tipoDaConta, saldo);
        System.out.println(mensagemInicial);
        String mensagemOperacao;
        mensagemOperacao = """
                Digite um dos seguintes numeros para acessar a operação desejada:
                
                1 - Consultar Saldo
                2 - Receber Valor
                3 - Transferencia de Valor
                4 - Dados do Cliente
                5 - Sair
                
                Digite a seguir o número da operação que deseja executar:
                """;
        boolean repetir = true;
        while (repetir){
            System.out.println(mensagemOperacao);
            int operacaoRequisitada = leitor.nextInt();
            switch (operacaoRequisitada) {
                case 1 -> System.out.println("O seu saldo atual é de " + saldo);
                case 2 -> {
                    System.out.println("Digite o valor a ser recebido!");
                    double valorRecebido = leitor.nextDouble();
                    saldo += valorRecebido;
                    System.out.println("Transação finalizada com Sucesso! Saldo atual agora é " + saldo);
                }
                case 3 -> {
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferido = leitor.nextDouble();
                    if (valorTransferido > saldo) {
                        System.out.println("ERRO! Valor transferido excede o valor depositado!");
                    } else {
                        saldo -= valorTransferido;
                        System.out.println("Transferência realizada com sucesso! Sua conta agora possúi um valor de " + saldo);
                    }
                }
                case 4 -> {
                    mensagemInicial = """
                ***********************************************
                Dados Iniciais do Cliente:
                
                Nome do Titual : %s
                Tipo de Conta : %s
                Saldo : %s
                ***********************************************
                """ .formatted(nomeDoTitular, tipoDaConta, saldo);
                    System.out.println(mensagemInicial);
                }
                case 5 -> {
                    System.out.println("Muito Obrigado por utilizar o nosso serviço! Tenha um ótiomo dia!");
                    repetir = false;
                }
                case default -> {
                    System.out.println("Digite uma operação válida por favor!");
                }
            }
        }
    }
}