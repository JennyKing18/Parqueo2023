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

//    public static int[] invertir(int[] array){
///*      i = 0   9-i = 9
//        i = 1   9-i = 8
//        i = 9   9-i = 0
//*/
//        int arrNuevo [] = new int[array.length];
//        int j = array.length - 1;
//        
//        for (int i = 0; i < arrNuevo.length; i++) {
//            arrNuevo[j-i] = array[i];
//        }
//        return arrNuevo;
//    }
//    
//    //[7 9 5 3 1]
//    public static int[] ordenar(int[] array){
//        
//        for (int i = 0; i < array.length; i++)
//            for (int j = 0; j < array.length-1; j++) {
//                if (array[j] < array[j+1]){
//                    int tmp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = tmp;
//                }
//            }
//         
//        return array;   
//    }
//        
//    
//    
//    
//    public static int cantidadEspacios(String str){
//        int res = 0;
//        for (int i = 0; i < str.length()-1; i++) {
//            if(str.substring(i, i+1).equals(" "))
//                res++;            
//        }
//        return res;
//    }
//    
//    public static String[] split(String str){
//        return str.split(" ");
//    }
//    
//    //hoy hay quiz  
//    public static String[] split2(String str){
//        String res[] = new String[cantidadEspacios(str)+1];
//        int inicio = 0;        
//        int fin = str.indexOf(" ", inicio);
//        int index = 0;
//        while (fin != -1){
//            fin = str.indexOf(" ", inicio);
//            if (fin != -1)
//                res[index++] = str.substring(inicio, fin);
//            else
//                res[index++] = str.substring(inicio);
//            inicio = fin+1;
//        }
//        return res;
//    }
//    
//    public static int[] intercalar(int[] arr1,int[] arr2,int[] arr3){
//        int arr[] = new int[arr1.length*3];
//        /*i * 3 
//        i *3 + 1 
//        i *3 + 2*/
//        for (int i = 0; i < arr1.length; i++) {
//            arr[i*3] = arr1[i];
//            arr[i*3+1] = arr2[i];
//            arr[i*3+2] = arr3[i];
//        }
//        return arr;
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        int arr1[] = {1,2,3,4};
//        int arr2[] = {10,20,30,40};
//        int arr3[] = {100,200,300,400};
//        int arr[] = intercalar(arr1, arr2, arr3);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+ "  ");
//        }
//        System.out.println("");
//        int arr4[] = {1,2,3,4,5,6,7,8,9};
//        int arr5[] = invertir(arr4);
//        for (int i = 0; i < arr5.length; i++) {
//            System.out.print(arr5[i] + " ");
//        }
//        System.out.println("");
//        int arr6[] = {10,655,55,12,-6,8,78};
//        ordenar(arr6);
//        for (int i = 0; i < arr6.length; i++) {
//            System.out.print(arr6[i] + "  ");
//        }
//        System.out.println("SPLIT" );
//        String s = "Hoy hay quiz";
//        String strArr[] = split2(s);
//        for (int i = 0; i < strArr.length; i++) {
//            System.out.println(strArr[i]);
//        }
//        

        //System.out.println("\n\n\n\n\n\n\n");
        
        Parqueo p = new Parqueo();
        System.out.println("************************************");
        for (int i = 0; i < 10; i++) {
            int rangoP=999999-100000+1;
            int randP=(int)(Math.random()*rangoP)+100000;
            String strP=String.valueOf(randP);
            String tipo;
            if(i%2==0){
                tipo="Carro";
            }
            else{
                tipo="Moto";
            }
            int car= p.addVehiculo(new Vehiculo(strP, tipo, i+1));
            if (car !=-1){
                System.out.println("Agregado en la posicion:  "+ car);
            }
            else
                System.out.println("No se pudo agregar:  "+ car);
        }
        p.addVehiculo(new Vehiculo("514513", "Carro", 1));
        System.out.println("************************************\n");
        
        System.out.println("Generados: "+ "\n_______________________________________________________\n"+ p.toString());
        System.out.println("_______________________________________________________\n");
        
        Vehiculo b =  p.buscarPorPlaca("514513");
        if (b!=null)
            System.out.println("ENCOTRADO: " + b.toString());
        boolean eliminado = p.removeVehiculo("514513");
        System.out.println("ELIMINADO el vehiculo:  "+ eliminado);
        System.out.println("\n\n");
        p.addHoras("514513", 5);
        p.addHorasRant(p);
        System.out.println(p.toString());
       
        p.montoTotal();
    }
    
}
