package Model;

public class Vehiculo {
    private String tipo, placa, marca;
    private int puesto;

    public Vehiculo(String tipo, String placa, String marca, int puesto) {
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.puesto = puesto;
    }

    public Vehiculo() {}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    // Métodos hashCode y equals para HashSet
    @Override
    public int hashCode() {
        return placa.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return placa.equals(vehiculo.placa);
    }
}