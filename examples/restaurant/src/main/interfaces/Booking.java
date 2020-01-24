package src.main.interfaces;

import java.time.LocalDateTime;

import src.main.dto.booking.BookingDTO;
import src.main.dto.booking.TableDTO;

import java.rmi.RemoteException;

public interface Booking {

    public BookingDTO placeBooking(TableDTO tableDTO, LocalDateTime dateAndTime, int amountOfPeople) throws RemoteException;

    public void deleteBooking(BookingDTO bookingDTO) throws RemoteException;

    public BookingDTO modifyBooking(BookingDTO bookingDTO) throws RemoteException;

}