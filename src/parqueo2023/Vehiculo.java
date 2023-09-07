package parqueo2023;
/**
 * @author diemo
 */
public class Vehiculo {
    private String placa;
    private String tipo;
    private int espacios; // espacios que ocupa en el paruqeo
    private double horas;
    private int descuento;
    private boolean tieneDescuento;

    public Vehiculo(String placa, String tipo, int espacios, int descuento, boolean tieneDescuento) {
        this.placa = placa;
        this.tipo = tipo;
        this.espacios = espacios;
        this.descuento=descuento;
        this.tieneDescuento = false;
    }
    
    @Override
    //Carro 514513 [1, h:0.0]
    public String toString() {
        return tipo + "\t\t  " + placa + "\t\t"+espacios+"\t" + " Horas: "+ horas;
        //return tipo + ": " + placa + " [" + espacios +", h:"+ horas +']';
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

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
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
