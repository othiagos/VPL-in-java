package l04e02.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import l04e02.exception.HotelExceptions;
import l04e02.exception.QuartoExceptions;
import l04e02.exception.ReservaException;

import org.junit.jupiter.api.DisplayName;

public class HotelTest {
    private final int UM_DIA = 1000 * 60 * 60 * 24;
    
    @Test
    @DisplayName("get quarto pelo numero")
    void getQuartoPeloN() throws ReservaException, QuartoExceptions, HotelExceptions {
        Hotel hotel = new Hotel();

        hotel.getQuartos().add(new Quarto(2));
        hotel.getQuartos().add(new Quarto(0));
        hotel.getQuartos().add(new Quarto(1));

        assertEquals(0, hotel.getQuartoPeloN(0).getNQuarto());
        assertEquals(1, hotel.getQuartoPeloN(1).getNQuarto());
        assertEquals(2, hotel.getQuartoPeloN(2).getNQuarto());
    }

    @Test
    @DisplayName("Quarto nao criado")
    void quartoNaoCriado() throws ReservaException, QuartoExceptions, HotelExceptions {
        Hotel hotel = new Hotel();

        hotel.getQuartos().add(new Quarto(2));
        hotel.getQuartos().add(new Quarto(0));
        hotel.getQuartos().add(new Quarto(1));

        assertThrows(HotelExceptions.QuartoNaoCriado.class, () -> 
            hotel.getQuartoPeloN(3));
    }

    @Test
    @DisplayName("Adiciona reserva")
    void adicionaReserva() throws HotelExceptions, QuartoExceptions, ReservaException {
        Hotel hotel = new Hotel();

        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);

        hotel.adicionaReserva(0, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(1, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(2, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(3, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(4, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(5, Reserva.SDF.format(data1), Reserva.SDF.format(data2));

        assertTrue(hotel.getQuartos().size() == 6);
    }

    @Test
    @DisplayName("Quarto nao existe")
    void QuartoNaoExiste() throws HotelExceptions, QuartoExceptions, ReservaException {
        Hotel hotel = new Hotel();

        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);

        assertThrows(HotelExceptions.QuartoNaoExiste.class, () -> 
            hotel.adicionaReserva(6, Reserva.SDF.format(data1), Reserva.SDF.format(data2)));
    }

    @Test
    @DisplayName("Remove reserva")
    void removeReserva() throws HotelExceptions, QuartoExceptions, ReservaException {
        Hotel hotel = new Hotel();

        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);

        hotel.adicionaReserva(0, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(1, Reserva.SDF.format(data1), Reserva.SDF.format(data2));

        hotel.removeReserva(1, Reserva.SDF.format(data1));

        assertTrue(hotel.getQuartoPeloN(1).getReservas().size() == 0);
    }

    @Test
    @DisplayName("Quarto nao existe")
    void quartoNaoExiste() throws HotelExceptions, QuartoExceptions, ReservaException {
        Hotel hotel = new Hotel();

        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);

        hotel.adicionaReserva(0, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(1, Reserva.SDF.format(data1), Reserva.SDF.format(data2));

        assertThrows(HotelExceptions.QuartoNaoExiste.class, () -> 
            hotel.removeReserva(6, Reserva.SDF.format(data1)));
    }

    @Test
    @DisplayName("Remove reserva quarto nao criado")
    void removeReservaQuartoNaoCriado() throws HotelExceptions, QuartoExceptions, ReservaException {
        Hotel hotel = new Hotel();

        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);

        hotel.adicionaReserva(0, Reserva.SDF.format(data1), Reserva.SDF.format(data2));
        hotel.adicionaReserva(1, Reserva.SDF.format(data1), Reserva.SDF.format(data2));

        assertThrows(HotelExceptions.QuartoNaoCriado.class, () -> 
            hotel.removeReserva(2, Reserva.SDF.format(data1)));
    }
}
