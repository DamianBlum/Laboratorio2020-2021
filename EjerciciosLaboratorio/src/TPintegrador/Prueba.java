package TPintegrador;

import java.util.HashMap;

public class Prueba {

    public HashMap<Integer,String> ConseguirImagenesTendencias(List<Libro> ListaLibros) { /*Suponemos que esta listaDeLibros ya tiene los libros que exactamente quiero ver la imagen en los primeros 20 */
        HashMap<Integer,String> ListaDeImagenes= new HashMap<Integer,String>;
        for (int i = 0; i<20 ; i++) {
            ListaDeImagenes.put(ListaLibros.get(i).getId(),ListaLibros.get(i).getURL());
        }

    }

    public HashMap<Integer,String> ConseguirImagenes(List<Libro> ListaLibros, String nombreDeCategoria) { /*Suponemos que esta listaDeLibros ya tiene los libros que exactamente quiero ver la imagen*/
        HashMap<Integer,String> ListaDeImagenes= new HashMap<Integer,String>;
        for(Libro libro:ListaLibros) {
            if (libro.getCategoria()==nombreDeCategoria) {
                ListaDeImagenes.put(libro.getId(),libro.getURL());
            }
        }
    }


}
