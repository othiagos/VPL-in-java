package l04e02.entities;

import java.util.ArrayList;

import l04e02.exception.QuartoExceptions;
import l04e02.exception.ReservaException;

/**
 * @class Quarto
 *        Represents a room with reservations.
 */
public class Quarto {
    private Integer nQuarto;
    private ArrayList<Reserva> reservas;

    /**
     * Constructs a new Quarto object with the given room number.
     *
     * @param nQuarto The room number.
     */
    public Quarto(int nQuarto) {
        this.nQuarto = nQuarto;
        this.reservas = new ArrayList<>();
    }

    /**
     * Gets the room number.
     *
     * @return The room number.
     */
    public Integer getNQuarto() {
        return nQuarto;
    }

    /**
     * Gets the list of reservations for this room.
     *
     * @return The list of reservations.
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Adds a new reservation to the room with the given entry and exit dates,
     * preserving the order of entry dates
     *
     * @param dataEntrada The entry date of the reservation in the format "dd/MM/yyyy".
     * @param dataSaida   The exit date of the reservation in the format "dd/MM/yyyy".
     * @throws QuartoExceptions.ReservaIndisponivel      If the reservation dates conflict with existing reservations for the room.
     * @throws ReservaException.DataEntradaNoPassado     If the entry date is in the past.
     * @throws ReservaException.DataSaidaAntecedeEntrada If the exit date is before the entry date.
     * @throws ReservaException.PeriodoMuitoCurto        If the reservation period is too short (less than one day).
     */
    public void adicionaReserva(String dataEntrada, String dataSaida)
            throws QuartoExceptions.ReservaIndisponivel, ReservaException.DataEntradaNoPassado,
            ReservaException.DataSaidaAntecedeEntrada, ReservaException.PeriodoMuitoCurto {

        if (getReservas().isEmpty()) {
            getReservas().add(new Reserva(dataEntrada, dataSaida));
        } else {
            Reserva r = new Reserva(dataEntrada, dataSaida);

            for (int i = 0; i < getReservas().size(); i++) {
                if (getReservas().get(i).compareTo(r) == -1)
                    continue;

                if (getReservas().get(i).compareTo(r) == 0)
                    throw new QuartoExceptions.ReservaIndisponivel(dataEntrada, dataSaida);

                getReservas().add(i, r);
                break;
            }

            if (!getReservas().contains(r))
                getReservas().add(r);
        }
    }

    /**
     * Removes a reservation from the room based on the entry date.
     *
     * @param data_entrada The entry date of the reservation to be removed in the format "dd/MM/yyyy".
     * @throws QuartoExceptions.ReservaNaoEncontrada If the reservation with the given entry date is not found.
     */
    public void removeReserva(String data_entrada) throws QuartoExceptions.ReservaNaoEncontrada {
        boolean remove = false;

        for (Reserva reserva : getReservas()) {
            if (Reserva.SDF.format(reserva.getDataEntrada()).equals(data_entrada)) {
                getReservas().remove(reserva);
                remove = true;
                break;
            }
        }

        if (!remove)
            throw new QuartoExceptions.ReservaNaoEncontrada(getNQuarto(), data_entrada);
    }

    /**
     * Prints information about the room and its reservations to the standard output.
     */
    public void printInfo() {
        System.out.printf("Quarto %d ---------%n", getNQuarto());

        for (Reserva reserva : getReservas()) {
            reserva.print_info();
        }

        System.out.println("------------------");
    }

}
