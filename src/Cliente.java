public class Cliente {
    protected String nombre;
    protected String cedula;
    protected int numerolicencia;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, int numerolicencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.numerolicencia = numerolicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getNumerolicencia() {
        return numerolicencia;
    }

    public void setNumerolicencia(int numerolicencia) {
        this.numerolicencia = numerolicencia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", numerolicencia=" + numerolicencia +
                '}';
    }
    public void MostrarInfo(){
        System.out.println("Nombre del cliente: " + nombre);
        System.out.println("Cedula del cliente: " + cedula);
        System.out.println("Licencia del cliente: " + numerolicencia);
    }
}
