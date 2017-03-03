package codigocesar;
import java.util.Scanner;
/**
 * @author MLeandroCardenas,Edgar Andres Krejci Bautista
 * @version 2017.28.02
 * 
 */
public class CodigoCesar {
    int auxiliar;
    char []alfabeto={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    Scanner teclado= new Scanner(System.in); 
    private int clave=0;    //Variables globales
    private char []letra; 
    private String mensaje;  
    /**
     * Clase principal main donde se muestra el menu de opciones
    */
    public static void main(String[] args) {
      System.out.println("MENU DE OPCIONES:\n 1.Cifrar: \n 2.Descifrar:\n");
      CodigoCesar cesar = new CodigoCesar();  /**Creacion del objeto de la clase*/ 
      cesar.menu(); /** invocacion del metodo.*/
    }
    /**El menu donde se llaman los metodos cifrarMensaje y descifrarMensaje.*/
    public void menu(){
        byte opcion;
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
    /** metodo donde se pide el mensaje y la clave y se graban*/
    private void obtenerInformacion() {
        System.out.println("Por favor escriba un mensaje:");
        mensaje=teclado.next();
        System.out.println("Por favor digite una clave:");
        clave=teclado.nextInt();  
        obtenerMensaje();
    }
    /** metodo donde el mensaje obtenido se guarda en un vector letra*/
    private void obtenerMensaje() {
        letra = new char[ mensaje.length()];
        for(int i = 0; i < mensaje.length(); i++){
            letra[i] = mensaje.charAt(i); // aqui se convierte el String a char
        }
    }
    /**
     * metodo que se encarga de cifrar el mensaje escrito por el usuario
     */
    private void  cifrarMensaje(){
        obtenerInformacion(); 
        obtenerMensaje();
        int nuevaPosicion;
        System.out.println("");
         for(int i=0; i<letra.length; i++){ // recorre la frase
             for(int j=0; j<alfabeto.length; j++){ // recorre el alfabeto
                 if(letra[i] == alfabeto[j]){
                     nuevaPosicion = (clave%26 + j) % alfabeto.length;                           
                     System.out.print(alfabeto[nuevaPosicion] + " ");
                 }
             }
         }
    }
    /**
     * metodo que se encarga de descifrar el mensaje escrito por el usuario
     */
    private void descifrarMensaje(){
        obtenerInformacion();
        obtenerMensaje();
        int nuevaPosicion;
       for (int i=0;i<letra.length;i++){
                auxiliar=letra[i];
                auxiliar=auxiliar-clave%26;
                if (auxiliar<97){
                    auxiliar=97-auxiliar;
                    auxiliar=123-auxiliar;
                }
                for (int j=0;j<alfabeto.length;j++){
                    if (auxiliar==alfabeto[j]){
                        letra[i]=alfabeto[j];
                    }
                }
            }
                for (int i=0;i<letra.length;i++){
                    System.out.print(letra[i]);
             }
       }
}