package foro.alura.api.rest.controladores;

import foro.alura.api.rest.services.TopicoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import foro.alura.api.rest.modelos.Topicos;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor // Inyección de dependencias a través del constructor generado automáticamente
public class TopicosController {

    // Servicio para manejar las operaciones relacionadas con los "Topicos"
    private final TopicoServiceImpl service;

    /**
     * Endpoint para obtener todos los tópicos.
     * @return Lista de todos los tópicos registrados.
     */
    @GetMapping
    public ResponseEntity<List<Topicos>> findAll() {
        List<Topicos> respuestaHttp = service.findAll(); // Llama al servicio para obtener todos los tópicos
        return ResponseEntity.ok(respuestaHttp); // Retorna un estado HTTP 200 (OK)
    }

    /**
     * Endpoint para obtener un tópico por su ID.
     * @param id ID del tópico a buscar.
     * @return El tópico correspondiente al ID proporcionado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Topicos> findById(@PathVariable Integer id) {
        Topicos respuestaHttp = service.findByID(id); // Llama al servicio para obtener el tópico por ID
        return ResponseEntity.ok(respuestaHttp); // Retorna un estado HTTP 200 (OK)
    }

    /**
     * Endpoint para guardar un nuevo tópico.
     * @param topicos Objeto del nuevo tópico a guardar.
     * @return El tópico creado con su ID generado.
     */
    @PostMapping
    public ResponseEntity<Topicos> save(@RequestBody Topicos topicos) {
        Topicos respuestaHttp = service.save(topicos); // Llama al servicio para guardar el nuevo tópico
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaHttp); // Retorna un estado HTTP 201 (CREATED)
    }

    /**
     * Endpoint para actualizar un tópico existente.
     * @param id ID del tópico a actualizar.
     * @param topicos Objeto con los nuevos datos del tópico.
     * @return El tópico actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Topicos> update(@PathVariable Integer id, @RequestBody Topicos topicos) {
        topicos.setId(id); // Asocia el ID al objeto recibido
        Topicos respuestaHttp = service.save(topicos); // Llama al servicio para actualizar el tópico
        return ResponseEntity.ok(respuestaHttp); // Retorna un estado HTTP 200 (OK)
    }

    /**
     * Endpoint para eliminar un tópico por su ID.
     * @param id ID del tópico a eliminar.
     * @return Respuesta vacía con un estado HTTP 204 (NO CONTENT).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        service.deleteById(id); // Llama al servicio para eliminar el tópico
        return ResponseEntity.noContent().build(); // Retorna un estado HTTP 204 (NO CONTENT)
    }
}
