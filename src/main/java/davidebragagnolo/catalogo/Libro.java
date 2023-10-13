package davidebragagnolo.catalogo;

public class Libro extends Catalogo {
    private String autore;
    private String genere;

    public Libro(String isbn, String titolo, int anno, int pagine, String autore, String genere) {
        super(Long.parseLong(isbn), titolo, anno, pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Nome libro: " + " " + titolo + ", Autore: " + autore + " " + ", Pubblicazione: " + anno + " " + ", Genere: "
                + " " + genere;
    }
}
