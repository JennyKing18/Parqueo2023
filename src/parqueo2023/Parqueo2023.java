/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueo2023;


/**
 *
 * @author diemo
 */
import java.lang.Math;
public class Parqueo2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Parqueo p = new Parqueo();
        for (int i = 0; i < 10; i++) {
            //Generar una placa random
            int rangoP=999999-100000+1;
            int randP=(int)(Math.random()*rangoP)+100000;
            String strP=String.valueOf(randP);
            ///////////////////////////////////
            //Generar un vehiculo random
            int rangoV=5-1+1;
            int randV= (int)(Math.random()*rangoV)+1;
            ////////////////////////////
            String tipo;
            if (randV==1)
            {
                tipo="Carro";
            }
            else if(randV==2)
            {
                //abreviado tq el toString no lo deje feo
                tipo="Moto";
            }
            else if (randV==3)
            {
                tipo="Camion";
            }
            else if (randV==4){
                tipo="Bici";
            }
            else{
                tipo="Otros";
            }
            p.addVehiculo(new Vehiculo(strP, tipo,0,false));
           
        }
        p.addVehiculo(new Vehiculo("514513", "Carro",0,false));
        
        System.out.println("Generados: "+ "\n_______________________________________________________\n"+ p.toString());
        System.out.println("_______________________________________________________\n");
        
        /******************BUSCAR***********************/
        System.out.println("********** BUSCAR ********************************************************************\n");
        Vehiculo b =  p.buscarPorPlaca("514513");
        if (b!=null)
            System.out.println("ENCOTRADO: " + b.toString());
        System.out.println("\n\n");
        /**************************************** */

        /******************ELIMINAR***********************/
        Vehiculo eliminado = p.removeVehiculo("514513");
        System.out.println("********** ELIMINAR ********************************************************************\n");
        System.out.println("ELIMINADO el vehiculo:  "+ eliminado);
        System.out.println("\n\n");
        /*****************************************/

        /*******************Agregar horas random**********************/
        p.addHoras("514513", 5);
        p.addHorasRant(p);
        System.out.println("********** Agrega Horas ********************************************************************\n");
        System.out.println(p.toString());
        /*****************************************/
        p.actualizarDescuento("Moto",5);
        p.getMensajeSalida();
        p.montoTotal();
    }
    
}
