public class PilhaCartas {
    int tamanho = 0;
    Carta topo;

    public void push(Carta carta) {
        if(tamanho != 0) {
            carta.proximo = topo;
        }
        topo = carta;
        tamanho++;
    }

    public Carta pop() throws Exception{
        if(tamanho == 0) {
            throw new Exception("Pilha Vazia!");
        }
        Carta cartaPop = topo;
        topo = topo.proximo;
        tamanho--;
        return cartaPop;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }
}