package Logic;

import java.util.*;

import Model.Vehiculo;

public class Funcionamiento_parqueadero {
    private Map<Integer, Vehiculo> parqueadero = new HashMap<>();
    private Set<Integer> puestosOcupados = new HashSet<>();
    private int ultimoPuestoAsignado = 0;

    public Funcionamiento_parqueadero() {}

    public void parquearVehiculo(Vehiculo vehiculo) {
        parqueadero.put(vehiculo.getPuesto(), vehiculo);
        puestosOcupados.add(vehiculo.getPuesto());
    }

    public void validarDatos(String tipo, String placa, String marca) throws IllegalArgumentException {
        if (tipo.isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar el tipo de vehículo.");
        }
        if (tipo.equals("moto") || tipo.equals("carro")) {
            if (placa.isEmpty() || marca.isEmpty()) {
                throw new IllegalArgumentException("La placa y la marca no pueden estar vacías para moto o carro.");
            }
        }
    }

    // Método para asignar un puesto disponible
    public int asignarPuesto() {
        while (puestosOcupados.contains(++ultimoPuestoAsignado)) {}
        return ultimoPuestoAsignado;
    }

    public int generarContraseña() {
        int contra;
        do {
            contra = (int) Math.round(Math.random() * 99999);
        } while (contra <= 1000);
        return contra;
    }

    public boolean validarContraseña(int contraseñaIngresada, int contraseñaGenerada) {
        return contraseñaIngresada == contraseñaGenerada;
    }
}