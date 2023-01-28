package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.dto.BolsistaDTO;
import dev.fujioka.java.avancado.web.model.Bolsista;
import dev.fujioka.java.avancado.web.service.BolsistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bolsista")
public class BolsistaResource {

    @Autowired
    private BolsistaService bolsistaService;

    @PostMapping
    public ResponseEntity<BolsistaDTO> salvar(@RequestBody Bolsista bolsista){
        return ResponseEntity.ok(bolsistaService.salvar(bolsista));
    }


   @GetMapping
   public ResponseEntity<List<Bolsista>> getBolsistas(){
        return ResponseEntity.ok(bolsistaService.listarBolsistas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bolsista> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(bolsistaService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bolsista> deletePorId(@PathVariable int id){
        bolsistaService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Bolsista> alterar(@RequestBody Bolsista bolsista){
        return ResponseEntity.ok(bolsistaService.alterar(bolsista));
    }


    @GetMapping("/like/{nome}")
    public ResponseEntity<List<Bolsista>> listarPorLike(@PathVariable String nome){
        return ResponseEntity.ok(bolsistaService.buscarBolsistaLike(nome));
    }


}
