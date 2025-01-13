package foro.alura.api.rest.servicios;

import foro.alura.api.rest.modelos.Topicos;
import foro.alura.api.rest.repositorios.Topico_Repositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Topico_ServiceImpl implements CRUD {

    private final Topico_Repositorio repositorio;
    private Integer id;

    @Override
    public List<Topicos> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Topicos findByID(Integer id) {
        return null;
    }

    @Override
    public Topicos save(Topicos topicos) {
        return repositorio.findById(id).orElseThrow();
    }

    @Override
    public Topicos update(Integer id, Topicos topicos) {
        topicos.setId(id);
        return repositorio.save(topicos);
    }

    @Override
    public void deleteById(Integer id) {
    repositorio.deleteById(id);
    }
}
