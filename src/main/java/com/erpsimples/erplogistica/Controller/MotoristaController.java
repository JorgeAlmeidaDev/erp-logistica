package com.erpsimples.erplogistica.Controller;

import com.erpsimples.erplogistica.Entity.Motorista;
import com.erpsimples.erplogistica.Repository.MotoristaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motoristas")
public class MotoristaController {

    private final MotoristaRepository motoristaRepository;

    public MotoristaController(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @GetMapping
    public String listarMotoristas(Model model) {
        model.addAttribute("motoristas", motoristaRepository.findAll());
        return "motoristas/listar";
    }

    @GetMapping("/novo")
    public String novoMotorista(Model model) {
        model.addAttribute("motorista", new Motorista());
        return "motoristas/form";
    }

    @PostMapping
    public String salvarMotorista(@ModelAttribute Motorista motorista) {
        motoristaRepository.save(motorista);
        return "redirect:/motoristas";
    }

    @GetMapping("/editar/{id}")
    public String editarMotorista(@PathVariable Long id, Model model) {
        Motorista motorista = motoristaRepository.findById(id).orElseThrow();
        model.addAttribute("motorista", motorista);
        return "motoristas/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMotorista(@PathVariable Long id) {
        motoristaRepository.deleteById(id);
        return "redirect:/motoristas";
    }
}
