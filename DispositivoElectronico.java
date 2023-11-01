public interface DispositivoElectronico {
    // Activa el dispositivo electronico.
    void encender();

    // Desactiva el dispositivo electronico.
    void apagar();

    // Valida y devuelve el estado actual del dispositivo (activado o desactivado).
    String validarEstado();
}
