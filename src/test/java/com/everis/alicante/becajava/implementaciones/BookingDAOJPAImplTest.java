package com.everis.alicante.becajava.implementaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.alicante.becajava.domain.Booking;


@RunWith(MockitoJUnitRunner.class)
public class BookingDAOJPAImplTest {
	
	private BookingDAOJPAImpl bookingDAO;
	
	@Mock
	EntityManager emMock;
	@Mock
	EntityTransaction entityTransactionMock;
	@Mock
	Query query; 
	
	@Before
	public void init() {
		this.bookingDAO = new BookingDAOJPAImpl(this.emMock); 
	}

	@Test
	public void testReadById() {
		//Arrange
		Booking expectedResult = new Booking();
		Mockito.when(this.emMock.find(Booking.class, 1)).thenReturn(expectedResult);
		
		//Act
		final Booking result = this.bookingDAO.readById(1);
		
		//Assert
		Assert.assertEquals(expectedResult, result);

	}
	
	@Test
	public void testUpdate() {
		//Arrange
		Booking booking = new Booking();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		
		//Act
		this.bookingDAO.update(booking);
		
		//Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).merge(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}
	
	@Test
	public void testCreate() {
		//Arrange
		Booking booking = new Booking();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		//Act
		this.bookingDAO.create(booking);
		//Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).persist(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
		
	}
	
	@Test
	public void testDelete() {
		//Arrange
		Booking booking = new Booking();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		//Act
		this.bookingDAO.delete(booking);
		//Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).remove(booking);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit(); 
	}
	
	@Test
	public void testFindAll() {
		//Arrange
		List<Booking> list = new ArrayList<>();
		Mockito.when(emMock.createNamedQuery("Booking.findAll")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(list);
		//Act
		List<Booking> result = this.bookingDAO.findAll();
		//Assert
		Assert.assertEquals(list, result);
	}
	
}





