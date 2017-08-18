package com.everis.alicante.becajava.domain;


import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClientTest {
	
	private Client client;
	private Integer idclient = 1;
	private String name;
	private String nif;
	private String surname;
	private String telephone;
	private Set<Booking> bookings;
	private Set<Vehicle> expectedVehicle;

	
	@Before
	public void init() {
		bookings = new HashSet<Booking>();
		expectedVehicle = new HashSet<Vehicle>();
		this.client = new Client();
		this.client.setIdclient(1);
		this.client.setName(name);
		this.client.setNif(nif);
		this.client.setSurname(surname);
		this.client.setTelephone(telephone);
		this.client.setBookings(bookings);
		this.client.setVehicles(expectedVehicle);
		
	}

	@Test
	public void testGetIdclient() {
		// Act
		Integer result = this.client.getIdclient();
		// Assert
		Assert.assertEquals(new Integer(this.idclient), result);
	}

	@Test
	public void testSetIdclient() {
		// Arrange
		final Client client = new Client();
		// Act
		client.setIdclient(1);
		// Assert
		Assert.assertEquals(1, client.getIdclient());

	}

	@Test
	public void testGetName() {
		//Arrenge
		String result = this.client.getName();
		//Assert
		Assert.assertEquals(this.name, result);
	}

	@Test
	public void testSetName() {
		//Arrenge
		final Client client = new Client();
		//Act
		client.setName(name);
		//Assert
		Assert.assertEquals(this.name, client.getName());
	}

	@Test
	public void testGetNif() {
		//Arrenge
		String result = this.client.getNif();
		//Assert
		Assert.assertEquals(this.nif, result);
	}

	@Test
	public void testSetNif() {
		//Arrenge
		final Client client = new Client();
		//Act
		client.setNif(nif);
		//Assert
		Assert.assertEquals(this.nif, client.getNif());

	}

	@Test
	public void testGetSurname() {
		//Arrenge
		String result = this.client.getSurname();
		//Assert
		Assert.assertEquals(this.surname, result);
	}

	@Test
	public void testSetSurname() {
		//Arrenge
		final Client client = new Client();
		//Act
		client.setSurname(surname);
		//Assert
		Assert.assertEquals(this.surname, client.getSurname());
	}

	@Test
	public void testGetTelephone() {
		//Arrenge
		final Client client = new Client();
		//Assert
		Assert.assertEquals(this.telephone, client.getTelephone());

	}

	@Test
	public void testSetTelephone() {
		//Arrenge
		final Client client = new Client();
		//Act
		client.setTelephone(telephone);
		//Assert
		Assert.assertEquals(this.telephone, client.getTelephone());

	}

	@Test 
	public void testGetBookings() {
		//Arrenge
		Set<Booking> result = this.client.getBookings();
		//Assert
		Assert.assertEquals(this.bookings, result);

	}

	@Test
	public void testSetBookings() {
		//Arrenge
		Client client = new Client();
		//Act
		client.setBookings(bookings);
		//Assert
		Assert.assertEquals(this.bookings, client.getBookings());

	}

	@Test
	public void testAddBooking() {
		//Arrange
		Booking expectedBooking = new Booking();
		Client client = new Client(); 
		//Act
		Booking result = client.addBooking(expectedBooking);
		//Assert
		Assert.assertEquals(1, client.getBookings().size());
		Assert.assertEquals(client, result.getClient());
		
	}

	@Test
	public void testRemoveBooking() {
		//Arrange
		Booking booking = new Booking();
		client.addBooking(booking);
		//Act
		client.removeBooking(booking);
		//Asser
		Assert.assertEquals(0, client.getBookings().size());
		
	}

	@Test
	public void testGetVehicles() {
		//Arrange
		Set<Vehicle> result = this.client.getVehicles();
		//Assert
		Assert.assertEquals(this.expectedVehicle, result);
	}

	@Test
	public void testSetVehicles() {
		//Arrange
		Client client = new Client();
		//Act
		client.setVehicles(expectedVehicle);
		//Assert
		Assert.assertEquals(this.expectedVehicle, client.getVehicles());
	}

	@Test
	public void testAddVehicle() {
		//Arrange
		Vehicle expectedVehicle = new Vehicle();
		Client client = new Client(); 
		//Act
		Vehicle result = client.addVehicle(expectedVehicle);
		//Assert
		Assert.assertEquals(1, client.getVehicles().size());
		Assert.assertEquals(client, result.getClient());
		
	}

	@Test
	public void testRemoveVehicle() {
		//Arrange
		Vehicle expectedvehicle = new Vehicle();
		client.addVehicle(expectedvehicle);
		//Act
		client.removeVehicle(expectedvehicle);
		//Asser
		Assert.assertEquals(0, client.getVehicles().size());
			
	}

}
