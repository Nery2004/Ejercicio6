public class Computadora extends Dispositivo {
    private String marca;// Marca especifica de la compu.
    // Constructor que recibe el nombre y Marca de la computadora y llama al constructor de la clase base.
    public Computadora(String nombre, String marca) {
        super(nombre);
        this.marca = marca;
    }
    // Metodo para obtener la marca de la compu.
    public String getMarca() {
        return marca;
    }
    // Metodo para obtener informacion detallada sobre la compu.
    public String obtenerInformacion() {
        return "Nombre: " + nombre + ", Marca: " + getMarca() + ", Estado: " + validarEstado();
    }
}
