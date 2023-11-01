public class Telefono extends Dispositivo {
    private String modelo;  // Modelo especifico del telefono.

    // Constructor que recibe el nombre y modelo del telefono y llama al constructor de la clase base.
    public Telefono(String nombre, String modelo) {
        super(nombre);
        this.modelo = modelo;
    }

    // Metodo para obtener el modelo del telefono.
    public String getModelo() {
        return modelo;
    }

    // Metodo para obtener informacion detallada sobre el telefono.
    public String obtenerInformacion() {
        return "Nombre: " + nombre + ", Modelo: " + getModelo() + ", Estado: " + validarEstado();
    }
}

