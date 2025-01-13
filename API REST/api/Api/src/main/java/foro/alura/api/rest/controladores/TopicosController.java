package foro.alura.api.rest.controladores;

import foro.alura.api.rest.servicios.Topico_ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import foro.alura.api.rest.modelos.Topicos;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicosController {
    private final Topico_ServiceImpl service;

    //Metodo GET
    @GetMapping
    public ResponseEntity<List<Topicos>>findAll(){

        List <Topicos> respuestaHttp = service.findAll();
        return new ResponseEntity<>(respuestaHttp, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Topicos> findById(@PathVariable Integer id){

        Topicos respuestaHttp = service.findByID(id);
        return new ResponseEntity<>(respuestaHttp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Topicos> save(@RequestBody Topicos topicos){

        Topicos respuestaHttp = service.save(topicos);
        return new ResponseEntity<>(respuestaHttp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topicos> update(@PathVariable Integer id, @RequestBody Topicos topicos){
    topicos.setId(id);
    Topicos respuestaHttp = service.save(topicos);
    return new ResponseEntity<>(respuestaHttp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
