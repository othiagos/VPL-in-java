package l04e02.entities;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import l04e02.exception.ReservaException;

public class ReservaTest {
    private final int UM_DIA = 1000 * 60 * 60 * 24;
    
    @Test
    @DisplayName("Data de entrada no passado")
    void DataEntradaNoPassado() {
        Date dataEntrada = new Date();
        Date dataSaida = new Date();

        dataEntrada.setTime(dataEntrada.getTime() - UM_DIA);
        dataSaida.setTime(dataSaida.getTime() + UM_DIA);

        assertThrows(ReservaException.DataEntradaNoPassado.class, () -> 
            new Reserva(Reserva.SDF.format(dataEntrada), Reserva.SDF.format(dataSaida)));
    }

    @Test
    @DisplayName("Data de saida antecede entrada")
    void DataSaidaAntecedeEntrada() {
        Date dataEntrada = new Date();
        Date dataSaida = new Date();

        dataEntrada.setTime(dataEntrada.getTime() + 2 * UM_DIA);
        dataSaida.setTime(dataSaida.getTime() + UM_DIA);

        assertThrows(ReservaException.DataSaidaAntecedeEntrada.class, () -> 
            new Reserva(Reserva.SDF.format(dataEntrada), Reserva.SDF.format(dataSaida)));
    }

    @Test
    @DisplayName("Periodo muito curto")
    void PeriodoMuitoCurto() {
        Date dataEntrada = new Date();
        Date dataSaida = new Date();

        dataEntrada.setTime(dataEntrada.getTime() + UM_DIA);
        dataSaida.setTime(dataEntrada.getTime());
        
        assertThrows(ReservaException.PeriodoMuitoCurto.class, () -> 
            new Reserva(Reserva.SDF.format(dataEntrada), Reserva.SDF.format(dataSaida)));
    }

    @Test
    @DisplayName("compareTo return 0")
    void compareTo0() throws ReservaException {
        Date data0 = new Date();
        data0.setTime(data0.getTime() + UM_DIA);

        Date data1 = new Date(data0.getTime() + UM_DIA);
        Date data2 = new Date(data1.getTime() + UM_DIA);

        Reserva r0 = new Reserva(Reserva.SDF.format(data0), Reserva.SDF.format(data2));
        Reserva r1 = new Reserva(Reserva.SDF.format(data1), Reserva.SDF.format(data2));

        assertEquals(0, r0.compareTo(r1));
    }


    @Test
    @DisplayName("compareTo return -1")
    void compareTo1() throws ReservaException {
        Date data0 = new Date();
        data0.setTime(data0.getTime() + UM_DIA);

        Date data1 = new Date(data0.getTime() + UM_DIA);
        Date data2 = new Date(data1.getTime() + UM_DIA);
        Date data3 = new Date(data2.getTime() + UM_DIA);

        Reserva r0 = new Reserva(Reserva.SDF.format(data0), Reserva.SDF.format(data1));
        Reserva r1 = new Reserva(Reserva.SDF.format(data2), Reserva.SDF.format(data3));

        assertEquals(-1, r0.compareTo(r1));
    }

    @Test
    @DisplayName("compareTo return 1")
    void compareTo2() throws ReservaException {
        Date data0 = new Date();
        data0.setTime(data0.getTime() + UM_DIA);

        Date data1 = new Date(data0.getTime() + UM_DIA);
        Date data2 = new Date(data1.getTime() + UM_DIA);
        Date data3 = new Date(data2.getTime() + UM_DIA);

        Reserva r0 = new Reserva(Reserva.SDF.format(data0), Reserva.SDF.format(data1));
        Reserva r1 = new Reserva(Reserva.SDF.format(data2), Reserva.SDF.format(data3));

        assertEquals(1, r1.compareTo(r0));
    }
    
}
