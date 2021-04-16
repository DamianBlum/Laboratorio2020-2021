package TPintegrador;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import seresVivos.Persona;
//import org.springframwork.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

//@Service
public class AccesoMongoDB {
    private MongoDatabase baseDeDatos;
    private MongoCollection<Document> coleccion;
    private String host;
    private int puerto;

    public AccesoMongoDB(){
        this.host="localhost";
        this.puerto=27017;
        this.conectarABaseDeDatos("personas");
        this.conectarAColeccion("socios");
    }

    public void conectarABaseDeDatos(String nombreBaseDeDatos){
        try {
            MongoClient mongo= new MongoClient(host,puerto);
            this.baseDeDatos= mongo.getDatabase(nombreBaseDeDatos);
        }
        catch (Exception e){
            System.out.println(e);
        }

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
        System.out.println("Logrado con exito!");
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
