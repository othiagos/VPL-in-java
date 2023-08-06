package l04e02.entities;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

import l04e02.exception.QuartoExceptions;
import l04e02.exception.ReservaException;

import org.junit.jupiter.api.DisplayName;

public class QuartoTest {
    private final int UM_DIA = 1000 * 60 * 60 * 24;

    @Test
    @DisplayName("Inserir reserva 3 1 2")
    void adicionaReservaDesordenado() throws ReservaException, QuartoExceptions {
        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);
        Date data3 = new Date(now.getTime() + 3 * UM_DIA);
        Date data4 = new Date(now.getTime() + 4 * UM_DIA);
        Date data5 = new Date(now.getTime() + 5 * UM_DIA);
        Date data6 = new Date(now.getTime() + 6 * UM_DIA);

        Quarto quarto = new Quarto(0);

        quarto.adicionaReserva(Reserva.SDF.format(data5), Reserva.SDF.format(data6)); //2
        quarto.adicionaReserva(Reserva.SDF.format(data1), Reserva.SDF.format(data2)); //0
        quarto.adicionaReserva(Reserva.SDF.format(data3), Reserva.SDF.format(data4)); //1

        assertEquals(Reserva.SDF.format(data1), Reserva.SDF.format(quarto.getReservas().get(0).getDataEntrada()));
        assertEquals(Reserva.SDF.format(data3), Reserva.SDF.format(quarto.getReservas().get(1).getDataEntrada()));
        assertEquals(Reserva.SDF.format(data5), Reserva.SDF.format(quarto.getReservas().get(2).getDataEntrada()));
    }

    @Test
    @DisplayName("Inserir reserva 1 2 3")
    void adicionaReservaOrdenado() throws ReservaException, QuartoExceptions {
        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);
        Date data3 = new Date(now.getTime() + 3 * UM_DIA);
        Date data4 = new Date(now.getTime() + 4 * UM_DIA);
        Date data5 = new Date(now.getTime() + 5 * UM_DIA);
        Date data6 = new Date(now.getTime() + 6 * UM_DIA);

        Quarto quarto = new Quarto(0);

        quarto.adicionaReserva(Reserva.SDF.format(data1), Reserva.SDF.format(data2)); //0
        quarto.adicionaReserva(Reserva.SDF.format(data3), Reserva.SDF.format(data4)); //1
        quarto.adicionaReserva(Reserva.SDF.format(data5), Reserva.SDF.format(data6)); //2

        assertEquals(Reserva.SDF.format(data1), Reserva.SDF.format(quarto.getReservas().get(0).getDataEntrada()));
        assertEquals(Reserva.SDF.format(data3), Reserva.SDF.format(quarto.getReservas().get(1).getDataEntrada()));
        assertEquals(Reserva.SDF.format(data5), Reserva.SDF.format(quarto.getReservas().get(2).getDataEntrada()));
    }

    @Test
    @DisplayName("ReservaIndisponivel")
    void ReservaIndisponivel() throws ReservaException, QuartoExceptions {
        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);
        Date data3 = new Date(now.getTime() + 3 * UM_DIA);
        Date data4 = new Date(now.getTime() + 4 * UM_DIA);
        Date data5 = new Date(now.getTime() + 5 * UM_DIA);
        Date data6 = new Date(now.getTime() + 6 * UM_DIA);
        Date data7 = new Date(now.getTime() + 7 * UM_DIA);

        Quarto quarto = new Quarto(0);

        quarto.adicionaReserva(Reserva.SDF.format(data1), Reserva.SDF.format(data2)); //0
        quarto.adicionaReserva(Reserva.SDF.format(data3), Reserva.SDF.format(data4)); //1
        quarto.adicionaReserva(Reserva.SDF.format(data5), Reserva.SDF.format(data6)); //2

        assertThrows(QuartoExceptions.ReservaIndisponivel.class, () -> 
            quarto.adicionaReserva(Reserva.SDF.format(data4), Reserva.SDF.format(data7)));
    }

    @Test
    @DisplayName("Remove reserva")
    void removeReserva() throws ReservaException, QuartoExceptions {
        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);
        Date data3 = new Date(now.getTime() + 3 * UM_DIA);
        Date data4 = new Date(now.getTime() + 4 * UM_DIA);
        Date data5 = new Date(now.getTime() + 5 * UM_DIA);
        Date data6 = new Date(now.getTime() + 6 * UM_DIA);

        Quarto quarto = new Quarto(0);

        quarto.adicionaReserva(Reserva.SDF.format(data1), Reserva.SDF.format(data2)); //0
        quarto.adicionaReserva(Reserva.SDF.format(data3), Reserva.SDF.format(data4)); //1
        quarto.adicionaReserva(Reserva.SDF.format(data5), Reserva.SDF.format(data6)); //2

        quarto.removeReserva(Reserva.SDF.format(data3));

        assertEquals(Reserva.SDF.format(data1), Reserva.SDF.format(quarto.getReservas().get(0).getDataEntrada()));
        assertEquals(Reserva.SDF.format(data5), Reserva.SDF.format(quarto.getReservas().get(1).getDataEntrada()));
    }

    @Test
    @DisplayName("Remove reserva")
    void ReservaNaoEncontrada() throws ReservaException, QuartoExceptions {
        Date now = new Date();

        Date data1 = new Date(now.getTime() + 1 * UM_DIA);
        Date data2 = new Date(now.getTime() + 2 * UM_DIA);

        Quarto quarto = new Quarto(0);

        quarto.adicionaReserva(Reserva.SDF.format(data1), Reserva.SDF.format(data2)); //0


        assertThrows(QuartoExceptions.ReservaNaoEncontrada.class, () -> 
            quarto.removeReserva(Reserva.SDF.format(data2)));
    }
    
}
