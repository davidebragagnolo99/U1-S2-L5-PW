package davidebragagnolo;

import davidebragagnolo.catalogo.Archivio;
import davidebragagnolo.catalogo.Catalogo;
import davidebragagnolo.catalogo.Libro;
import davidebragagnolo.catalogo.Rivista;

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
        Catalogo elementoRimosso = archivio.rimuoviElemento
    }
}

