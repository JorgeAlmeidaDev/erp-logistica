package com.erpsimples.erplogistica.Controller;

import com.erpsimples.erplogistica.Entity.Veiculo;
import com.erpsimples.erplogistica.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) {
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // ou lance uma exceção customizada
        }
        Veiculo salvo = veiculoService.salvar(veiculo);
        return ResponseEntity.ok(salvo);
    }


    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> buscarVeiculo(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletar(id);
    }
}
