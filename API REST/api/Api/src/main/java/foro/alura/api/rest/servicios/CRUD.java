package foro.alura.api.rest.servicios;
import foro.alura.api.rest.modelos.Topicos;
import java.util.List;
public interface CRUD {
    // Metodo GET
    List<Topicos> findAll();
    Topicos findByID(Integer id);

    // Metodo POST
    Topicos save(Topicos topicos);

    //Metodo PUT
    Topicos update(Integer id, Topicos topicos);

    //Metodo DELETE
    void deleteById(Integer id);
}
