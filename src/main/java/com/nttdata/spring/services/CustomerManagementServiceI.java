package com.nttdata.spring.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.spring.repository.Customer;

/**
 * Interface del servicio de cliente.
 * 
 * @author manoli
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updateCustomer
	 */
	public void updateCustomer(final Customer updateCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deleteCustomer
	 */
	public void deleteCustomer(final Customer deleteCustomer);

	/**
	 * Obtiene un cliente por su id.
	 * 
	 * @param id
	 * @return Customer
	 */
	public Optional<Customer> findById(Long id);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAll();

	/**
	 * Obtiene un cliente por su nombre y apellidos.
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List <Customer>
	 */
	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname);
	
	/**
	 * Obtiene un cliente por su nombre y DNI.
	 * 
	 * @param name
	 * @param dni
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndDni(String name, String dni);
}
