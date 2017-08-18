package com.everis.alicante.becajava.domain;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class BookingTest {

	private Booking booking;
	private Date date = new Date();
	private Client expectedClient = new Client();
	private Integer idbooking = 1; 
	private Parkingplace expectedParkingplace = new Parkingplace();
	private Vehicle expectedVehicle = new Vehicle();

	@Before
	public void init() {
		this.booking = new Booking();
		this.booking.setBookingdate(date);
		this.booking.setClient(expectedClient);
		this.booking.setIdbooking(1);
		this.booking.setParkingplace(expectedParkingplace);
		this.booking.setVehicle(expectedVehicle);

	}

	@Test
	public void testGetClient() {
		// Act
		final Client result = this.booking.getClient();

		// Assert
		Assert.assertEquals(this.expectedClient, result);
	}

	@Test
	public void testSetClient() {
		// Arrange
		final Booking booking = new Booking();
		// Act
		booking.setClient(expectedClient);
		// Assert
		Assert.assertEquals(this.expectedClient, booking.getClient());

	}

	@Test
	public void testGetIdbooking() {
		// Act
		Integer result = this.booking.getIdbooking();
		// Assert
		Assert.assertEquals(new Integer(this.idbooking), result);

	}

	@Test
	public void testSetIdbooking() {
		// Arrange
		final Booking booking = new Booking();
		// Act
		booking.setIdbooking(1);
		// Assert
		Assert.assertEquals(1, booking.getIdbooking());

	}

	@Test
	public void testGetBookingdate() {
		// Act
		Date result = this.booking.getBookingdate();

		// Assert
		Assert.assertEquals(this.date, result);

	}

	@Test
	public void testSetBookingdate() {
		// Arrange
		final Booking booking = new Booking();
		// Act
		booking.setBookingdate(date);
		// Assert
		Assert.assertEquals(this.date, booking.getBookingdate());

	}

	@Test
	public void testGetParkingplace() {
		// Act
		Parkingplace result = this.booking.getParkingplace();

		// Assert
		Assert.assertEquals(this.expectedParkingplace, result);

	}

	@Test
	public void testSetParkingplace() {
		// Arrange
		final Booking booking = new Booking();
		// Act
		booking.setParkingplace(expectedParkingplace);
		// Assert
		Assert.assertEquals(this.expectedParkingplace, booking.getParkingplace());

	}

	@Test
	public void testGetVehicle() {
		// Act
		Vehicle result = this.booking.getVehicle();

		// Assert
		Assert.assertEquals(this.expectedVehicle, result);

	}

	@Test
	public void testSetVehicle() {
		// Arrange
		final Booking booking = new Booking();
		// Act
		booking.setVehicle(expectedVehicle);
		// Assert
		Assert.assertEquals(this.expectedVehicle, booking.getVehicle());

	}

	@Test
	public void testToString() {
		// Arrange
		String string = "Reserva a fecha " + this.date + " , del cliente=" + this.expectedClient.getName()
				+ " , para la plaza " + this.expectedParkingplace.getParkingnumber() + ", y el vehiculo con matricula "
				+ this.expectedVehicle.getVehicleplate() + "]";
		// Act
		String result = booking.toString();
		// Assert
		Assert.assertEquals(string, result);

	}

}
