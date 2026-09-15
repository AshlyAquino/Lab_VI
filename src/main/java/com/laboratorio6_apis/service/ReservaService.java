package com.laboratorio6_apis.service;

import com.laboratorio6_apis.model.Reserva;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    private List<Reserva> reservas = new ArrayList<>();

    private Long siguienteId = 1L;

    // Crear reserva
    public Reserva crearReserva(Reserva reserva) {

        reserva.setId(siguienteId);
        siguienteId++;

        reservas.add(reserva);

        return reserva;
    }

    // Consultar reservas
    public List<Reserva> consultarReservas() {
        return reservas;
    }

    // Consultar reserva por ID
    public Reserva consultarPorId(Long id) {

        for (Reserva reserva : reservas) {

            if (reserva.getId().equals(id)) {
                return reserva;
            }
        }

        return null;
    }

    // Actualizar reserva
    public Reserva actualizarReserva(Long id, Reserva datos) {

        Reserva reserva = consultarPorId(id);

        if (reserva != null) {

            reserva.setNombreCliente(datos.getNombreCliente());
            reserva.setHabitacion(datos.getHabitacion());
            reserva.setFechaEntrada(datos.getFechaEntrada());
            reserva.setFechaSalida(datos.getFechaSalida());
            reserva.setEstado(datos.getEstado());

            return reserva;
        }

        return null;
    }

    // Cancelar reserva
    public boolean cancelarReserva(Long id) {

        Reserva reserva = consultarPorId(id);

        if (reserva != null) {

            reserva.setEstado("CANCELADA");

            return true;
        }

        return false;
    }
}