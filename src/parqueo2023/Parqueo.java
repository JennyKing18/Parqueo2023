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
    public void actualizarDescuento(String tipo, int descuento){
        for (int i = 0; i < parqueo.size(); i++) {
            if (parqueo.get(i).getTipo().equalsIgnoreCase(tipo)) {
                parqueo.get(i).setDescuento(descuento);
                parqueo.get(i).setTieneDescuento(true);
            }
        }
    }

    public void getMensajeSalida() {
        for (int i = 0; i < parqueo.size(); i++) {
            if (parqueo.get(i).getTieneDescuento()) {
                int randomDescuento = new Random().nextInt(101);
                if (parqueo.get(i).getTipo().equalsIgnoreCase("carro")) {
                    parqueo.actualizarDescuento("carro", randomDescuento);
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + 
                    " horas a " + MONTO_CARRO + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_CARRO + 
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CARRO) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_CARRO - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CARRO)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("moto")) {
                    parqueo.actualizarDescuento("moto", randomDescuento);
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_MOTO + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_MOTO +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_MOTO) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_MOTO - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_MOTO)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("camion")) {
                    parqueo.actualizarDescuento("camion", randomDescuento);
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_CAMION + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_CAMION +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CAMION) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_CAMION - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CAMION)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("bici")) {
                    parqueo.actualizarDescuento("bici", randomDescuento);
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_BICI + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_BICI +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_BICI) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_BICI - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_BICI)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("otros")) {
                    parqueo.actualizarDescuento("otros", randomDescuento);
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_OTROS + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_OTROS +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_OTROS) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_OTROS - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_OTROS)));
                }
            }
            else {
                if (parqueo.get(i).getTipo().equalsIgnoreCase("carro")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + " horas a " +
                    MONTO_CARRO + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_CARRO);
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("moto")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + " horas a " +
                    MONTO_MOTO + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_MOTO);
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("camion")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + " horas a " +
                    MONTO_CAMION + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_CAMION);
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("bici")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + " horas a " +
                    MONTO_BICI + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_BICI);
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("otros")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + " horas a " +
                    MONTO_OTROS + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_OTROS);
                }
            }
        }

    }
    
    public void montoTotal(){
        double total = 0;
        double individual=0;
        System.out.println("______________________________________________________________________________");
        System.out.println("********** MONTO A PAGAR DESGLOSE **********");
        System.out.println("______________________________________________________________________________");
        for (int i = 0; i < parqueo.size(); i++) {

            total += parqueo.get(i).getHoras() * parqueo.get(i).getEspacios();

            if (parqueo.get(i).getTipo().equals("Camion"))
            {
                individual =(parqueo.get(i).getHoras() * parqueo.get(i).getEspacios())*MONTO_CAMION;
                total=total* MONTO_CAMION;
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
        System.out.println("______________________________________________________________________________");
        System.out.println("Total: "+ total); 
        System.out.println("______________________________________________________________________________");
    }
    
}
