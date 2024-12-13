public class Termo {
    public int numero;
    public Termo proximo;

    public Termo(int n) {
        try {
            this.numero = Iccanobif(n);
        } catch (Exception ex) {
            System.err.println("Erro: " + ex.getMessage());
        }
        this.proximo = null;
    }

    public final int Iccanobif(int n) throws Exception {
        if(n < 0) {
            throw new Exception("Somente posições positivas");
        }
        else if((n==0) || (n==1)) {
            return n;
        }
        else{
            return Iccanobif(n-1) + Iccanobif(n-2);
        }
    }
}