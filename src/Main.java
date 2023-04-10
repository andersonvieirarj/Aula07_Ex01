import java.math.BigDecimal;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          BigDecimal saldo = BigDecimal.ZERO;

          boolean clienteEspecial = false;
          int opcao;

            do {
               System.out.println("\nMenu:");
               System.out.println("1 - Entrar com o Tipo de Cliente");
               System.out.println("2 - Depositar");
               System.out.println("3 - Sacar");
               System.out.println("4 - Sair");
               System.out.print("Escolha uma opção: ");
               opcao = scanner.nextInt();
               switch (opcao) {
                  case 1:
                       clienteEspecial = verificarTipoCliente(scanner);
                       break;
                  case 2:
                       saldo = fazerDeposito(scanner, saldo, clienteEspecial);
                       break;
                  case 3:
                       saldo = fazerSaque(scanner, saldo);
                       break;
                  case 4:
                       System.out.println("Saindo...");
                       break;
                  default:
                       System.out.println("Opção inválida.");
                    }
                } while (opcao != 4);
                scanner.close();
            }
            private static boolean verificarTipoCliente(Scanner scanner) {
                System.out.print("Você é um cliente especial? (S/N) ");
                String resposta = scanner.next();
                return resposta.equalsIgnoreCase("S");
            }
            private static BigDecimal fazerDeposito(Scanner scanner, BigDecimal saldo, boolean clienteEspecial) {
                System.out.print("Digite o valor a depositar: ");
                BigDecimal valor = scanner.nextBigDecimal();
                if (clienteEspecial) {
                    valor = calcularAcrescimo(valor);
                    System.out.println("Cliente especial. Valor depositado com acréscimo: " + valor);
                } else {
                    System.out.println("Cliente normal. Valor depositado: " + valor);
                }
                saldo = saldo.add(valor);
                System.out.println("Saldo atual: " + saldo);

                return saldo;
            }
            private static BigDecimal fazerSaque(Scanner scanner, BigDecimal saldo) {
                System.out.print("Digite o valor a sacar: ");
                BigDecimal valor = scanner.nextBigDecimal();
                if (valor.compareTo(saldo) < 0) {
                    System.out.println("Saldo insuficiente.");
                    return saldo;
                }
                saldo = saldo.subtract(valor);
                System.out.println("Valor sacado: " + valor);
                System.out.println("Saldo atual: " + saldo);
                return saldo;
            }
            private static BigDecimal calcularAcrescimo(BigDecimal valorDepositado) {
                BigDecimal percentualAcrescimo = new BigDecimal("1.025"); // 2.5% a mais
                return valorDepositado.multiply(percentualAcrescimo);
            }
        }

