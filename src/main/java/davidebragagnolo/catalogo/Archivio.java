package davidebragagnolo.catalogo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Archivio {
    private List<Catalogo> catalogoList;

    public Archivio() {
        this.catalogoList = new ArrayList<>();
    }

    public void aggiungiElemento(Catalogo elemento) {
        catalogoList.add(elemento);
    }

    public Catalogo rimuoviElemento(String codiceIsbn) {
        Catalogo elementoRimosso = ricercaPerIsbn(codiceIsbn);
        catalogoList.removeIf(e -> e.codiceIsbn.equals(codiceIsbn));
        return elementoRimosso;
    }

    public Catalogo ricercaPerIsbn(String codiceIsbn) {
        return catalogoList.stream().filter(e -> e.codiceIsbn.equals(codiceIsbn)).findFirst().orElse(null);
    }

    public List<Catalogo> getCatalogoList() {
        return catalogoList;
    }

    public List<Catalogo> ricercaPerAnnoPubblicazione(int annoPubblicazione) {
        return catalogoList.stream().filter(e -> e.annoPubblicazione == annoPubblicazione).toList();
    }

    public List<Libro> ricercaPerAutore(String autore) {
        return catalogoList.stream().filter(e -> e instanceof Libro).map(e -> (Libro) e)
                .filter(l -> autore.equals(l.getAutore())).toList();
    }

    public void salvaSuDisco(String nomeFile) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            out.writeObject(catalogoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public void caricaDaDisco(String nomeFile) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFile))) {
            catalogoList = (List<Catalogo>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
