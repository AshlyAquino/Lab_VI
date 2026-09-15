package com.laboratorio6_apis.controller;

import com.laboratorio6_apis.model.Reserva;
import com.laboratorio6_apis.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // POST - Crear reserva
    @PostMapping
    public ResponseEntity<Reserva> crearReserva(
            @RequestBody Reserva reserva) {

        Reserva nuevaReserva =
                reservaService.crearReserva(reserva);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nuevaReserva);
    }

    // GET - Consultar reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> consultarReservas() {

        return ResponseEntity.ok(
                reservaService.consultarReservas()
        );
    }

    // GET - Consultar reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> consultarPorId(
            @PathVariable Long id) {

        Reserva reserva =
                reservaService.consultarPorId(id);

        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        }

        return ResponseEntity.notFound().build();
    }

    // PUT - Actualizar reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(
            @PathVariable Long id,
            @RequestBody Reserva datos) {

        Reserva reservaActualizada =
                reservaService.actualizarReserva(id, datos);

        if (reservaActualizada != null) {
            return ResponseEntity.ok(reservaActualizada);
        }

        return ResponseEntity.notFound().build();
    }

    // PATCH - Cancelar reserva
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Reserva> cancelarReserva(
            @PathVariable Long id) {

        boolean cancelada =
                reservaService.cancelarReserva(id);

        if (cancelada) {

            Reserva reserva =
                    reservaService.consultarPorId(id);

            return ResponseEntity.ok(reserva);
        }

        return ResponseEntity.notFound().build();
    }
}