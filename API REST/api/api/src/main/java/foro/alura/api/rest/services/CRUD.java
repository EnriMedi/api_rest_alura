package foro.alura.api.rest.services;

import foro.alura.api.rest.modelos.Topicos;
import java.util.List;

// Interfaz para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre el modelo "Topicos"
public interface CRUD {

    /**
     * Método para obtener todos los tópicos.
     * @return Lista de todos los tópicos.
     */
    List<Topicos> findAll();

    /**
     * Método para obtener un tópico por su ID.
     * @param id El ID del tópico que se desea obtener.
     * @return El tópico correspondiente al ID.
     */
    Topicos findByID(Integer id);

    /**
     * Método para guardar un nuevo tópico o actualizar uno existente.
     * @param topicos El objeto del tópico que se desea guardar o actualizar.
     * @return El tópico guardado o actualizado.
     */
    Topicos save(Topicos topicos);

    /**
     * Método para actualizar un tópico existente.
     * @param id El ID del tópico que se desea actualizar.
     * @param topicos El objeto con los nuevos datos del tópico.
     * @return El tópico actualizado.
     */
    Topicos update(Integer id, Topicos topicos);

    /**
     * Método para eliminar un tópico por su ID.
     * @param id El ID del tópico que se desea eliminar.
     */
    void deleteById(Integer id);
}
