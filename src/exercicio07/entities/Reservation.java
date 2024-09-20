package exercicio07.entities;

import java.util.Date;

public class Reservation {
	private Integer roomNumber;
	private Date checkInDate;
	private Date checkOutDate;

	public Reservation( ) {
	}

	public Reservation( Integer roomNumber, Date checkInDate, Date checkOutDate ) {
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public Integer getRoomNumber( ) {
		return roomNumber;
	}

	public void setRoomNumber( Integer roomNumber ) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckInDate( ) {
		return checkInDate;
	}

	public void setCheckInDate( Date checkInDate ) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate( ) {
		return checkOutDate;
	}

	public void setCheckOutDate( Date checkOutDate ) {
		this.checkOutDate = checkOutDate;
	}

	public Integer duration( ) {
		return getCheckOutDate( ).toInstant( ).getNano( ) - checkInDate.toInstant( ).getNano( );
	}

	public void updateDates( Date newCheckInDate, Date newCheckOutDate ) {
		setCheckInDate( newCheckInDate );
		setCheckOutDate( newCheckOutDate );
	}
}
