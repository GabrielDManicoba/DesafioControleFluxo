import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = getIntInput(scanner);

        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = getIntInput(scanner);

        try {
            validarParametros(parametroUm, parametroDois);
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.err.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Entrada inválida. Digite números inteiros.");
        } finally {
            scanner.close();
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.err.println("Entrada inválida. Digite um número inteiro.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void validarParametros(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }
    }

    private static void contar(int parametroUm, int parametroDois) {
        for (int i = parametroUm + 1; i <= parametroDois; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}

