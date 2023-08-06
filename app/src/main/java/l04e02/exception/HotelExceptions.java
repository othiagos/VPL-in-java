package l04e02.exception;

/**
 * @class HotelExceptions
 * Custom abstract exception class for handling hotel-related exceptions.
 */
public abstract class HotelExceptions extends Exception {

    /**
     * Constructs a new HotelExceptions object with the given error message.
     *
     * @param msg The error message for the exception.
     */
    public HotelExceptions(String msg) {
        super(msg);
    }

    /**
     * @class QuartoNaoExiste
     * Represents an exception when the specified room number does not exist in the collection.
     */
    public static class QuartoNaoExiste extends HotelExceptions {
        private int nQuarto;

        /**
         * Constructs a new QuartoNaoExiste object with the given room number.
         *
         * @param nQuarto The room number that does not exist in the collection.
         */
        public QuartoNaoExiste(int nQuarto) {
            super("Numero do quarto informado nao pertence a colecao");
            this.nQuarto = nQuarto;
        }
        
        /**
         * Gets the room number that does not exist in the collection.
         *
         * @return The room number.
         */
        public int getNQuarto() {
            return nQuarto;
        }
    }

    /**
     * @class QuartoNaoCriado
     * Represents an exception when a room has not been added to the list.
     */
    public static class QuartoNaoCriado extends HotelExceptions {
        private int nQuarto;

        /**
         * Constructs a new QuartoNaoCriado object with the given room number.
         *
         * @param nQuarto The room number that has not been added to the list.
         */
        public QuartoNaoCriado(int nQuarto) {
            super("Quarto ainda nao foi adicionado a lista");
            this.nQuarto = nQuarto;
        }  

        /**
         * Gets the room number that has not been added to the list.
         *
         * @return The room number.
         */
        public int getNQuarto() {
            return nQuarto;
        }
    }

}
