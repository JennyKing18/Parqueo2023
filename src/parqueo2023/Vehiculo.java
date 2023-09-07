package parqueo2023;
/**
 * @author diemo
 */
public class Vehiculo {
    private String placa;
    private String tipo;
    private double horas;
    private int descuento;
    private boolean tieneDescuento;

    public Vehiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
        this.tieneDescuento = false;
    }
    
    @Override
    //Carro 514513 [1, h:0.0]
    public String toString() {
        return tipo + "\t " + placa + "\t\t"+ " Horas: "+ horas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }
}
