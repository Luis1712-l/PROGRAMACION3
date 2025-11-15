import java.util.*;

public class ArrayListEjemplo {
    public static void main(String args[]) {
        ArrayList<String> obj = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        int c, ch;
        String str;
        char letter;
        int position;
        
        do {
            System.out.println("MANIPULACIÓN DE CADENAS");
            System.out.println("***************");
            System.out.println("1. Adicionar al final");
            System.out.println("2. Insertar en una posición particular");
            System.out.println("3. Buscar");
            System.out.println("4. Listar las cadenas que comienzan con la letra");
            System.out.println("5. Tamaño");
            System.out.println("6. Remover");
            System.out.println("7. Ordenar");
            System.out.println("8. Mostrar");
            System.out.println("Ingrese la opción");
            c = in.nextInt();
            
            switch (c) {
                case 1: {
                    System.out.println("Digite la cadena ");
                    str = in.next();
                    obj.add(str);
                    break;
                }
                case 2: {
                    System.out.println("Digite la cadena ");
                    str = in.next();
                    System.out.println("Especifique la posición");
                    position = in.nextInt();
                    if (position >= 0 && position <= obj.size()) {
                        obj.add(position, str);
                    } else {
                        System.out.println("Posición inválida");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite la cadena a buscar");
                    str = in.next();
                    int index = obj.indexOf(str);
                    if (index != -1) {
                        System.out.println("La posición de '" + str + "' es " + index);
                    } else {
                        System.out.println("Cadena no encontrada");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Digite la letra");
                    letter = in.next().charAt(0);
                    System.out.println("Cadenas que comienzan con '" + letter + "':");
                    for (String s : obj) {
                        if (s.startsWith(String.valueOf(letter))) {
                            System.out.println(s);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Tamaño de la lista " + obj.size());
                    break;
                }
                case 6: {
                    System.out.println("Digite la cadena a remover");
                    str = in.next();
                    if (obj.remove(str)) {
                        System.out.println("Cadena removida exitosamente");
                    } else {
                        System.out.println("Cadena no encontrada");
                    }
                    break;
                }
                case 7: {
                    Collections.sort(obj);
                    System.out.println("ArrayList ordenado");
                    break;
                }
                case 8: {
                    System.out.println("El ArrayList tiene los siguientes elementos: " + obj);
                    break;
                }
                default:
                    System.out.println("Opción inválida");
            }
            
            System.out.println("Por favor ingrese, 0 para salir, 1 para continuar");
            ch = in.nextInt();
        } while (ch == 1);
        in.close();
    }
}