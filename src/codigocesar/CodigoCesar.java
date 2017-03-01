package codigocesar;
import java.util.Scanner;
/**
 * @author MLeandroCardenas
 * @version 2017.28.02
 * 
 */
public class CodigoCesar {
    char []alfabeto={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    Scanner teclado= new Scanner(System.in); 
    private int clave=0;    //Variables globales
    private char []letra; 
    private String mensaje;  
    //Clase principal main donde se muestra el menu de opciones
    public static void main(String[] args) {
      System.out.println("MENU DE OPCIONES:\n 1.Cifrar: \n 2.Descifrar:\n");
      CodigoCesar cesar = new CodigoCesar();  //Creacion del objeto de la clase 
      cesar.menu(); // invocacion del metodo.
    }
    // menu donde se llaman los metodos cofrarMensaje y descifrarMensaje.
    public void menu(){
        byte opcion=0;
        System.out.println("Por favor digite la opcion: ");
        opcion= teclado.nextByte();
        switch(opcion){
            case 1: 
                cifrarMensaje();
                break;
            case 2:
                descifrarMensaje();
                break;
            default:
                System.out.println("\tDIGITE UNA OPCION VALIDA\t");
                break;
        }
    }
    // metodo donde se pide el mensaje y la clavr y se graban
    private void obtenerInformacion() {
        System.out.println("Por favor escriba un mensaje:");
        mensaje=teclado.next();
        System.out.println("Por favor digite una clave:");
        clave=teclado.nextInt();  
        obtenerMensaje();
    }
    // metodo donde el mensaje obtenido se guarda en un vector letra
    private void obtenerMensaje() {
        letra = new char[ mensaje.length()];
        for(int i = 0; i < mensaje.length(); i++){
            letra[i] = mensaje.charAt(i); // aqui se convierte el String a char
        }
    }
    
    private void  cifrarMensaje(){
        obtenerInformacion(); 
        obtenerMensaje();
        int nuevaPosicion;
        System.out.println("");
         for(int i=0; i<letra.length; i++){ // recorre la frase
             for(int j=0; j<alfabeto.length; j++){ // recorre el alfabeto
                 if(letra[i] == alfabeto[j]){
                     nuevaPosicion = (clave + j) % alfabeto.length;                           
                     System.out.print(alfabeto[nuevaPosicion] + " ");
                 }
             }
         }
    }
    
    private void descifrarMensaje(){
        obtenerInformacion();
        obtenerMensaje();
        int nuevaPosicion;
        for(int i=0; i<letra.length; i++){
            for(int j=0; j<alfabeto.length; j++){
                if(letra[i] == alfabeto[j]){
                    nuevaPosicion= Math.abs(clave - j) % alfabeto.length;
                    System.out.print(alfabeto[nuevaPosicion] + " ");
                }
            }
        }  
    }
 }