package parqueo2023;
import java.util.ArrayList;
/**
 * @author diemo
 */
public class Parqueo {
    private final int MONTO_CARRO = 1500;
    private final int MONTO_MOTO = 800;
    private final int MONTO_CAMION = 2500;
    private final int MONTO_BICI = 500;
    private final int MONTO_OTROS = 2000;
    private ArrayList<Vehiculo> parqueo;

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
    
    public double sumarHoras(String placa, double horas){
        Vehiculo buscado = buscarPorPlaca(placa);
        if(buscado != null){
            buscado.setHoras(buscado.getHoras() + horas);
            return buscado.getHoras();
        }
        return 0;
    }
    
    
    
    private double getHoras(){
        double res = 0;
        
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
                if (parqueo.get(i).getTipo().equalsIgnoreCase("carro")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() + 
                    " horas a " + MONTO_CARRO + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_CARRO + 
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CARRO) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_CARRO - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CARRO)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("moto")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_MOTO + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_MOTO +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_MOTO) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_MOTO - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_MOTO)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("camion")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_CAMION + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_CAMION +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CAMION) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_CAMION - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_CAMION)));
                } else if (parqueo.get(i).getTipo().equalsIgnoreCase("bici")) {
                    System.out.println("Vehiculo placa " + parqueo.get(i).getPlaca() + " sale con " + parqueo.get(i).getHoras() +
                    " horas a " + MONTO_BICI + " colones por un monto de " + parqueo.get(i).getHoras() * MONTO_BICI +
                    " colones con un descuento de " + (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_BICI) +
                    " por lo que paga " + (parqueo.get(i).getHoras()*MONTO_BICI - (parqueo.get(i).getDescuento()/100 * parqueo.get(i).getHoras()*MONTO_BICI)));
                } else if (parque.get(i).getTipo().equalsIgnoreCase("otros")) {
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

}
