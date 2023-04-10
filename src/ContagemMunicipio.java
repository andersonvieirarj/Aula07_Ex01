/* A prefeitura de uma cidade deseja fazer uma pesquisa entre seus habitantes. Faça um progama javba 17 para coletar dados sobre o salário e número de filhos de cada habitante e após as leituras, escrever:
a) Média de salário da população
b) Média do número de filhos
c) Maior salário dos habitantes
d) Percentual de pessoas com salário menor que R$ 150,00
Obs.: O final da leituras dos dados se dará com a entrada de um “salário negativo"

 */
import java.util.Scanner;
public class ContagemMunicipio {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                double salario, somaSalario = 0, maiorSalario = 0;
                int numFilhos, totalHabitantes = 0, totalSalarioMenor150 = 0, totalFilhos = 0;

                System.out.println("Digite os dados dos habitantes:");
                while (true) {
                    System.out.print("Salário (digite um valor negativo para encerrar): ");
                    salario = scanner.nextDouble();
                    if (salario < 0) {
                        break;
                    }
                    System.out.print("Número de filhos: ");
                    numFilhos = scanner.nextInt();

                    totalHabitantes++;
                    somaSalario += salario;
                    totalFilhos += numFilhos;

                    if (salario > maiorSalario) {
                        maiorSalario = salario;
                    }

                    if (salario < 150.0) {
                        totalSalarioMenor150++;
                    }
                }

                double mediaSalario = somaSalario / totalHabitantes;
                double mediaFilhos = (double) totalFilhos / totalHabitantes;
                double percentualSalarioMenor150 = (double) totalSalarioMenor150 / totalHabitantes * 100;

                System.out.printf("Média de salário da população: R$ %.2f\n", mediaSalario);
                System.out.printf("Média do número de filhos: %.1f\n", mediaFilhos);
                System.out.printf("Maior salário dos habitantes: R$ %.2f\n", maiorSalario);
                System.out.printf("Percentual de pessoas com salário menor que R$ 150,00: %.1f%%\n", percentualSalarioMenor150);
    }
}
/*O programa utiliza um laço while para ler os dados de salário e número de filhos de cada habitante,
encerrando a leitura quando o usuário digitar um valor negativo para o salário.

Dentro do laço, as variáveis totalHabitantes, somaSalario, maiorSalario, totalFilhos e totalSalarioMenor150
são atualizadas a cada iteração, armazenando o número total de habitantes, a soma dos salários, o maior salário,
o total de filhos e o número de habitantes com salário inferior a R$ 150,00.

Após o fim da leitura dos dados, o programa calcula as médias de salário e número de filhos, o percentual de
habitantes com salário inferior a R$ 150,00 e exibe as informações solicitadas na tela utilizando o
método printf para formatar os valores exibidos.

 */