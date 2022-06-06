package vista;


import Helpers.Auxiliar;
import modelo.ConversorEuros;
import modelo.ConversorEurosPesetas;

import java.util.Scanner;
// Version para Terminal
public class TEurosPesetas  {
    private double cantidad=0;
    private ConversorEuros conversor=new ConversorEurosPesetas();
    // Gestión de la entrada por teclado
    private Scanner sc = new Scanner(System.in);

    public void escribeCambio(String s) {
        // escribe el resultado:
        System.out.println(s);
        // y vuelve a solicitar al usuario una operación:
        carga();
    }

    public double getCantidad() {
        return cantidad;
    }

    // metodos propios de la clase
    private int leeOpcion() {
        String opcion = null;
        try {
            opcion = sc.nextLine();
            int  valor=Integer.parseInt(opcion);
            if (valor<0 || valor>2) {
                return -1;
            }
            return valor;
        } catch (Exception e) {
            return -1;
        }
    }

    private double leeCantidad() {
        System.out.print("Cantidad a convertir (formato 99.99): ");
        String s = sc.nextLine();
        if (Auxiliar.isDouble(s))
            return Double.parseDouble(s);
        else {
            System.out.println("Error en formato del número, tiene que ser 99.99: ");
            return leeCantidad();
        }
    }

    private void menu() {
        System.out.println("1: convertir Pesetas a euros");
        System.out.println("2: convertir Euros a pesetas");
        System.out.println("0: salir");
        System.out.print("Indica la operación que quiere realizar: ");
    }

    public void carga() {
        int operacion;
        do {
            menu();
            operacion = leeOpcion();
            ejecuta(operacion);
        } while (operacion!=0);
    }

    private void ejecuta(int operacion) {
        switch (operacion){
            case 0:
                System.out.println("Adiós.");
                System.exit(0);
                break;
            case 1:
               cantidad=leeCantidad();
                System.out.printf("%.2f pesetas son %.2f euros\n",
                        cantidad,
                       conversor.monedaAeuros(cantidad));
                break;
            case 2:
                cantidad=leeCantidad();
                System.out.printf("%.2f euros son %.2f pesetas\n",
                        cantidad,
                        conversor.eurosAmoneda(cantidad) );
                break;
            default: msgOpcionIncorrecta();
        }
    }

    private void msgOpcionIncorrecta() {
        System.out.print("Valores válidos:0,1,2");
    }


}
