package davidebragagnolo.catalogo;

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


}
