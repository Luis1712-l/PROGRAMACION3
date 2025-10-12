// Main.java
import java.util.*;

public class Ejecutar{
    public static void main(String[] args) {
        System.out.println("=== TALLER PILAS Y COLAS - EJECUCIÓN COMPLETA ===");
        
        // Prueba 1: Votos a favor vs. en contra
        System.out.println("\n1. Votos a favor vs. en contra:");
        System.out.println("13, 0 -> " + Votos.votosAFavorVsContra(13, 0));
        System.out.println("2, 33 -> " + Votos.votosAFavorVsContra(2, 33));
        System.out.println("132, 132 -> " + Votos.votosAFavorVsContra(132, 132));
        
        // Prueba 2: Pan similar
        System.out.println("\n2. Pan similar:");
        String[] s1 = {"pan blanco", "lechuga", "pan blanco"};
        String[] s2 = {"pan blanco", "tomate", "pan blanco"};
        String[] s3 = {"pan integral", "queso", "pan integral"};
        String[] s4 = {"pan blanco", "queso", "pan integral"};
        System.out.println("S1 vs S2: " + PanSimilar.SandwichesSimilares(s1, s2));
        System.out.println("S3 vs S4: " + PanSimilar.SandwichesSimilares(s3, s4));
        
        // Prueba 3: Cuadrados y cubos
        System.out.println("\n3. Cuadrados y cubos:");
        System.out.println("4, 8 -> " + CuadradosyCubos.sonRaicesEquivalentes(4, 8));
        System.out.println("16, 48 -> " + CuadradosyCubos.sonRaicesEquivalentes(16, 48));
        System.out.println("9, 27 -> " + CuadradosyCubos.sonRaicesEquivalentes(9, 27));
        
        // Prueba 4: Formateo telefónico
        System.out.println("\n4. Formateo telefónico:");
        int[] tel1 = {1,2,3,4,5,6,7,8,9,0};
        int[] tel2 = {3,0,0,1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(tel1) + " -> " + FormateadorTelefono.formatear(tel1));
        System.out.println(Arrays.toString(tel2) + " -> " + FormateadorTelefono.formatear(tel2));
        
        // Prueba 5: Segundo más grande
        System.out.println("\n5. Segundo más grande:");
        int[] nums1 = {10, 40, 30, 20, 50};
        int[] nums2 = {5, 5, 5, 5, 9};
        int[] nums3 = {-3, -1, -7, -2};
        System.out.println(Arrays.toString(nums1) + " -> " + BuscadorSegundoMayor.encontrarSegundoMayor(nums1));
        System.out.println(Arrays.toString(nums2) + " -> " + BuscadorSegundoMayor.encontrarSegundoMayor(nums2));
        System.out.println(Arrays.toString(nums3) + " -> " + BuscadorSegundoMayor.encontrarSegundoMayor(nums3));
        
        // Prueba 6: Sociedad secreta
        System.out.println("\n6. Sociedad secreta:");
        String[] nombres1 = {"Adam", "Sarah", "Malcolm"};
        String[] nombres2 = {"bruce", "clark", "diana"};
        String[] nombres3 = {"Zoe", "anna", "leo"};
        System.out.println(Arrays.toString(nombres1) + " -> " + GeneradorSociedadSecreta.generarNombre(nombres1));
        System.out.println(Arrays.toString(nombres2) + " -> " + GeneradorSociedadSecreta.generarNombre(nombres2));
        System.out.println(Arrays.toString(nombres3) + " -> " + GeneradorSociedadSecreta.generarNombre(nombres3));
        
        // Prueba 7: Cadenas de cuatro letras
        System.out.println("\n7. Cadenas de cuatro letras:");
        String[] palabras1 = {"Tomate", "Papa", "Par"};
        String[] palabras2 = {"Luz", "Casa", "Sol", "Lago"};
        String[] palabras3 = {"Azul", "Rojo", "Verde"};
        System.out.println(Arrays.toString(palabras1) + " -> " + FiltradorPalabras.filtrarPorLongitud(palabras1, 4));
        System.out.println(Arrays.toString(palabras2) + " -> " + FiltradorPalabras.filtrarPorLongitud(palabras2, 4));
        System.out.println(Arrays.toString(palabras3) + " -> " + FiltradorPalabras.filtrarPorLongitud(palabras3, 4));
        
        // Prueba 8: Guerra de números
        System.out.println("\n8. Guerra de números:");
        int[] guerra1 = {2, 8, 7, 5};
        int[] guerra2 = {1, 3, 5, 9};
        int[] guerra3 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(guerra1) + " -> " + CalculadoraGuerraNumeros.calcularDiferencia(guerra1));
        System.out.println(Arrays.toString(guerra2) + " -> " + CalculadoraGuerraNumeros.calcularDiferencia(guerra2));
        System.out.println(Arrays.toString(guerra3) + " -> " + CalculadoraGuerraNumeros.calcularDiferencia(guerra3));
    }
}