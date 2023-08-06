package l04e02.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import l04e02.exception.ReservaException;

/**
 * @class Reserva
 *        Represents a reservation with an entry and exit date.
 */
public class Reserva implements Comparable<Reserva> {
    private static final int UM_DIA = 1000 * 60 * 60 * 24;
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private Date dataEntrada;
    private Date dataSaida;

    /**
     * Constructs a new Reserva object with the given entry and exit dates.
     *
     * @param dataEntrada The entry date in the format "dd/MM/yyyy".
     * @param dataSaida   The exit date in the format "dd/MM/yyyy".
     * @throws ReservaException.DataEntradaNoPassado     If the entry date is in the past.
     * @throws ReservaException.DataSaidaAntecedeEntrada If the exit date is before the entry date.
     * @throws ReservaException.PeriodoMuitoCurto        If the reservation period is too short (less than one day).
     */
    public Reserva(String dataEntrada, String dataSaida)
            throws ReservaException.DataEntradaNoPassado, ReservaException.DataSaidaAntecedeEntrada,
            ReservaException.PeriodoMuitoCurto {

        try {
            Date entrada = SDF.parse(dataEntrada), saida = SDF.parse(dataSaida);
            if (entrada.getTime() < new Date().getTime()) {
                throw new ReservaException.DataEntradaNoPassado(entrada);
            }

            if (saida.getTime() < entrada.getTime()) {
                throw new ReservaException.DataSaidaAntecedeEntrada(entrada, saida);
            }

            if (saida.getTime() - entrada.getTime() < UM_DIA) {
                throw new ReservaException.PeriodoMuitoCurto(entrada, saida);
            }

            this.dataEntrada = entrada;
            this.dataSaida = saida;
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * Gets the entry date of the reservation.
     *
     * @return The entry date.
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Gets the exit date of the reservation.
     *
     * @return The exit date.
     */
    public Date getDataSaida() {
        return dataSaida;
    }

    /**
     * Compares this reservation with another reservation based on their exit dates.
     *
     * @param o The reservation to compare with.
     * @return -1 if this reservation's exit date is before the other reservation's exit date,
     *         1 if this reservation's exit date is after the other reservation's exit date,
     *         and 0 if both exit dates are the same.
     */
    @Override
    public int compareTo(Reserva o) {
        if (getDataSaida().getTime() < o.getDataEntrada().getTime()) {
            return -1;
        }

        if (o.getDataSaida().getTime() < getDataEntrada().getTime()) {
            return 1;
        }

        return 0;
    }

    /**
     * Prints reservation information to the standard output.
     */
    public void print_info() {
        System.out.printf("\tEntrada: %s, Saida: %s%n", SDF.format(getDataEntrada()), SDF.format(getDataSaida()));
    }

}
