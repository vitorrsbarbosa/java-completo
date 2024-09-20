package exercicio07.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkInDate;
	private Date checkOutDate;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
		setCheckInDate( newCheckInDate );
		setCheckOutDate( newCheckOutDate );
	}

	@Override
	public String toString( ) {
		StringBuilder sb = new StringBuilder();
		sb.append( "Reservation:\n" );
		sb.append( "Room [" );
		sb.append( roomNumber );
		sb.append( "\n, Check-in no dia" );
		sb.append( sdf.format( checkInDate ) );
		sb.append( "\n, Check-out no dia " );
		sb.append( sdf.format( checkOutDate ) );
		sb.append( "\n totalizando " );
		sb.append( duration() );
		sb.append( " \n]" );
		return sb.toString();
	}
}
