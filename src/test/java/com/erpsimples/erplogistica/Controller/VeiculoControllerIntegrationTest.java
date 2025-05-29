package com.erpsimples.erplogistica.Controller;

import com.erpsimples.erplogistica.Entity.Veiculo;
import com.erpsimples.erplogistica.Repository.VeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class VeiculoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // Limpa o banco de dados de teste antes de cada teste
        veiculoRepository.deleteAll();
    }

    @Test
    void testCriarVeiculo() throws Exception {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("XYZ9876");
        veiculo.setMarca("Scania");
        veiculo.setTipo("Caminhão");

        mockMvc.perform(post("/veiculos/veiculos") // cuidado: aqui segue o path do teu @PostMapping!
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(veiculo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa").value("XYZ9876"))
                .andExpect(jsonPath("$.marca").value("Scania"));
    }

    @Test
    void testListarVeiculos() throws Exception {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("AAA1111");
        veiculo.setMarca("Ford");
        veiculo.setTipo("Caminhão");
        veiculoRepository.save(veiculo);

        mockMvc.perform(get("/veiculos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa").value("AAA1111"));
    }
}
