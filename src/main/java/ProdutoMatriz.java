import java.util.Arrays;

public class ProdutoMatriz {
    private int[][] matriz;
//    int[][] matrizTeste = {{9,1,2,4,5},{2,4,3,5,1},{3,2,6,4,8},{4,3,2,1,7},{7,3,2,6,1}};

    public void criaMatriz(int tamanho){
        matriz = new int[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++){
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = (int)(Math.random() * (9 -1 + 1) + 1);
            }
        }
        imprimeMatriz();
    }

    public void imprimeMatriz() {
        int tamanhoMatriz = matriz.length;
        System.out.println("Matriz["
                + tamanhoMatriz + "]["+ tamanhoMatriz + "]");

        for (int i = 0; i < tamanhoMatriz; i++){
            for (int j = 0; j < tamanhoMatriz; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public void maiorProdutoMatriz(){

        int[] produtoMatriz = new int[4];

        produtoMatriz[0] = produtoHorizontal();
        produtoMatriz[1] = produtoVertical();
        produtoMatriz[2] = produtoDiagonal();
        produtoMatriz[3] = produtoDiagonalInvertida();

        System.out.println("Maior Produto da Matriz: "
                + Arrays.stream(produtoMatriz).max().getAsInt());
    }

    private int produtoHorizontal(){
        int maior = 0;
        for (int i = 0; i < matriz.length; i++){
            int soma = 1;
            for (int j = 0; j < matriz.length; j++) {
                soma *= matriz[i][j];
            }
            if (soma > maior){
                maior = soma;
            }
        }
        return maior;
    }

    private int produtoVertical(){
        int maior = 0;
        for (int i = 0; i < matriz.length; i++){
            int soma = 1;
            for (int j = 0; j < matriz.length; j++) {
                soma *= matriz[j][i];
            }
            if (soma > maior){
                maior = soma;
            }
        }
        return maior;
    }

    private int produtoDiagonal(){
        int diagonal = matriz.length + matriz.length - 1;
        int maior = 0;
        for (int z = 0; z < diagonal; z++) {
            int soma = 1;
            for (int i = 0; i < matriz.length; i++) {

                for (int j = 0; j < matriz.length; j++) {
                    if (i + j == z) {

                        // Incrementa a soma:
                        soma *= matriz[i][j];
                    }
                }
            }
            if (soma > maior) {
                maior = soma;
            }
        }
        return maior;
    }

    private int produtoDiagonalInvertida(){
        int diagonal = matriz.length + matriz.length - 1;
        int maior = 0;
        //primeira metade
        for (int z = 0; z < diagonal; z++) {
            int soma = 1;
            for (int i = 0; i < matriz.length; i++) {

                for (int j = 0; j < matriz.length; j++) {
                    if (i - j == z) {

                        // Incrementa a soma:
                        soma *= matriz[i][j];
                    }
                }
            }
            if (soma > maior) {
                maior = soma;
            }
        }

        //Segunda metade
        for (int z = 0; z < diagonal; z++) {
            int soma = 1;
            for (int i = 0; i < matriz.length; i++) {

                for (int j = 0; j < matriz.length; j++) {
                    if (-i + j == z) {

                        // Incrementa a soma:
                        soma *= matriz[i][j];
                    }
                }
            }

            if (soma > maior) {
                maior = soma;
            }
        }

        return maior;
    }

}
