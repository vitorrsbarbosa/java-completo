package exercicio07.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkInDate;
	private Date checkOutDate;

	private static final SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

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

	public Long duration( ) {
//		Em dias
		long milissecondsDiff = checkOutDate.getTime() - checkInDate.getTime();
		return TimeUnit.DAYS.convert( milissecondsDiff,TimeUnit.MILLISECONDS );
	}

	public void updateDates( Date newCheckInDate, Date newCheckOutDate ) {
		Date now = new Date( );
		if( newCheckInDate.before( now ) || newCheckOutDate.before( now ) ) {
			throw new IllegalArgumentException( "Check-out date must be future dates." );
		} else if( ! newCheckOutDate.after( newCheckInDate ) ) {
			throw new IllegalArgumentException( "Check-out date must be after check-in date." );
		} else {
			setCheckInDate( newCheckInDate );
			setCheckOutDate( newCheckOutDate );
		}
	}

	@Override
	public String toString( ) {
		String sb = "Reservation: " +
				"Room " +
				roomNumber +
				", Check-in: " +
				sdf.format( checkInDate ) +
				", Check-out: " +
				sdf.format( checkOutDate ) +
				", for " +
				duration( ) +
				" nights.";
		return sb;
	}
}
