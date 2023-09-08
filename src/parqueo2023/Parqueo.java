package parqueo2023;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author diemo
 */
public class Parqueo {
    //private final int MAXIMO = 40;
    //private final int MONTO_HORA = 1200;
    private final int MONTO_CARRO=1500;
    private final int MONTO_MOTO=800;
    private final int MONTO_CAMION=2500;
    private final int MONTO_BICI=500;
    private final int MONTO_OTROS=2000;

    private ArrayList<Vehiculo> parqueo;
    //private int espacios;

    public Parqueo() {
       parqueo = new ArrayList<Vehiculo>();
    }
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < parqueo.size(); i++) {
            str += parqueo.get(i) + "\n"; 
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
    
    public double calcularDescuento(int descuento, double montoOriginal)
    { //calcula el descuento
        float montoDescontado=(float)descuento/100;
        montoDescontado*=montoOriginal;
        return montoDescontado;
    }

    public int obtenerMontoOriginal(String tipo){
        int monto=0;
        
        if (tipo.equalsIgnoreCase("Camion"))
        {
            monto =MONTO_CAMION;
        }
        else if (tipo.equalsIgnoreCase("Moto"))
        {
            monto =MONTO_MOTO;
        }
        else if (tipo.equalsIgnoreCase("Bici"))
        {
            monto =MONTO_BICI;
        }
        else if (tipo.equalsIgnoreCase("Otros"))
        {
            monto =MONTO_OTROS;
        }
        else
        {
            monto =MONTO_CARRO;
        }
        return monto;

    }


    public void actualizarDescuento(String tipo, int descuento){
        double montoOG = obtenerMontoOriginal(tipo);//monto original
        for (int i = 0; i < parqueo.size(); i++) {
            if (parqueo.get(i).getTipo().equalsIgnoreCase(tipo)) {
                parqueo.get(i).setDescuento(calcularDescuento(descuento, montoOG));
                parqueo.get(i).setTieneDescuento(true);
            }
        }
    }

    public void getMensajeSalida() 
    {
        for (int i = 0; i < parqueo.size(); i++) 
        {
            String tipo=parqueo.get(i).getTipo();
            String placa=parqueo.get(i).getPlaca();
            double horas=parqueo.get(i).getHoras();
            int montoBase=obtenerMontoOriginal(tipo);///montoBase i think
            int montoTotal= (int)horas* montoBase;//monto total horas x monto base
            double descuento= parqueo.get(i).getDescuento();
            //System.out.println("este troste"+descuento);
            double montoFinal= montoTotal-descuento;
            if (parqueo.get(i).getTieneDescuento())
            {
                System.out.println(tipo+" placa "+ placa+" sale con "+horas+" horas a "+ 
                                    montoBase+ " colones por un monto de "+ montoTotal+
                                    ". Se aplica un descuento de "+ 
                                    descuento + " por lo que paga "+montoFinal+"\n");
            }
            else
            {
                System.out.println(tipo+" placa "+ placa+" sale con "+horas+" horas a "+ 
                                    montoBase+ " colones por un monto de "+ montoTotal+"\n");
            }
        }
    }
}


