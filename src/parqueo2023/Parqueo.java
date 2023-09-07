package parqueo2023;
import java.util.ArrayList;
/**
 * @author diemo
 */
public class Parqueo {
    private final int MAXIMO = 40;
    private final int MONTO_HORA = 1200;
    private ArrayList<Vehiculo> parqueo;
    private int espacios;

    public Parqueo() {
       parqueo = new ArrayList<Vehiculo>(40);
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
        if (getEspacios() + vehiculo.getEspacios()  <= MAXIMO){
            parqueo.add(vehiculo);
            this.espacios += vehiculo.getEspacios();
           // System.out.println(parqueo.indexOf(vehiculo));
            return parqueo.indexOf(vehiculo);
        }
        //System.out.println(-1);
        return -1;
    }
    
    public Vehiculo buscarPorPlaca(String placa){
        for (int i = 0; i < parqueo.size(); i++) {
            if (parqueo.get(i).getPlaca().equals(placa))
                return parqueo.get(i);
        }
        return null;
    }
    
    public boolean removeVehiculo(String placa){
        Vehiculo buscado = buscarPorPlaca(placa);
        if(buscado != null){
            parqueo.remove(buscado);
            this.espacios -= buscado.getEspacios();
            return true;
        }
        return false;
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
    
    public void calcularMontoDiario(int espacios){
        System.out.println(espacios * MONTO_HORA);
    }
    
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
            individual =parqueo.get(i).getHoras() * parqueo.get(i).getEspacios();
            System.out.println(parqueo.get(i).toString()+ "\t" + "$"+individual* MONTO_HORA);
        }
        System.out.println("______________________________________________________________");
        total=total* MONTO_HORA;
        System.out.println("Total: "+ total);
        System.out.println("______________________________________________________________");
    }
    
}
