package l04e02.exception;

import java.util.Date;

/**
 * @class ReservaException
 * Custom abstract exception class for handling reservation-related exceptions.
 */
public abstract class ReservaException extends Exception {

    /**
     * Constructs a new ReservaException object with the given error message.
     *
     * @param msg The error message for the exception.
     */
    public ReservaException(String msg) {
        super(msg);
    }

    /**
     * @class DataEntradaNoPassado
     * Represents an exception when the entry date is in the past.
     */
    public static class DataEntradaNoPassado extends ReservaException {
        private Date dataEntrada;

        /**
         * Constructs a new DataEntradaNoPassado object with the given entry date.
         *
         * @param dataEntrada The entry date that is in the past.
         */
        public DataEntradaNoPassado(Date dataEntrada) {
            super("Data de entrada esta no passado");
            this.dataEntrada = dataEntrada;
        }

        /**
         * Gets the entry date that is in the past.
         *
         * @return The entry date.
         */
        public Date getDataEntrada() {
            return dataEntrada;
        }
    }

    /**
     * @class DataSaidaAntecedeEntrada
     * Represents an exception when the exit date is before the entry date.
     */
    public static class DataSaidaAntecedeEntrada extends ReservaException {
        private Date dataEntrada;
        private Date dataSaida;

        /**
         * Constructs a new DataSaidaAntecedeEntrada object with the given entry and exit dates.
         *
         * @param dataEntrada The entry date of the reservation.
         * @param dataSaida   The exit date that is before the entry date.
         */
        public DataSaidaAntecedeEntrada(Date dataEntrada, Date dataSaida) {
            super("Data saida nao pode ser menor que a data entrada");
            this.dataEntrada = dataEntrada;
            this.dataSaida = dataSaida;
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
         * Gets the exit date that is before the entry date.
         *
         * @return The exit date.
         */
        public Date getDataSaida() {
            return dataSaida;
        }

    }

    /**
     * @class PeriodoMuitoCurto
     * Represents an exception when the reservation period is too short (less than one day).
     */
    public static class PeriodoMuitoCurto extends ReservaException {
        private Date dataEntrada;
        private Date dataSaida;

        /**
         * Constructs a new PeriodoMuitoCurto object with the given entry and exit dates.
         *
         * @param dataEntrada The entry date of the reservation.
         * @param dataSaida   The exit date that results in a period less than one day.
         */
        public PeriodoMuitoCurto(Date dataEntrada, Date dataSaida) {
            super("Data saida nao pode ser menor que a data entrada");
            this.dataEntrada = dataEntrada;
            this.dataSaida = dataSaida;
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
         * Gets the exit date that results in a period less than one day.
         *
         * @return The exit date.
         */
        public Date getDataSaida() {
            return dataSaida;
        }
    }
}
