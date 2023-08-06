package l04e02.exception;

/**
 * @class QuartoExceptions
 * Custom abstract exception class for handling room-related exceptions.
 */
public abstract class QuartoExceptions extends Exception {
    public QuartoExceptions(String msg) {
        super(msg);
    }

    /**
     * Constructs a new QuartoExceptions object with the given error message.
     *
     * @param msg The error message for the exception.
     */
    public static class ReservaNaoEncontrada extends QuartoExceptions {
        private int nQuarto;
        private String dataInicio;

        /**
         * Constructs a new ReservaNaoEncontrada object with the given room number and entry date.
         *
         * @param nQuarto    The room number for which the reservation was not found.
         * @param dataInicio The entry date of the reservation that was not found in the room.
         */
        public ReservaNaoEncontrada(int nQuarto, String dataInicio) {
            super("Reserva nao encontrada");
            this.nQuarto = nQuarto;
            this.dataInicio = dataInicio;
        }

        /**
         * Gets the room number for which the reservation was not found.
         *
         * @return The room number.
         */
        public int getNQuarto() {
            return nQuarto;
        }

        /**
         * Gets the entry date of the reservation that was not found in the room.
         *
         * @return The entry date.
         */
        public String getDataInicio() {
            return dataInicio;
        }
    }

    /**
     * @class ReservaIndisponivel
     * Represents an exception when a reservation is not available due to conflicting dates.
     */
    public static class ReservaIndisponivel extends QuartoExceptions {
        private String dataInicio;
        private String dataSaida;

        /**
         * Constructs a new ReservaIndisponivel object with the given entry and exit dates.
         *
         * @param dataInicio The entry date of the conflicting reservation in the format "dd/MM/yyyy".
         * @param dataSaida  The exit date of the conflicting reservation in the format "dd/MM/yyyy".
         */
        public ReservaIndisponivel(String dataInicio, String dataSaida) {
            super("Existe uma reserva em alguns dos dias do periodo");
            this.dataInicio = dataInicio;
            this.dataSaida = dataSaida;
        }

        /**
         * Gets the entry date of the conflicting reservation.
         *
         * @return The entry date.
         */
        public String getDataInicio() {
            return dataInicio;
        }

        /**
         * Gets the exit date of the conflicting reservation.
         *
         * @return The exit date.
         */
        public String getDataSaida() {
            return dataSaida;
        }
    }
}
