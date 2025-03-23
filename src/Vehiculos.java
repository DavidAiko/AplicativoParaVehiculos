public class Vehiculos {
    protected String marca;
    protected String modelo;
    protected int año;
    protected double precio;
    protected String estatus;
    protected int dias;

    public Vehiculos() {
    }

    public Vehiculos(String marca, String modelo, int año, double precio, String estatus, int dias) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.estatus = estatus;
        this.dias = dias;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                ", estatus='" + estatus + '\'' +
                ", dias=" + dias +
                '}';
    }

    public void MostrarInfo(){
        System.out.println("La Marca del Vehiculo es: " + marca);
        System.out.println("El modelo del Vehiculo es: " + modelo);
        System.out.println("El año del Vehiculo es: " + año);
        System.out.println("El Precio del Vehiculo es: " + precio);
        System.out.println("El estado del Vehiculo es: " + estatus);
        System.out.println("Dias alquilados: " + dias);

    }
}