import java.util.Scanner;

public class Calculadora {

    public static double somar(double a, double b) {
        return a + b; 
    }

    public static double subtrair(double a, double b) { 
        return a - b; 
    }

    public static double multiplicar(double a, double b) {
        return a * b; 
    }

    public static double dividir(double a, double b) {
        if (b == 0) { 
            throw new ArithmeticException("Divisão por zero não é permitida."); 
        }
        return a / b;
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Somar (+)");
        System.out.println("2. Subtrair (-)"); 
        System.out.println("3. Multiplicar (*)"); 
        System.out.println("4. Dividir (/)"); 
        System.out.println("5. Sair"); 
    }

    private static double lerNumero(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, digite um número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        boolean executando = true; 

        System.out.println("================================"); 
        System.out.println("   Calculadora Simples em Java   ");
        System.out.println("================================");

        while (executando) {
            exibirMenu();
            System.out.println("Escolha uma opção: ");

            int opcao;
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
            } else {
                System.out.println("Entrada inválida! Digite um número de 1 a 5."); 
                scanner.next(); 
                continue; 
            }

            if (opcao == 5) {
                executando = false;
                System.out.println("\nObrigado por usar a calculadora! Encerrando..."); 
                break; 
            }

            if (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida! Escolha entre 1 e 5"); 
                continue;
            }

            System.out.println("Digite o primeiro número: "); 
            double num1 = lerNumero(scanner);

            System.out.println("Digite o segundo número: "); 
            double num2 = lerNumero(scanner); 

            switch (opcao) { 
                case 1: 
                    System.out.println("Resultado da Soma: " + somar(num1, num2));
                    break; 
                case 2:
                    System.out.println("Resultado da Subtração: " + subtrair(num1, num2)); 
                    break;
                case 3: 
                    System.out.println("Resultado da Multiplicação: " + multiplicar(num1, num2));
                    break; 
                case 4: 
                    try { 
                        System.out.println("Resultado da Divisão: " + dividir(num1, num2));
                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break; 
            }
        } // Fim do while

        scanner.close();
    } // Fim do main
} // Fim da classe Calculadora