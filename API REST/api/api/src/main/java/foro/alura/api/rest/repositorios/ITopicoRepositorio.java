package foro.alura.api.rest.repositorios;
import foro.alura.api.rest.modelos.Topicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITopicoRepositorio extends JpaRepository<Topicos, Integer> {
}
