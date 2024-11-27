package com.senac.diogoboechat.galeria.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senac.diogoboechat.galeria.entities.ObraDeArte;
import com.senac.diogoboechat.galeria.services.ObraDeArteService;

@RestController
@RequestMapping("obra")
public class ObraDeArteController {

    private final ObraDeArteService obraDeArteService;

    public ObraDeArteController(ObraDeArteService obraDeArteService) {
        this.obraDeArteService = obraDeArteService;
    }

    @GetMapping
    public ResponseEntity<List<ObraDeArte>> listarObras() {
        List<ObraDeArte> obras = obraDeArteService.listarObrasDisponiveis();
        return ResponseEntity.ok(obras);
    }

    @GetMapping("{id}")
    public ResponseEntity<ObraDeArte> buscarObraPorId(@PathVariable int id) {
        ObraDeArte obra = obraDeArteService.listarObraPorId(id);
        if (obra != null) {
            return ResponseEntity.ok(obra);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "adicionarObra")
    public ResponseEntity<ObraDeArte> adicionarObra(@RequestBody ObraDeArte obraDeArte) {
        ObraDeArte tempObra = obraDeArteService.adicionarObra(obraDeArte);
        return ResponseEntity.ok(tempObra);
    }

    @DeleteMapping(value = "apagarObra/{id}")
    public ResponseEntity<String> apagarObra(@PathVariable int id) {
        String result = obraDeArteService.apagarObraLogicamente(id);
        if (result.equals("Obra de arte não encontrada")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "atualizarObra/{id}")
    public ResponseEntity<ObraDeArte> atualizarObra(@PathVariable int id, @RequestBody ObraDeArte obraDeArte) {
        ObraDeArte tempObra = obraDeArteService.atualizarObra(id, obraDeArte);
        return ResponseEntity.ok(tempObra);
    }
}