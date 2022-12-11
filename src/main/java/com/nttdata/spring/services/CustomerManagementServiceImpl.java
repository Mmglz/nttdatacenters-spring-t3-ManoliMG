package com.nttdata.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepositoryI;

/**
 * Implementación del servicio de cliente.
 * 
 * @author manoli
 *
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/** Repositorio. */
	@Autowired
	private CustomerRepositoryI customerRepo;

	@Override
	public void insertNewCustomer(Customer newCustomer) {

		// Verificación de nulidad y existencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Inserción de un nuevo cliente.
			customerRepo.save(newCustomer);
		}
	}

	@Override
	public void updateCustomer(Customer updateCustomer) {

		// Verificación de nulidad y existencia.
		if (updateCustomer != null && updateCustomer.getCustomerId() != null) {

			// Actualización de un cliente.
			customerRepo.save(updateCustomer);
		}
	}

	@Override
	public void deleteCustomer(Customer deleteCustomer) {

		// Verificación de nulidad y existencia.
		if (deleteCustomer != null && deleteCustomer.getCustomerId() != null) {

			// Eliminación de un cliente.
			customerRepo.delete(deleteCustomer);
			System.out.println("El cliente con nombre " + deleteCustomer.getName() + " ha sido borrado.");
		}
	}

	@Override
	public Optional<Customer> findById(Long id) {

		// Obtención de un cliente por su ID.
		return customerRepo.findById(id);
	}

	@Override
	public List<Customer> searchAll() {

		// Obtención de todos los clientes.
		return customerRepo.findAll();
	}

	@Override
	public List<Customer> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {

		List<Customer> customersList = new ArrayList<>();

		// Verificación de nulidad.
		if (name != null && firstSurname != null && secondSurname != null) {

			// Obtención del cliente por nombre y apellidos.
			customersList = customerRepo.findByNameAndFirstSurnameAndSecondSurname(name, firstSurname, secondSurname);
		}

		return customersList;
	}

	@Override
	public List<Customer> searchByNameAndDni(String name, String dni) {
		List<Customer> customersList = new ArrayList<>();

		// Verificación de nulidad.
		if (name != null && dni != null) {

			// Obtención del cliente por nombre y apellidos.
			customersList = customerRepo.findByNameAndDni(name, dni);
		}

		return customersList;
	}
}
