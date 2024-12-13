import java.util.Random;

public class Carta {
    public int numero;
    public Carta proximo;

    public Carta() {
        this.numero = 1 + new Random().nextInt(10);
        this.proximo = null;
    } 
}
