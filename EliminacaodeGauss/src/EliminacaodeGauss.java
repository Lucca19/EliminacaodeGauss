import java.util.Scanner;

public class EliminacaodeGauss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de equações: ");
        int n = scanner.nextInt();
        
        double[][] matriz = new double[n][n + 1];
        
        System.out.println("Digite os coeficientes e constantes do sistema:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.printf("Digite o valor para a(%d)(%d): ", i, j);
                matriz[i][j] = scanner.nextDouble();
            }
        }
        
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double fator = matriz[i][k] / matriz[k][k];
                for (int j = k; j < n + 1; j++) {
                    matriz[i][j] -= fator * matriz[k][j];
                }
            }
        }
        
        double[] solucao = new double[n];
        
        solucao[n - 1] = matriz[n - 1][n] / matriz[n - 1][n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            double soma = 0.0;
            for (int j = i + 1; j < n; j++) {
                soma += matriz[i][j] * solucao[j];
            }
            solucao[i] = (matriz[i][n] - soma) / matriz[i][i];
        }
        
        System.out.println("Solução:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.2f\n", i, solucao[i]);
        }
        
        scanner.close();
    }
}