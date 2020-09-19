package TPintegrador;

import java.util.HashMap;

public class Prueba {

    public HashMap<Integer,String> ConseguirImagenesTendencias(List<Libro> ListaLibros) { /*Suponemos que esta listaDeLibros ya tiene los libros que exactamente quiero ver la imagen*/
        HashMap<Integer,String> ListaDeImagenes= new HashMap<Integer,String>;
        for(Libro libro:ListaLibros) {
            ListaDeImagenes.put(libro.getId(),libro.getURL());
        }
    }

    public 
}
