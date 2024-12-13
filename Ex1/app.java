import java.util.Scanner;
public class app {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Jogador jogador1 = new Jogador("Jogador 1");
        Jogador jogador2 = new Jogador("Jogador 2");
        boolean opcao;
        
        System.out.println("\n\nVez do " + jogador1.getNome() + ":");
        System.out.println(jogador1.getNome() + " pegou a primeira carta ("+jogador1.pedirCarta()+"). Pontuação: " + jogador1.getPontuacao());
        System.out.println(jogador1.getNome() + " pegou a segunda carta ("+jogador1.pedirCarta()+"). Pontuação: " + jogador1.getPontuacao());
        System.out.print(jogador1.getNome() + ", deseja pegar outra carta? (s - sim; n - não) ");
        do{
            opcao = verificaResposta(digitaString(teclado));
            if(opcao) {
                System.out.println(jogador1.getNome() + " pegou outra carta ("+jogador1.pedirCarta()+"). Pontuação: " + jogador1.getPontuacao());
                if(jogador1.verificaPontuacao()){
                    System.out.print(jogador1.getNome() + ", deseja pegar outra carta? (s - sim; n - não)");
                }
                else {
                    jogador1.diminuiPontuacao();
                    System.out.println("Pontuação excedeu o objetivo de 21. Última carta descartada e aplicada penalidade de -5 pontos.");
                    System.out.println(jogador1.getNome() + " não pode mais jogar. Nova pontuação: " + jogador1.getPontuacao());
                    break;
                }
            }
        }while(opcao);
        System.out.println("\n\n");

        System.out.println("Vez do " + jogador2.getNome() + ":");
        System.out.println(jogador2.getNome() + " pegou a primeira carta ("+jogador2.pedirCarta()+"). Pontuação: " + jogador2.getPontuacao());
        System.out.println(jogador2.getNome() + " pegou a segunda carta ("+jogador2.pedirCarta()+"). Pontuação: " + jogador2.getPontuacao());
        System.out.print(jogador2.getNome() + ", deseja pegar outra carta? (s - sim; n - não) ");
        do{
            opcao = verificaResposta(digitaString(teclado));
            if(opcao) {
                System.out.println(jogador2.getNome() + " pegou outra carta ("+jogador2.pedirCarta()+"). Pontuação: " + jogador2.getPontuacao());
                if(jogador2.verificaPontuacao()){
                    System.out.print(jogador2.getNome() + ", deseja pegar outra carta? (s - sim; n - não) ");
                }
                else {
                    jogador2.diminuiPontuacao();
                    System.out.println("Pontuação excedeu o objetivo de 21. Última carta descartada e aplicada penalidade de -5 pontos.");
                    System.out.println(jogador2.getNome() + " não pode mais jogar. Nova pontuação: " + jogador2.getPontuacao());
                    break;
                }
            }
        }while(opcao);
        System.out.println("\n\n");

        if(jogador1.getPontuacao() > jogador2.getPontuacao()) {
            System.out.println(jogador1.getNome() + " venceu com " + jogador1.getPontuacao() + "!");
            System.out.print("Pilha do vencedor:");
            imprimePilha(jogador1);
        }
        else if(jogador1.getPontuacao() < jogador2.getPontuacao()){
            System.out.println(jogador2.getNome() + " venceu com " + jogador2.getPontuacao() + "!");
            System.out.print("Pilha do vencedor:");
            imprimePilha(jogador2);
        }
        else {
            System.out.println("Empate!");
            imprimePilha(jogador1);
        }
        
    }

    public static String digitaString(Scanner teclado) {
        String texto;
        while (true) {
            try {
                texto = teclado.nextLine();
                if (texto.matches("[sn]")) {
                    break;
                }
                System.err.print("Texto Inválido. Tente novamente: ");
            } catch (Exception ex) {
                System.err.print("Erro na leitura. Tente novamente: ");
            }
        }
        return texto;
    }

    public static boolean verificaResposta(String texto) {
        return texto.equals("s");
    }

    public static void imprimePilha(Jogador jogador) {
        PilhaCartas pilha = jogador.getPilha();
        while (pilha.tamanho != 0) {
            try{
                System.out.print(pilha.pop().numero + " ");
            }catch(Exception ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }
    }
}
