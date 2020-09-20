package TPintegrador;

import Objetos.ArrayListCantidadNoIndeterminada;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import seresVivos.Persona;
//import org.springframwork.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

//@Service
public class AccesoMongoDB {
    private MongoDatabase baseDeDatos;
    private MongoCollection coleccion;
    private String host;
    private int puerto;

    public AccesoMongoDB(){
        this.host="localhost";
        this.puerto=27017;
        this.conectarABaseDeDatos("personas");
        this.conectarAColeccion("socios");
    }

    public void conectarABaseDeDatos(String nombreBaseDeDatos){
        MongoClient mongo= new MongoClient(host,puerto);
        this.baseDeDatos= mongo.getDatabase(nombreBaseDeDatos);
    }

    public void conectarAColeccion(String nombreDeColeccion) {
        if(existeLaColeccion(nombreDeColeccion)){
            this.coleccion=baseDeDatos.getCollection(nombreDeColeccion);
        } else {
            baseDeDatos.createCollection(nombreDeColeccion);
            this.coleccion=baseDeDatos.getCollection(nombreDeColeccion);
        }
    }

    public long obtenerCantidadDeDocumentos(){
        long cantidadDeRegistros= coleccion.countDocuments();
        return cantidadDeRegistros;
    }




    public void insertarUsuarios(List<Persona> personas){
        List<Document> documenotsAInsertar= new ArrayList<>();

        for (Persona persona:personas) {

            Document nuevoDocumento= new Document();
            nuevoDocumento.append("nombre",persona.getNombre());
            nuevoDocumento.append("edad",persona.getEdad());
            documenotsAInsertar.add(nuevoDocumento);
        }

        coleccion.insertMany(documenotsAInsertar);
    }

    public boolean existeLaColeccion(String nombreDeColeccion) {
        MongoIterable<String> nombreDeColecciones= baseDeDatos.listCollectionNames();
        boolean existe=false;

        for (String nombre:nombreDeColecciones) {
            if(nombre.equals(nombreDeColeccion)){
                existe=true;
            }
        }
        return existe;
    }
}
