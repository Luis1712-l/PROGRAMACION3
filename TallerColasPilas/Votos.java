import java.util.*;

public class Votos{
    public static int votosAFavorVsContra(int upvotes, int downvotes) {
        Queue<Integer> colaVotos = new LinkedList<>();
        
        for (int i = 0; i < upvotes; i++) {
            colaVotos.offer(1);
        }
        
        for (int i = 0; i < downvotes; i++) {
            colaVotos.offer(-1);
        }
        
        int suma = 0;
        while (!colaVotos.isEmpty()) {
            suma += colaVotos.poll();
        }
        
        return suma;
    }
}