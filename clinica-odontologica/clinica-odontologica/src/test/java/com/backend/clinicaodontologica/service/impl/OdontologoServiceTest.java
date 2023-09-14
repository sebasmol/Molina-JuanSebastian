package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    void deberiaInsertarUnOdontologoDeNombreJuanConId1() {
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("CG-8374568", "Juan", "Perez");

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertEquals("Juan", odontologoSalidaDto.getNombre());
        assertEquals(1, odontologoSalidaDto.getId());
    }

    @Test
    @Order(2)
    void deberiaRetornarseUnaListaDeOdontologos() {
        assertTrue(odontologoService.listarOdontologos().size() > 0);
    }


}
