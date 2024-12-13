import java.util.Random;

public class app {
    public static void main(String[] args) {
        PilhaTermos pilha = new PilhaTermos();
        int n = (1 + new Random().nextInt(10));
        for(int i = 0; i < n; i++) {
            pilha.push(new Termo(i));
        }

        while(pilha.tamanho != 0) {
            try {
                System.out.print(pilha.pop().numero + " ");
            } catch (Exception ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }
    }
}