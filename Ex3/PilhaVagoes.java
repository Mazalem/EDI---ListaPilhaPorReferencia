public class PilhaVagoes {
    int tamanho = 0;
    Vagao topo;

    public void push(Vagao vagao) {
        if(tamanho != 0) {
            vagao.proximo = topo;
        }
        topo = vagao;
        tamanho++;
    }

    public Vagao pop() throws Exception{
        if(tamanho == 0) {
            throw new Exception("Pilha Vazia!");
        }
        Vagao vagaoPop = topo;
        topo = topo.proximo;
        tamanho--;
        return vagaoPop;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isVazia() {
        return tamanho == 0;
    }
}