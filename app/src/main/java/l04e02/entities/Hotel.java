package l04e02.entities;

import java.util.ArrayList;

import l04e02.exception.HotelExceptions;
import l04e02.exception.QuartoExceptions;
import l04e02.exception.ReservaException;

/**
 * @class Hotel
 *        Represents a hotel with rooms and reservations.
 */
public class Hotel {
    private ArrayList<Quarto> quartos;

    /**
     * Constructs a new Hotel object with an empty list of rooms.
     */
    public Hotel() {
        this.quartos = new ArrayList<>();
    }

    /**
     * Gets the list of rooms in the hotel.
     *
     * @return The list of rooms.
     */
    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    /**
     * Retrieves a room by its room number.
     *
     * @param nQuarto The room number to search for.
     * @return The Quarto object representing the room with the given number.
     * @throws HotelExceptions.QuartoNaoCriado If the room with the given number does not exist.
     */
    public Quarto getQuartoPeloN(int nQuarto) throws HotelExceptions.QuartoNaoCriado {
        for (Quarto quarto : getQuartos()) {
            if (quarto.getNQuarto() == nQuarto)
                return quarto;
        }

        throw new HotelExceptions.QuartoNaoCriado(nQuarto);
    }

    /**
     * Adds a new reservation to the specified room in the hotel with the given  entry and exit dates.
     *
     * @param nQuarto     The room number to which the reservation will be added.
     * @param dataEntrada The entry date of the reservation in the format "dd/MM/yyyy".
     * @param dataSaida   The exit date of the reservation in the format "dd/MM/yyyy".
     * @throws HotelExceptions.QuartoNaoExiste           If the specified room number is not valid (less than 0 or greater than 5).
     * @throws HotelExceptions.QuartoNaoCriado           If the room with the given number does not exist, and it is not possible to create it.
     * @throws QuartoExceptions.ReservaIndisponivel      If the reservation dates conflict with existing reservations for the room.
     * @throws ReservaException.DataEntradaNoPassado     If the entry date is in the past.
     * @throws ReservaException.DataSaidaAntecedeEntrada If the exit date is before the entry date.
     * @throws ReservaException.PeriodoMuitoCurto        If the reservation period is too short (less than one day).
     */
    public void adicionaReserva(int nQuarto, String dataEntrada, String dataSaida)
            throws HotelExceptions.QuartoNaoCriado, HotelExceptions.QuartoNaoExiste,
            QuartoExceptions.ReservaIndisponivel, ReservaException.DataEntradaNoPassado,
            ReservaException.DataSaidaAntecedeEntrada, ReservaException.PeriodoMuitoCurto {

        if (nQuarto < 0 || nQuarto > 5) {
            throw new HotelExceptions.QuartoNaoExiste(nQuarto);
        }

        try {
            Quarto quarto = getQuartoPeloN(nQuarto);
            quarto.adicionaReserva(dataEntrada, dataSaida);
        } catch (HotelExceptions.QuartoNaoCriado e) {
            Quarto quarto = new Quarto(e.getNQuarto());

            quarto.adicionaReserva(dataEntrada, dataSaida);

            getQuartos().add(quarto);
        }
    }

    /**
     * Removes a reservation from the specified room in the hotel based on the entry date.
     *
     * @param nQuarto     The room number from which the reservation will be removed.
     * @param dataEntrada The entry date of the reservation to be removed in the format "dd/MM/yyyy".
     * @throws HotelExceptions.QuartoNaoExiste       If the specified room number is not valid (less than 0 or greater than 5).
     * @throws HotelExceptions.QuartoNaoCriado       If the room with the given number does not exist.
     * @throws QuartoExceptions.ReservaNaoEncontrada If the reservation with the given entry date is not found in the room.
     */
    public void removeReserva(int nQuarto, String dataEntrada)
            throws HotelExceptions.QuartoNaoCriado, HotelExceptions.QuartoNaoExiste,
            QuartoExceptions.ReservaNaoEncontrada {
        if (nQuarto < 0 || nQuarto > 5) {
            throw new HotelExceptions.QuartoNaoExiste(nQuarto);
        }

        getQuartoPeloN(nQuarto).removeReserva(dataEntrada);
    }

    /**
     * Prints information about the hotel, including its rooms and reservations, to the standard output.
     */
    public void printInfo() {
        for (Quarto quarto : quartos) {
            if (!quarto.getReservas().isEmpty()) {
                quarto.printInfo();
            }
        }
    }
}
