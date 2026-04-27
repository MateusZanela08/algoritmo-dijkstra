
import javax.swing.*;

public class Dijkstra {

    public static void main(String args[]) {

        int[][] D = {
            {0, 100, 15, 0, 0, 0},
            {100, 0, 40, 180, 200, 0},
            {15, 40, 0, 45, 90, 0},
            {0, 180, 45, 0, 0, 101},
            {0, 200, 90, 0, 0, 120},
            {0, 0, 0, 101, 120, 0}
        };

        int[] DA = new int[100];
        int[] Ant = new int[100];
        boolean[] ExpA = new boolean[100];

        int N = 6;
        int Origem, Destino, i, C, NovaDA, Min;

        Origem = Integer.parseInt(JOptionPane.showInputDialog("Digite a cidade de origem (0 a 5)"));
        Destino = Integer.parseInt(JOptionPane.showInputDialog("Digite a cidade de destino (0 a 5)"));

        // Inicialização
        for (i = 0; i < N; i++) {
            ExpA[i] = false;
            DA[i] = 10000;
            Ant[i] = -1;
        }

        C = Origem;
        DA[C] = 0;

        while ((C != Destino) && (C != -1)) {

            // Expansão
            for (i = 0; i < N; i++) {
                if ((D[C][i] != 0) && (!ExpA[i])) {
                    NovaDA = DA[C] + D[C][i];

                    if (NovaDA < DA[i]) {
                        DA[i] = NovaDA;
                        Ant[i] = C;
                    }
                }
            }

            ExpA[C] = true;

            // Escolher próximo nó
            Min = 10000;
            C = -1;

            for (i = 0; i < N; i++) {
                if ((!ExpA[i]) && (DA[i] < Min)) {
                    Min = DA[i];
                    C = i;
                }
            }
        }

        // Resultado
        if (C == Destino) {

            String saida = "Caminho mais curto de " + Origem
                    + " até " + Destino + "\n\n";

            int atual = Destino;
            while (atual != -1) {
                saida = atual + "\n" + saida;
                atual = Ant[atual];
            }

            saida += "\nDistância total: " + DA[Destino];

            JOptionPane.showMessageDialog(null, saida);

        } else {
            JOptionPane.showMessageDialog(null, "Não existe caminho entre as cidades");
        }
    }
}
