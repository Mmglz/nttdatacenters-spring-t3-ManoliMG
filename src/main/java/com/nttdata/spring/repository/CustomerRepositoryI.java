package com.nttdata.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Cliente
 * 
 * @author manoli
 *
 */
@Repository
public interface CustomerRepositoryI extends JpaRepository<Customer, Long> {

	/**
	 * Método que busca por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<Customer>
	 */
	public List<Customer> findByNameAndFirstSurnameAndSecondSurname(final String name, final String firstSurname, final String secondSurname);
	
	/**
	 * Método que busca por nombre y DNI.
	 * 
	 * @param name
	 * @param dni
	 * @return List<Customer>
	 */
	public List<Customer> findByNameAndDni (final String name, final String dni);
}
