public class PilhaTermos {
    int tamanho = 0;
    Termo topo;

    public void push(Termo termo) {
        if(tamanho != 0) {
            termo.proximo = topo;
        }
        topo = termo;
        tamanho++;
    }

    public Termo pop() throws Exception {
        if(tamanho == 0) {
            throw new Exception("Pilha Vazia!");
        }
        Termo termoPop = topo;
        topo = topo.proximo;
        tamanho--;
        return termoPop;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }

}
