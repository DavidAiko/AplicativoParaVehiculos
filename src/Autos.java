public class Autos extends Vehiculos {
    private int numeropuertas;

    public Autos(int numeropuertas) {
        this.numeropuertas = numeropuertas;
    }

    public Autos() {
    }

    public Autos(String marca, String modelo, int año, double precio, String estatus, int dias) {
        super(marca, modelo, año, precio, estatus, dias);
    }

    public Autos(String marca, String modelo, int año, double precio, String estatus, int dias, int numeropuertas) {
        super(marca, modelo, año, precio, estatus, dias);
        this.numeropuertas = numeropuertas;
    }

    public int getNumeropuertas() {
        return numeropuertas;
    }

    public void setNumeropuertas(int numeropuertas) {
        this.numeropuertas = numeropuertas;
    }

    @Override
    public void MostrarInfo(){
        System.out.println("La Marca del Vehiculo es: " + marca);
        System.out.println("El modelo del Vehiculo es: " + modelo);
        System.out.println("El año del Vehiculo es: " + año);
        System.out.println("El Precio del Vehiculo es: " + precio);
        System.out.println("El estado del Vehiculo es: " + estatus);
        System.out.println("Dias alquilados: " + dias);
        System.out.println("El Número de Puertas es: " + numeropuertas);
    }
}