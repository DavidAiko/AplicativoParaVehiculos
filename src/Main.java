import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        List<Vehiculos> lsAutos = new ArrayList<>();
        List<Vehiculos> lsCamionetas = new ArrayList<>();
        List<Cliente> lsClientes = new ArrayList<>();
        boolean estado = true;
        int op, op1;

        do {
            System.out.println("""
                    
                    ╔======================================╗
                    ║         ALQUILER DE VEHÍCULOS        ║
                    ╠======================================╣
                    ║ 📋 [1] REGISTRAR UN VEHÍCULO         ║
                    ║ 👤 [2] REGISTRAR UN CLIENTE          ║
                    ║ 📜 [3] REALIZAR ALQUILER             ║
                    ║ 💰 [4] CALCULAR COSTO                ║
                    ║ 🚘 [5] MOSTRAR VEHÍCULOS             ║
                    ║ 🔄 [6] REGISTRAR UNA DEVOLUCIÓN      ║
                    ╠======================================╣
                    ║ ❌ [7] SALIR DE LA APLICACIÓN        ║
                    ╚======================================╝

                    """);
            op = teclado.nextInt();
            teclado.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.println("REGISTRAR UN VEHICULO");
                    System.out.println("[1] REGISTRAR AUTO");
                    System.out.println("[2] REGISTRAR CAMIONETA");
                    op1 = teclado.nextInt();
                    teclado.nextLine();
                    switch (op1) {
                        case 1 -> {
                            System.out.println("REGISTRAR AUTO");
                            System.out.print("INGRESE LA MARCA DEL AUTO: ");
                            String marca = teclado.nextLine();
                            System.out.print("INGRESE EL MODELO DEL AUTO: ");
                            String modelo = teclado.nextLine();
                            System.out.print("INGRESE EL AÑO DEL AUTO: ");
                            int año = teclado.nextInt();
                            System.out.print("INGRESE EL PRECIO POR DÍA DEL AUTO: ");
                            double precio = teclado.nextDouble();
                            System.out.print("INGRESE EL NÚMERO DE PUERTAS: ");
                            int numeropuertas = teclado.nextInt();
                            lsAutos.add(new Autos(marca, modelo, año, precio, "DISPONIBLE", 0, numeropuertas));
                        }case 2 -> {
                            System.out.println("REGISTRAR CAMIONETA");
                            System.out.print("INGRESE LA MARCA DE LA CAMIONETA: ");
                            String marca = teclado.nextLine();
                            System.out.print("INGRESE EL MODELO DE LA CAMIONETA: ");
                            String modelo = teclado.nextLine();
                            System.out.print("INGRESE EL AÑO DE LA CAMIONETA: ");
                            int año = teclado.nextInt();
                            System.out.print("INGRESE EL PRECIO POR DÍA DE LA CAMIONETA: ");
                            double precio = teclado.nextDouble();
                            System.out.print("INGRESE EL NÚMERO DE PUERTAS: ");
                            int capacidad = teclado.nextInt();
                            lsCamionetas.add(new Camionetas(marca, modelo, año, precio, "DISPONIBLE", 0, capacidad));
                        }
                        default -> System.out.println("OPCIÓN INVÁLIDA.");

                    }
                }case 2 -> {
                    System.out.println("REGISTRAR NUEVO CLIENTE");
                    System.out.print("INGRESE EL NOMBRE DEL CLIENTE: ");
                    String nombre = teclado.nextLine();
                    System.out.print("INGRESE LA CÉDULA DEL CLIENTE: ");
                    String cedula = teclado.nextLine();
                    System.out.print("INGRESE EL NÚMERO DE LICENCIA: ");
                    int numerolicencia = teclado.nextInt();
                    lsClientes.add(new Cliente(nombre, cedula, numerolicencia));
                }case 3 -> {
                    System.out.println("REALIZAR ALQUILER");
                    System.out.println("[1] ALQUILAR AUTO");
                    System.out.println("[2] ALQUILAR CAMIONETA");
                    op1 = teclado.nextInt();
                    teclado.nextLine();

                    switch (op1) {
                        case 1 -> {
                            System.out.println("ALQUILAR AUTO");
                            if (lsClientes.isEmpty()) {
                                System.out.println("NO HAY CLIENTES REGISTRADOS.");
                                break;
                            }
                            if (lsAutos.isEmpty()) {
                                System.out.println("NO HAY AUTOS DISPONIBLES.");
                                break;
                            }
                            System.out.print("INGRESE SU NOMBRE DE CLIENTE: ");
                            String NombreCliente = teclado.nextLine();
                            boolean clienteEncontrado = false;

                            for (Cliente cu : lsClientes) {
                                if (cu.getNombre().equalsIgnoreCase(NombreCliente)) {
                                    clienteEncontrado = true;
                                    System.out.print("INGRESE MODELO DEL AUTO: ");
                                    String NombreAuto = teclado.nextLine();
                                    boolean autoEncontrado = false;

                                    for (Vehiculos tu : lsAutos) {
                                        if (tu.getModelo().equalsIgnoreCase(NombreAuto)) {
                                            autoEncontrado = true;
                                            if (tu.getEstatus().equalsIgnoreCase("NO DISPONIBLE")) {
                                                System.out.println("AUTO NO DISPONIBLE...");
                                            } else {
                                                System.out.print("INGRESE LOS DÍAS DE ALQUILER: ");
                                                int diasAlquiler = teclado.nextInt();
                                                teclado.nextLine();
                                                tu.setEstatus("NO DISPONIBLE");
                                                tu.setDias(diasAlquiler);
                                                System.out.println("ALQUILER EXITOSO POR " + diasAlquiler + " DÍAS.");
                                            }
                                            break;
                                        }
                                    }
                                    if (!autoEncontrado) {
                                        System.out.println("MODELO NO ENCONTRADO...");
                                    }
                                    break;
                                }
                            }
                            if (!clienteEncontrado) {
                                System.out.println("CLIENTE NO REGISTRADO...");
                            }
                        }case 2 -> {
                            System.out.println("ALQUILAR CAMIONETA");
                            if (lsClientes.isEmpty()) {
                                System.out.println("NO HAY CLIENTES REGISTRADOS.");
                                break;
                            }
                            if (lsCamionetas.isEmpty()) {
                                System.out.println("NO HAY CAMIONETAS DISPONIBLES.");
                                break;
                            }
                            System.out.print("INGRESE SU NOMBRE DE CLIENTE: ");
                            String NombreCliente = teclado.nextLine();
                            boolean clienteEncontrado = false;

                            for (Cliente cu : lsClientes) {
                                if (cu.getNombre().equalsIgnoreCase(NombreCliente)) {
                                    clienteEncontrado = true;
                                    System.out.print("INGRESE MODELO DE LA CAMIONETA: ");
                                    String NombreAuto = teclado.nextLine();
                                    boolean autoEncontrado = false;

                                    for (Vehiculos tu : lsCamionetas) {
                                        if (tu.getModelo().equalsIgnoreCase(NombreAuto)) {
                                            autoEncontrado = true;
                                            if (tu.getEstatus().equalsIgnoreCase("NO DISPONIBLE")) {
                                                System.out.println("CAMIONETA NO DISPONIBLE...");
                                            } else {
                                                System.out.print("INGRESE LOS DÍAS DE ALQUILER: ");
                                                int diasAlquiler = teclado.nextInt();
                                                teclado.nextLine();
                                                tu.setEstatus("NO DISPONIBLE");
                                                tu.setDias(diasAlquiler);
                                                System.out.println("ALQUILER EXITOSO POR " + diasAlquiler + " DÍAS.");
                                            }
                                            break;
                                        }
                                    }
                                    if (!autoEncontrado) {
                                        System.out.println("MODELO NO ENCONTRADO...");
                                    }
                                    break;
                                }
                            }
                            if (!clienteEncontrado) {
                                System.out.println("CLIENTE NO REGISTRADO...");
                            }
                        }
                        default -> System.out.println("OPCIÓN INVÁLIDA.");
                    }

                }
                case 4 -> {
                    System.out.println("CALCULAR COSTO TOTAL DEL ALQUILER");
                    System.out.print("INGRESE MODELO DEL VEHÍCULO ALQUILADO: ");
                    String NombreAuto = teclado.nextLine();
                    boolean vehiculoEncontrado = false;

                    for (Vehiculos tu : lsAutos) {
                        if (tu.getModelo().equalsIgnoreCase(NombreAuto) && tu.getEstatus().equalsIgnoreCase("NO DISPONIBLE")) {
                            vehiculoEncontrado = true;
                            double costoTotal = tu.getDias() * tu.getPrecio();

                            if (tu.getDias() > 7) {
                                costoTotal *= 0.9;
                                System.out.println("SE APLICÓ UN DESCUENTO DEL 10% POR ALQUILER MAYOR A 7 DÍAS.");
                            }

                            System.out.println("COSTO TOTAL DEL ALQUILER: $" + costoTotal);
                            break;
                        }
                    }
                    if (!vehiculoEncontrado) {
                        for (Vehiculos tu : lsCamionetas) {
                            if (tu.getModelo().equalsIgnoreCase(NombreAuto) && tu.getEstatus().equalsIgnoreCase("NO DISPONIBLE")) {
                                vehiculoEncontrado = true;
                                double costoTotal = tu.getDias() * tu.getPrecio();

                                if (tu.getDias() > 7) {
                                    costoTotal *= 0.9;
                                    System.out.println("SE APLICÓ UN DESCUENTO DEL 10% POR ALQUILER MAYOR A 7 DÍAS.");
                                }

                                System.out.println("COSTO TOTAL DEL ALQUILER: $" + costoTotal);
                                break;
                            }
                        }
                    }
                    if (!vehiculoEncontrado) {
                        System.out.println("EL VEHÍCULO NO SE ENCUENTRA ALQUILADO O NO EXISTE.");
                    }
                }case 5 -> {
                    System.out.println("LISTA DE VEHÍCULOS DISPONIBLES:");

                    boolean hayDisponibles = false;
                    boolean hayNoDisponibles = false;

                    for (Vehiculos tu : lsAutos) {
                        if (tu.getEstatus().equalsIgnoreCase("DISPONIBLE")) {
                            System.out.println("AUTO | MODELO: " + tu.getModelo() + " | PRECIO POR DÍA: $" + tu.getPrecio());
                            hayDisponibles = true;
                        }
                    }
                    for (Vehiculos tu : lsCamionetas) {
                        if (tu.getEstatus().equalsIgnoreCase("DISPONIBLE")) {
                            System.out.println("CAMIONETA | MODELO: " + tu.getModelo() + " | PRECIO POR DÍA: $" + tu.getPrecio());
                            hayDisponibles = true;
                        }
                    }
                    if (!hayDisponibles) {
                        System.out.println("NO HAY VEHÍCULOS DISPONIBLES PARA ALQUILAR.");
                    }
                    System.out.println("LISTA DE VEHÍCULOS NO DISPONIBLES:");
                    for (Vehiculos tu : lsAutos) {
                        if (tu.getEstatus().equalsIgnoreCase("NO DISPONIBLE")) {
                            System.out.println("AUTO | MODELO: " + tu.getModelo() + " | DÍAS ALQUILADO: " + tu.getDias());
                            hayNoDisponibles = true;
                        }
                    }
                    for (Vehiculos tu : lsCamionetas) {
                        if (tu.getEstatus().equalsIgnoreCase("NO DISPONIBLE")) {
                            System.out.println("CAMIONETA | MODELO: " + tu.getModelo() + " | DÍAS ALQUILADO: " + tu.getDias());
                            hayNoDisponibles = true;
                        }
                    }
                    if (!hayNoDisponibles) {
                        System.out.println("NO HAY VEHÍCULOS NO DISPONIBLES EN ESTE MOMENTO.");
                    }
                }case 6 -> {
                    System.out.println("REGISTRAR DEVOLUCIÓN DE VEHÍCULO");

                    System.out.print("INGRESE MODELO DEL VEHÍCULO A DEVOLVER: ");
                    String modeloDevolver = teclado.nextLine();
                    boolean vehiculoEncontrado = false;
                    for (Vehiculos tu : lsAutos) {
                        if (tu.getModelo().equalsIgnoreCase(modeloDevolver)) {
                            vehiculoEncontrado = true;
                            if (tu.getEstatus().equalsIgnoreCase("DISPONIBLE")) {
                                System.out.println("EL VEHÍCULO YA ESTÁ DISPONIBLE.");
                            } else {
                                tu.setEstatus("DISPONIBLE");
                                tu.setDias(0);
                                System.out.println("DEVOLUCIÓN EXITOSA. EL VEHÍCULO AHORA ESTÁ DISPONIBLE.");
                            }
                            break;
                        }
                    }
                    if (!vehiculoEncontrado) {
                        for (Vehiculos tu : lsCamionetas) {
                            if (tu.getModelo().equalsIgnoreCase(modeloDevolver)) {
                                vehiculoEncontrado = true;
                                if (tu.getEstatus().equalsIgnoreCase("DISPONIBLE")) {
                                    System.out.println("EL VEHÍCULO YA ESTÁ DISPONIBLE.");
                                } else {
                                    tu.setEstatus("DISPONIBLE");
                                    tu.setDias(0);
                                    System.out.println("DEVOLUCIÓN EXITOSA. EL VEHÍCULO AHORA ESTÁ DISPONIBLE.");
                                }
                                break;
                            }
                        }
                    }
                    if (!vehiculoEncontrado) {
                        System.out.println("VEHÍCULO NO ENCONTRADO.");
                    }
                }case 7 -> {
                    estado = false;
                    System.out.println("SALIENDO DEL SISTEMA...");
                }
                default -> System.out.println("OPCIÓN INVÁLIDA.");
            }
        } while (estado);
    }
}