package parqueo2023;
/**
 * @author diemo
 */
public class Vehiculo {
    private String placa;
    private String tipo;
    private int espacios; // espacios que ocupa en el paruqeo
    private double horas;

    public Vehiculo(String placa, String tipo, int espacios) {
        this.placa = placa;
        this.tipo = tipo;
        this.espacios = espacios;
    }
    
    @Override
    //Carro 514513 [1, h:0.0]
    public String toString() {
        return tipo + "\t " + placa + "\t\t"+espacios+"\t" + " Horas: "+ horas;
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
}
