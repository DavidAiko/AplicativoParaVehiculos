public class Camionetas extends Vehiculos {
    private int capacidad;

    public Camionetas(int capacidad) {
        this.capacidad = capacidad;
    }

    public Camionetas() {
    }

    public Camionetas(String marca, String modelo, int año, double precio, String estatus, int dias) {
        super(marca, modelo, año, precio, estatus, dias);
    }

    public Camionetas(String marca, String modelo, int año, double precio, String estatus, int dias, int capacidad) {
        super(marca, modelo, año, precio, estatus, dias);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Camionetas{" +
                "capacidad='" + capacidad + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                ", estatus='" + estatus + '\'' +
                ", dias=" + dias +
                '}';
    }

    @Override
    public void MostrarInfo(){
        System.out.println("La Marca del Vehiculo es: " + marca);
        System.out.println("El modelo del Vehiculo es: " + modelo);
        System.out.println("El año del Vehiculo es: " + año);
        System.out.println("El Precio del Vehiculo es: " + precio);
        System.out.println("El estado del Vehiculo es: " + estatus);
        System.out.println("La capacidad de Carga es: " + capacidad);
    }
}