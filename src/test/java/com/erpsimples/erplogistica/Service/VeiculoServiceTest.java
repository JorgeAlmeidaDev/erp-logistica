package com.erpsimples.erplogistica.Service;

import com.erpsimples.erplogistica.Entity.Veiculo;
import com.erpsimples.erplogistica.Repository.VeiculoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class VeiculoServiceTest {

    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoService veiculoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC1234");
        veiculo.setMarca("Fiat");
        veiculo.setTipo("Caminhão");

        when(veiculoRepository.save(any(Veiculo.class))).thenReturn(veiculo);

        Veiculo salvo = veiculoService.salvar(veiculo);

        assertNotNull(salvo);
        assertEquals("Fiat", salvo.getMarca());
        verify(veiculoRepository, times(1)).save(veiculo);
    }
}
