package app.web;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class ManejadorDeArchivos {

    private String ubicacionArchivo;
    private String nombreDeArchivoCsv;
    private String nombreDeArchivoJson;
    private char separador;

    public ManejadorDeArchivos() {
        this.ubicacionArchivo = "src/main/resources/files/";
        this.nombreDeArchivoCsv = "recaudacion-impositiva.csv";
        this.nombreDeArchivoJson = "municipios.json";
        this.separador = ';';
    }

    public CSVParser formatearSeparador(){
        CSVParserBuilder puntoYcomaBuilder = new CSVParserBuilder();
        puntoYcomaBuilder = puntoYcomaBuilder.withSeparator(separador);
        CSVParser parser = puntoYcomaBuilder.build();
        return parser;
    }

    public FileReader obtenerArchivoCSV(){
        FileReader reader = null;
        try {
            reader = new FileReader(ubicacionArchivo + nombreDeArchivoCsv);
        } catch (FileNotFoundException e) {
            String mensaje = "Archivo no encontrado, verifique el nombre y/o la ubicaión del mismo";
            System.out.println(mensaje);
            e.printStackTrace();
        }
        return reader;
    }
    public FileReader obtenerArchivoJSON(){
        FileReader reader = null;
        try {
            reader = new FileReader(ubicacionArchivo + nombreDeArchivoJson);
        } catch (FileNotFoundException e) {
            String mensaje = "Archivo no encontrado, verifique el nombre y/o la ubicaión del mismo";
            System.out.println(mensaje);
            e.printStackTrace();
        }
        return reader;
    }

    public CSVReader obtenerArchivoFormateado(){
        FileReader fileReader = this.obtenerArchivoCSV();
        CSVReaderBuilder readerBuilder = new CSVReaderBuilder(fileReader);
        CSVParser separadorFormateado = this.formatearSeparador();
        readerBuilder = readerBuilder.withCSVParser(separadorFormateado);
        CSVReader reader = readerBuilder.build();
        return reader;
    }


    public JSONObject transformarArchivoAJson(){
        JSONParser parser = new JSONParser();
        FileReader fileReader = this.obtenerArchivoJSON();

        try
        {
            Object object = parser.parse(fileReader);
            JSONObject jsonObject = (JSONObject)object;
            return jsonObject;
        }
        catch(FileNotFoundException fe)
        {
            System.out.println(fe);

        }
        catch(Exception e)
        {
            System.out.println(e);

        }
        return null;
    }


    public Iterator<String[]> obtenerIterador(){
        CSVReader reader = this.obtenerArchivoFormateado();
        Iterator<String[]> iterador = reader.iterator();
        return iterador;
    }

    public void imprimirDatosConEspacios() throws FileNotFoundException {

        CSVReader reader = this.obtenerArchivoFormateado();
        Iterator<String[]> iterador = reader.iterator();

        while (iterador.hasNext()){
            String[] fila = iterador.next();
            String filaInfo = fila[0] + " " + fila[1] + " " + fila[2] + " " + fila[3] + " " + fila[5];
            System.out.println(filaInfo);

        }

    }


}
