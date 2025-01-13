package foro.alura.api.rest.services;

import foro.alura.api.rest.modelos.Topicos;
import foro.alura.api.rest.repositorios.ITopicoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio que maneja las operaciones CRUD para el modelo "Topicos".
 * Utiliza el repositorio ITopicoRepositorio para interactuar con la base de datos.
 */
@Service
@RequiredArgsConstructor
public class TopicoServiceImpl implements CRUD {

    // Inyección de dependencias: repositorio para realizar las operaciones sobre la base de datos.
    private final ITopicoRepositorio repositorio;

    /**
     * Obtiene todos los tópicos desde la base de datos.
     * @return Lista de todos los tópicos.
     */
    @Override
    public List<Topicos> findAll() {
        return repositorio.findAll();
    }

    /**
     * Obtiene un tópico por su ID desde la base de datos.
     * @param id El ID del tópico a buscar.
     * @return El tópico encontrado o lanza una excepción si no se encuentra.
     */
    @Override
    public Topicos findByID(Integer id) {
        // Busca el tópico por ID y devuelve el resultado. Si no existe, lanza una excepción.
        Optional<Topicos> optionalTopico = repositorio.findById(id);
        return optionalTopico.orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    /**
     * Guarda un nuevo tópico en la base de datos.
     * Si el tópico ya existe, lo actualiza.
     * @param topicos El objeto tópico a guardar o actualizar.
     * @return El tópico guardado o actualizado.
     */
    @Override
    public Topicos save(Topicos topicos) {
        // Guarda o actualiza el tópico en la base de datos.
        return repositorio.save(topicos);
    }

    /**
     * Actualiza los datos de un tópico existente.
     * @param id El ID del tópico que se desea actualizar.
     * @param topicos El objeto con los nuevos datos del tópico.
     * @return El tópico actualizado.
     */
    @Override
    public Topicos update(Integer id, Topicos topicos) {
        // Se asegura de que el ID del tópico coincida con el proporcionado.
        topicos.setId(id);
        // Guarda los cambios en el repositorio.
        return repositorio.save(topicos);
    }

    /**
     * Elimina un tópico por su ID.
     * @param id El ID del tópico a eliminar.
     */
    @Override
    public void deleteById(Integer id) {
        // Elimina el tópico por ID usando el repositorio.
        repositorio.deleteById(id);
    }
}
