package src.main.dto.booking;

import java.time.LocalDateTime;
import src.main.dto.order.OrderDTO;

import java.util.List;
import java.util.ArrayList;

public class BookingDTO {

    private static List<BookingDTO> bookingDTOList = new ArrayList<>();

    public TableDTO table;
    public int amountOfPerson;
    private LocalDateTime dateAndTime;

    public BookingDTO(TableDTO table, int amountOfPerson, LocalDateTime dateAndTime) {
        this.table = table;
        this.amountOfPerson = amountOfPerson;
        this.dateAndTime = dateAndTime;

        bookingDTOList.add(this);
    }

    public TableDTO getTable() {
        return table;
    }

    public void setTable(TableDTO table) {
        this.table = table;
    }

    public int getAmountOfPerson() {
        return amountOfPerson;
    }

    public void setAmountOfPerson(int amountOfPerson) {
        this.amountOfPerson = amountOfPerson;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public static List<BookingDTO> getBookingDTOList() {
        return bookingDTOList;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BookingDTO that = (BookingDTO) object;
        return java.util.Objects.equals(table, that.table) &&
                java.util.Objects.equals(dateAndTime, that.dateAndTime);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), table, dateAndTime);
    }
}