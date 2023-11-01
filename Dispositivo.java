public class Dispositivo implements DispositivoElectronico {
    protected String nombre;  // Nombre del dispositivo.
    private boolean encendido;  // Estado del dispositivo).

    // Constructor que recibe el nombre del dispositivo
    public Dispositivo(String nombre) {
        this.nombre = nombre;
    }

    // Metodo para encender el dispositivo
    public void encender() {
        encendido = true;
    }

    // Metodo para apagar el dispositivo.
    public void apagar() {
        encendido = false;
    }

    // Metodo para validar y obtener el estado actual del dispositivo.
    public String validarEstado() {
        return encendido ? "Encendido" : "Apagado";
    }

    // Metodo para obtener informacion detallada sobre el dispositivo.
    public String obtenerInformacion() {
        return "Nombre: " + nombre + ", Estado: " + validarEstado();
    }
}
