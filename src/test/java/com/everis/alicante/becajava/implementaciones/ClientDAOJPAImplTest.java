package com.everis.alicante.becajava.implementaciones;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.everis.alicante.becajava.domain.Client;


@RunWith(MockitoJUnitRunner.class)
public class ClientDAOJPAImplTest { 
	
	private ClientDAOJPAImpl clientDao;
	
	@Mock
	EntityManager emMock;
	@Mock
	EntityTransaction entityTransactionMock;
	
	
	@Before
	public void init() {
		this.clientDao = new ClientDAOJPAImpl(this.emMock);
	}

	@Test
	public void testCreate() {
		//Arrenge
		Client expectedClient = new Client();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		//Act
		this.clientDao.create(expectedClient);
		//Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).persist(expectedClient);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testReadById() {
		//Arrange
		Client expectedClient = new Client();
		Mockito.when(this.emMock.find(Client.class,1)).thenReturn(expectedClient);
		//Act
		final Client result = this.clientDao.readById(1);
		//Assert
		Assert.assertEquals(expectedClient, result);
	}

	@Test
	public void testUpdate() {
		//Arrange
		Client expectedClient = new Client();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		//Act
		this.clientDao.update(expectedClient);
		//Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).merge(expectedClient);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testDelete() {
		//Arrenge
		Client expectedClient = new Client();
		Mockito.when(this.emMock.getTransaction()).thenReturn(this.entityTransactionMock);
		//Act
		this.clientDao.delete(expectedClient);
		//Assert
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).begin();
		Mockito.verify(this.emMock, Mockito.times(1)).remove(expectedClient);
		Mockito.verify(this.entityTransactionMock, Mockito.times(1)).commit();
	}

	@Test
	public void testClientDAOJPAImpl() {

	}

	@Test
	public void testFindAll() {

	}

	@Test
	public void testFindImporteByClient() {

	}

}
