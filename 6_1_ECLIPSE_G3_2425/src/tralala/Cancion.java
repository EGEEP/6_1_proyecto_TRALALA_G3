package tralala;

import java.util.ArrayList;
import java.util.List;

public class Cancion {
	public static void canjearCanciones(Usuario usuario) {
        // Comprobamos si el usuario tiene suficientes puntos
        if (usuario.getPuntos() < 100) {
            System.out.println("No tienes suficientes puntos para canjear canciones.");
            return;
        }

        // Obtenemos las canciones favoritas del usuario
        List<Cancion> favoritas = new ArrayList<>(usuario.getCancionesFavoritas());

        // Inicializamos las variables
        int maxCanciones = usuario.getPuntos() / 100;
        List<Cancion> cancionesACanjear = new ArrayList<>();

        // Iniciamos el proceso de canje de canciones
        while (cancionesACanjear.size() < maxCanciones && !favoritas.isEmpty()) {
            System.out.println("Selecciona una canción para canjear:");
            Cancion cancion = seleccionarCancion(favoritas); 

            if (!cancionesACanjear.contains(cancion)) {
                cancionesACanjear.add(cancion);
                usuario.getColeccionPermanente().add(cancion);
                favoritas.remove(cancion);
                usuario.getCancionesFavoritas().remove(cancion);
            }
        }

        // Restamos los puntos usados
        usuario.setPuntos(usuario.getPuntos() - 100 * cancionesACanjear.size());
        System.out.println(cancionesACanjear.size() + " canciones añadidas a tu colección permanente.");
    }

    // Método auxiliar simulado para seleccionar una canción 
    public static Cancion seleccionarCancion(List<Cancion> disponibles) {
        // Por simplicidad, devolvemos la primera canción de la lista
        return disponibles.get(0); 
    }

}
