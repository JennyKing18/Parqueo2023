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
        System.out.println("************************************");
        for (int i = 0; i < 10; i++) {
            //Generar una placa random
            int rangoP=999999-100000+1;
            int randP=(int)(Math.random()*rangoP)+100000;
            String strP=String.valueOf(randP);
            ///////////////////////////////////
            //Generar un vehiculo random
            int rangoV=5-1+1;
            int randV= (int)(Math.random()*rangoV)+1;
            System.out.println("este troste"+ randV);
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
            p.addVehiculo(new Vehiculo(strP, tipo, i+1));
           
        }
        p.addVehiculo(new Vehiculo("514513", "Carro", 1));
        System.out.println("************************************\n");
        
        System.out.println("Generados: "+ "\n_______________________________________________________\n"+ p.toString());
        System.out.println("_______________________________________________________\n");
        
        Vehiculo b =  p.buscarPorPlaca("514513");
        if (b!=null)
            System.out.println("ENCOTRADO: " + b.toString());
        Vehiculo eliminado = p.removeVehiculo("514513");
        System.out.println("ELIMINADO el vehiculo:  "+ eliminado);
        System.out.println("\n\n");
        p.addHoras("514513", 5);
        p.addHorasRant(p);
        System.out.println(p.toString());
       
        p.montoTotal();
    }
    
}
