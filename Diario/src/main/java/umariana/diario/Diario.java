package umariana.diario;

import Mundo.Entrada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


/**
 *
 * @author Nicolas Maya y Juan Zambrano
 */
    public class Diario {
        //Creamos el ArrayList y el Scanner
         private ArrayList<Entrada> misEntradas;
         private Scanner lector;

    public Diario() {
        //Definimos la contenedora y el lector
        misEntradas = new ArrayList<>();
        lector = new Scanner(System.in);
    }
        //Variable para los nuevas entradas
        int nuevoIdEntrada;
        
        //Metodo para mostrar el menu
     public void mostrarMenu() {
        boolean activo = true;


        do {
            System.out.println("========= Menu de opciones ==========");
            System.out.println("1. Agregar Entrada");
            System.out.println("2. Consultar entrada");
            System.out.println("3. Eliminar entrada");
            System.out.println("4. Modificar entrada");
            System.out.println("5. Abandonar el programa");
            System.out.println("Seleccione una opcion");
            System.out.println("=====================================");
        
            int opcion = lector.nextInt();
            
             switch (opcion) {
                case 1:
                    agregarEntrada();
                    break;
                case 2:
                    consultarEntrada();
                    break;
                case 3:
                    eliminarEntrada();
                    break;
                case 4:
                    modificarEntrada();
                    break;
                case 5:
                    activo = false;
                    System.out.println("Programa terminado");
                    break;   
                    
                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }
        } while (activo);
    }
                
             //Metodo para agregar una entrada al diario
             //Solicita al usuario la descripcion de la entrada y el id y la fecha se generan automaticamente
             public void agregarEntrada() {
                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    String fecha = formato.format(new Date());
                    //Se asigna el nuevo id de la entrada
                    if(misEntradas.isEmpty())
                        {
                        nuevoIdEntrada = 1;
                        } else {
                        // Obtener el ultimo IdEntrada ingresado y sumarle uno
                            int tamanoLista = misEntradas.size(); 
                            Entrada ultimaEntrada = misEntradas.get(tamanoLista - 1);
                            nuevoIdEntrada = ultimaEntrada.getIdEntrada()+ 1;
                        }
                    
                System.out.println("Ingrese la descripcion");
                lector.nextLine();
                     
                System.out.println("Descripcion: ");
                String descripcion=lector.nextLine();
                
                //Creacion del objeto y llenar la informacion
                Entrada nuevaEntrada = new Entrada (nuevoIdEntrada, fecha, descripcion);
                
                //Almacena el objeto en la contenedora
                misEntradas.add(nuevaEntrada);
                System.out.println("La entrada fue agregado satisfactoriamente ");
                
             }
            
             //Metodo para consultar las entradas existentes
             public void consultarEntrada() {
                for (Entrada t: misEntradas){
                System.out.println("Id: " +t.getIdEntrada());
                System.out.println("Fecha: " +t.getFecha());
                System.out.println("Descripcion: " +t.getDescripcion());
                System.out.println("===============================");
                }

             }
             //Metodo para modificar la descripcion de una entrada existente
             //Solicita al usuario el id de la entrada a cambiar y la nueva descripcion
             public void modificarEntrada() {
                System.out.println("Ingrese el id de la entrada que desea modificar:");
                 int id = lector.nextInt();

                    for (Entrada entrada : misEntradas) {
                        if (entrada.getIdEntrada() == id) {
                          System.out.println("Encontrada la entrada con id " + id);
                          System.out.println("Ingrese la nueva descripción:");
                          lector.nextLine();
                           String nuevaDescripcion = lector.nextLine();
                          entrada.setDescripcion(nuevaDescripcion);
                          System.out.println("La entrada con id " + id + " ha sido modificada correctamente");
                        return;
                    }
                        System.out.println("No se encontró una entrada con id " + id);
                    }               
                }
          
             //Metodo para eliminar una entrada
             //Solicita al usuario el id de la entrada a eliminar
             public void eliminarEntrada() {
                System.out.println("Ingresa el id de la entrada a eliminar");
                 int id=lector.nextInt();
                    for(Entrada e: misEntradas){
                        if(e.getIdEntrada()==id){
                            misEntradas.remove(e);
                        }
                        else{
                        System.out.println("La entrada con id "+id+" no se ha encontrado");

                        }
                    }
                    System.out.println("La entrada con id "+id+" ha sido eliminada correctamente");           
}
        public static void main(String[] args) {
        Diario organizador = new Diario();
        organizador.mostrarMenu();
        }
    }




