package l04e02;

import java.util.Scanner;

import l04e02.entities.Hotel;
import l04e02.exception.HotelExceptions;
import l04e02.exception.QuartoExceptions;
import l04e02.exception.ReservaException;

public class App {
    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            Hotel hotel = new Hotel();

            while (sc.hasNext()) {
                String op = sc.next();

                int nQuarto;
                String dataEntrada, dataSaida;

                switch (op.charAt(0)) {
                    case 'a':
                        nQuarto = sc.nextInt();
                        dataEntrada = sc.next();
                        dataSaida = sc.next();

                        try {
                            hotel.adicionaReserva(nQuarto, dataEntrada, dataSaida);
                        } catch (HotelExceptions | QuartoExceptions | ReservaException e) {
                            System.err.println(e.getMessage());
                        }
                        
                        break;

                    case 'r':
                        nQuarto = sc.nextInt();
                        dataEntrada = sc.next();

                        try {
                            hotel.removeReserva(nQuarto, dataEntrada);
                        } catch (HotelExceptions | QuartoExceptions e) {
                            System.err.println(e.getMessage());
                        }
                        
                        break;

                    case 'p':
                        hotel.printInfo();
                        break;
                }
            }
        }
    }
}
