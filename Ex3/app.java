import java.util.InputMismatchException;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tam = 0;
        String entrada = "";
        PilhaVagoes pilhaEntrada = new PilhaVagoes();
        PilhaVagoes pilhaEstacao = new PilhaVagoes();
        PilhaVagoes pilhaSaida = new PilhaVagoes();
        PilhaVagoes pilhaOrdenada = new PilhaVagoes();

        tam = digitaInteiro(teclado);
        entrada = digitaString(teclado);

        for (int i = tam - 1; i >= 0; i--) {
            pilhaEntrada.push(new Vagao(entrada.charAt(i)));
        }

        entrada = digitaString(teclado);

        for (int i = tam - 1; i >= 0; i--) {
            pilhaOrdenada.push(new Vagao(entrada.charAt(i)));
        }

        while (true) {
            if (pilhaEstacao.isVazia() && !pilhaEntrada.isVazia()) {
                try {
                    pilhaEstacao.push(pilhaEntrada.pop());
                    System.out.print("I ");
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }

            if (pilhaOrdenada.topo.id == pilhaEstacao.topo.id) {
                try {
                    while (!pilhaEstacao.isVazia() && pilhaOrdenada.topo.id == pilhaEstacao.topo.id) {
                        pilhaSaida.push(pilhaEstacao.pop());
                        pilhaOrdenada.pop();
                        System.out.print("R ");
                    }
                    if (pilhaOrdenada.tamanho == 0) {
                        System.out.println("\n");
                        break;
                    } else if (pilhaEntrada.isVazia()) {
                        System.out.print(" Impossível\n");
                        break;
                    }
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            } else if (pilhaEntrada.isVazia()) {
                System.out.print(" Impossível\n");
                break;
            } else {
                try {
                    pilhaEstacao.push(pilhaEntrada.pop());
                    System.out.print("I ");
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public static int digitaInteiro(Scanner teclado) {
        int numero;
        while (true) {
            try {
                numero = teclado.nextInt();
                if (numero > 0) {
                    teclado.nextLine();
                    break;
                }
                System.err.print("O valor deve ser positivo. Tente novamente: ");
            } catch (InputMismatchException ex) {
                System.err.print("Somente inteiros são permitidos. Tente novamente: ");
                teclado.next();
            }
        }
        return numero;
    }

    public static String digitaString(Scanner teclado) {
        String texto;
        while (true) {
            try {
                texto = teclado.next();
                if (texto.matches("[\\p{L}\\s\\-]+")) {
                    break;
                }
                System.err.print("Texto Inválido. Tente novamente: ");
            } catch (Exception ex) {
                System.err.print("Erro na leitura. Tente novamente: ");
            }
        }
        return texto;
    }
}
