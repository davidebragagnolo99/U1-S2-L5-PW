package davidebragagnolo.catalogo;

public class Rivista extends Catalogo {
    private Periodicita periodicita;

    public Rivista(long isbn, String titolo, int anno, int pagine, Periodicita periodicita) {
        super(isbn, titolo, anno, pagine);
        this.periodicita = periodicita;
    }

    public Rivista(String isbn, String titolo, int anno, int pagine, String genere) {
        super(Long.parseLong(isbn), titolo, anno, pagine);
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    public String toString() {
        return "Nome rivista: " + titolo + " " + ", Anno: " + anno;
    }
}
