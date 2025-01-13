package foro.alura.api.rest.modelos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

// Clase de entidad que representa el modelo "Topicos"
@Entity
@Table(name = "topicos") // Define el nombre de la tabla en la base de datos
public class Topicos implements Serializable {

    // Identificador único del tópico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    private int id;

    // Título del tópico
    @Column(nullable = false, length = 100) // Define restricciones de la columna
    private String titulo;

    // Mensaje o contenido del tópico
    @Column(nullable = false, columnDefinition = "TEXT") // Define como texto largo en la base de datos
    private String mensaje;

    // Fecha de creación del tópico
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // Estado del tópico (e.g., activo, cerrado, eliminado)
    @Column(nullable = false, length = 20)
    private String estatus;

    // Autor del tópico
    @Column(nullable = false, length = 50)
    private String autor;

    // Curso al que pertenece el tópico
    @Column(nullable = false, length = 50)
    private String curso;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
