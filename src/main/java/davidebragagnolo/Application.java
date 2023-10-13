package davidebragagnolo;

import davidebragagnolo.catalogo.Archivio;
import davidebragagnolo.catalogo.Catalogo;
import davidebragagnolo.catalogo.Libro;
import davidebragagnolo.catalogo.Rivista;
import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        // Creo gli elementi da aggiungere all'archivio
        Libro libro1 = new Libro("123456789", "Il Signore degli Anelli - La Compagnia Dell'Anello", 1954, 1178,
                "J.R.R. Tolkien", "Fantasy");
        Libro libro2 = new Libro("987654321", "Harry Potter - E Lo Sbarco In Normandia", 1983, 1500, "J.K.Rowling",
                "Fantasy");
        Libro libro3 = new Libro("123456890", "Il Signore degli Anelli - Le Due Torri", 1990, 1378, "J.R.R. Tolkien",
                "Fantasy");
        Libro libro4 = new Libro("123321123", "La Storia e La Morte Di Pop Smoke - King Of New York", 2022, 200,
                "Crips", "Biografia");

        Rivista rivista1 = new Rivista("479042", "Focus", 2022, 101, "Scienza");
        Rivista rivista2 = new Rivista("246890", "Man's Health", 2023, 100, "Gossip");

        // Aggiungo all'archivio degli elementi
        archivio.aggiungiElemento(libro1);
        archivio.aggiungiElemento(libro2);
        archivio.aggiungiElemento(libro3);
        archivio.aggiungiElemento(libro4);
        archivio.aggiungiElemento(rivista1);
        archivio.aggiungiElemento(rivista2);

        // Rimuovo dall'archivio
        System.out.println("");
        Catalogo elementoRimosso = archivio.rimuoviElemento("987654321");
        System.out.println("elemento con id: " + "'" + elementoRimosso.getCodiceIsbn() + "'" + " e titolo: " + "'"
                + elementoRimosso.getTitolo() + "'" + " rimosso con successo!");

        // Cerco elementi per codice ISBN
        Catalogo elementoTrovato = archivio.ricercaPerIsbn("123321123");
        System.out.println("Elemento trovato: " + "'" + elementoTrovato.getTitolo() + "' ," + " Id: " + "'"
                + elementoTrovato.getCodiceIsbn() + "' ," + " Anno: " + "'" + elementoTrovato.getAnnoPubblicazione() + "'");

        // Cerco i libri di un determinato autore
        List<Libro> libriTrovati = archivio.ricercaPerAutore("J.R.R. Tolkien");
        System.out.println("");
        System.out.println("Libri trovati: ");
        for (Libro libro : libriTrovati) {
            System.out.println("- '" + libro.getTitolo() + "' ," + " Id: " + "'" + libro.getCodiceIsbn() + "' ," + " Anno: " + "'"
                    + libro.getAnnoPubblicazione() + "'");
        }

        // Salvo l'archivio sul disco
        archivio.salvaSuDisco("archivio.dat");

        // Carico l'archivio sul disco
        Archivio archivioCaricato = new Archivio();
        archivioCaricato.caricaDaDisco("archivio.dat");

        // Mostro l'intero archivio caricato
        System.out.println("");
        System.out.println("Elementi presenti in archivio: ");
        for (Catalogo elemento : archivioCaricato.getCatalogoList()) {
            System.out.println("- Titolo: " + "'" + elemento.getTitolo() + "' ," + " Id: " + "'" + elemento.getCodiceIsbn() + "'"
                    + " , Anno: " + "'" + elemento.getAnnoPubblicazione() + "'");
        }
    }
}

