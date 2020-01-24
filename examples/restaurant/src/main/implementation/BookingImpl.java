package src.main.implementation;

import src.main.interfaces.Booking;
import src.main.dto.booking.BookingDTO;
import src.main.dto.booking.TableDTO;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.rmi.RemoteException;

public class BookingImpl implements Booking {

    public BookingDTO placeBooking(TableDTO tableDTO, LocalDateTime dateAndTime, int amountOfPeople) throws RemoteException {
        if (tableDTO.getTableNumber() < amountOfPeople) {
            System.err.println("This table is not suitable, it is too small");
            return;
        }

        Optional<BookingDTO> bookingDTOOptional = BookingDTO.getBookingDTOList().stream()
                .filter(b -> b.getDateAndTime().isEqual(dateAndTime))
                .filter(b -> b.getTable().equals(tableDTO))
                .findAny();

        if (bookingDTOOptional.isPresent()) {
            System.err.println("The table is booked, please choose a different one");
            return;
        }

        BookingDTO bookingDTO = new BookingDTO(tableDTO, dateAndTime, amountOfPeople);

        return bookingDTO;

    }

    public void deleteBooking(BookingDTO bookingDTO) throws RemoteException {
        BookingDTO.getBookingDTOList().remove(bookingDTO);
    }

    public BookingDTO modifyBooking(BookingDTO bookingDTO) throws RemoteException {
        Optional<BookingDTO> bookingDTOOptional = BookingDTO.getBookingDTOList().stream()
                .filter(b -> b.equals(bookingDTO))
                .findAny();

        if (!bookingDTOOptional.isPresent()) {
            System.err.println("There is no such booking");
            return;
        }

        BookingDTO oldBooking = bookingDTOOptional.get();

        if (bookingDTO.getTable() != null)
            oldBooking.setTable(bookingDTO.getTable());

        if (bookingDTO.getDateAndTime() != null)
            oldBooking.setDateAndTime(bookingDTO.getDateAndTime());


        if (bookingDTO.getAmountOfPeople() != 0)
            oldBooking.setAmountOfPeople(bookingDTO.getAmountOfPeople());

        return bookingDTO;
    }

}