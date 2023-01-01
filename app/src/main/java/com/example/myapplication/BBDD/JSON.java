package com.example.myapplication.BBDD;

import android.util.JsonReader;

import com.example.myapplication.Wraper.Pelicula;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    public static Pelicula devolverPelicula(String nombre,InputStream in)
    {
        try {
            ArrayList<Pelicula> peliculas= (ArrayList<Pelicula>) readJsonStream(in);

            for (Pelicula p:peliculas) {
                if (nombre.equals(p.getTitulo())){
                        return p;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Pelicula> readJsonStream(InputStream in) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return leerPeliculas(reader);
        } finally {
            reader.close();
        }

    }

    public static List leerPeliculas(JsonReader reader) throws IOException {
        // Lista temporal
        ArrayList peliculas = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            peliculas.add(leerPelicula(reader));
        }
        reader.endArray();
        return peliculas;
    }

    public static Pelicula leerPelicula(JsonReader reader) throws IOException {
        String titulo = null;
        String descripcion = null;
        float valoracion = 0;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "Nombre":
                    titulo = reader.nextString();
                    break;
                case "Valoracion":
                    valoracion = (float) reader.nextDouble();
                    break;
                case "Descripcion":
                    descripcion = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new Pelicula(titulo, descripcion, valoracion);
    }
}
