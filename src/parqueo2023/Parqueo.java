package parqueo2023;
import java.util.ArrayList;
/**
 * @author diemo
 */
public class Parqueo {
    //private final int MAXIMO = 40;
    //private final int MONTO_HORA = 1200;
    private final int MONTO_CARRO=1500;
    private final int MONTO_MOTO=800;
    private final int MONTO_CAMIONES=2500;
    private final int MONTO_BICI=500;
    private final int MONTO_OTROS=2000;

    private ArrayList<Vehiculo> parqueo;
    private int espacios;

    public Parqueo() {
       parqueo = new ArrayList<Vehiculo>();
    }
    @Override
    public String toString() {
        int acum = 0;
        String str = "";
        for (int i = 0; i < parqueo.size(); i++) {
            acum += parqueo.get(i).getEspacios();
            str += parqueo.get(i) + "\t" + acum +"\n"; 
        }
        return str;
    }

    public int addVehiculo(Vehiculo vehiculo){
        parqueo.add(vehiculo);
        return parqueo.indexOf(vehiculo);
       
    }
    
    public Vehiculo buscarPorPlaca(String placa){
        for (int i = 0; i < parqueo.size(); i++) {
            if (parqueo.get(i).getPlaca().equals(placa))
                return parqueo.get(i);
        }
        return null;
    }
    
    public Vehiculo removeVehiculo(String placa){
        Vehiculo buscado = buscarPorPlaca(placa);
        if(buscado != null){
            parqueo.remove(buscado);
            this.espacios -= buscado.getEspacios();
            return buscado;
        }
        return null;
    }
    
    public double addHoras(String placa, double horas){
        Vehiculo buscado = buscarPorPlaca(placa);
        if(buscado != null){
            buscado.setHoras(buscado.getHoras() + horas);
            return buscado.getHoras();
        }
        return 0;
    }
    
    public void addHorasRant(Parqueo p){
        for(int i=0;i<parqueo.size();i++){
            int rangoH=10-1+1;
            int randH=(int)(Math.random()*rangoH)+1;
            String placa= parqueo.get(i).getPlaca();
            addHoras(placa,randH);
        } 
    }
    
    //public void calcularMontoDiario(int espacios){
    //    System.out.println(espacios * MONTO_HORA);
    //}
    
    private int getEspacios(){
        int res = 0;
        for (int i = 0; i < parqueo.size(); i++) {
            res += parqueo.get(i).getEspacios();
        }
        return res;
    }
    
    private double getHoras(){
        double res = 0;
        
        return res;
    }
    
    private double getEspaciosActivos(){
        double res = 0;
        for (int i = 0; i < parqueo.size(); i++) {
            res += parqueo.get(i).getHoras() * parqueo.get(i).getEspacios();
        }
        return res;
    }
    
    public void montoTotal(){
        double total = 0;
        double individual=0;
        System.out.println("********** MONTO A PAGAR DESGLOSE **********");
        System.out.println("______________________________________________________________");
        for (int i = 0; i < parqueo.size(); i++) {

            total += parqueo.get(i).getHoras() * parqueo.get(i).getEspacios();

            if (parqueo.get(i).getTipo().equals("Camion"))
            {
                individual =(parqueo.get(i).getHoras() * parqueo.get(i).getEspacios())*MONTO_CAMIONES;
                total=total* MONTO_CAMIONES;
            }
            else if (parqueo.get(i).getTipo().equals("Moto"))
            {
                individual =(parqueo.get(i).getHoras() * parqueo.get(i).getEspacios())*MONTO_MOTO;
                total=total* MONTO_MOTO;
            }
            else if (parqueo.get(i).getTipo().equals("Bici"))
            {
                individual =(parqueo.get(i).getHoras() * parqueo.get(i).getEspacios())*MONTO_BICI;
                total=total* MONTO_BICI;
            }
            else if (parqueo.get(i).getTipo().equals("Otros"))
            {
                individual =(parqueo.get(i).getHoras() * parqueo.get(i).getEspacios())*MONTO_OTROS;
                total=total* MONTO_OTROS;
            }
            else{
                individual =(parqueo.get(i).getHoras() * parqueo.get(i).getEspacios())*MONTO_CARRO;
                total=total* MONTO_OTROS;
            }
            System.out.println(parqueo.get(i).toString()+ "\t" + "$"+individual);
        }
        System.out.println("______________________________________________________________");
        System.out.println("Total: "+ total);
        System.out.println("______________________________________________________________");
    }
    
}
