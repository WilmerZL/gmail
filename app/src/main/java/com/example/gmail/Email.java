package com.example.gmail;

public class Email {
    private String remitente;   // Remitente del correo
    private String asunto;  // Asunto del correo
    private String date;     // Fecha del correo
    private boolean destacado; // Estado de estrella (destacado)
    private int Imagen; // Nuevo atributo para la imagen


    // Constructor
    public Email(String remitente, String asunto, String date, boolean destacado, int Imagen) {
        this.remitente = remitente;
        this.asunto = asunto;
        this.date = date;
        this.destacado = destacado;
        this.Imagen = Imagen; // Asignar la imagen

    }

    // Métodos getter
    public String getRemitente() {
        return remitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDate() {
        return date;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public int getImagen() {
        return Imagen; // Getter para la imagen
    }

    // Métodos setter (opcionales, si deseas modificar los valores después de la creación)
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public void setImagen(int Imagen) {
        this.Imagen = Imagen;
    }
}


