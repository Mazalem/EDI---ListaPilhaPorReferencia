public class Jogador {
    private String nome;
    private int pontuacao;
    private PilhaCartas pilha;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.pilha = new PilhaCartas();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    public PilhaCartas getPilha() {
        return pilha;
    }
    public void setPilha(PilhaCartas pilha) {
        this.pilha = pilha;
    }
    
    public void aumentaPontuacao(int valor) {
        this.pontuacao += valor;
    }

    public void diminuiPontuacao() {
        try{
            this.pontuacao -= (this.pilha.pop().numero+5);
        }catch(Exception ex) {
            System.err.println("Erro:" + ex.getMessage());
        }
    }

    public int pedirCarta() {
        Carta carta = new Carta();
        this.pilha.push(carta);
        aumentaPontuacao(carta.numero);
        return carta.numero;
    }

    public boolean verificaPontuacao() {
        return !(this.pontuacao > 21);
    }
}
