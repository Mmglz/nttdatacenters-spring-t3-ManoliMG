package com.nttdata.spring;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Clase principal
 * 
 * @author manoli
 *
 */
@SpringBootApplication
public class Main implements CommandLineRunner {

	/** LOGGER **/
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@Autowired
	CustomerManagementServiceI customerService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LOG.info("TRAZA DE INICIO");

		// Auditoría.
		final String updateUser = "NTT_CUSTOMER";
		final Date updateDate = new Date();

		LOG.info("Inicio generación de clientes");

		// Generación de clientes.
		final Customer customer1 = new Customer();
		customer1.setName("Maria");
		customer1.setFirstSurname("Perez");
		customer1.setSecondSurname("Garcia");
		customer1.setDni("41567469H");
		customer1.setBirthday("04-12-1993");
		customer1.setUpdatedDate(updateDate);
		customer1.setUpdatedUser(updateUser);

		final Customer customer2 = new Customer();
		customer2.setName("Pablo");
		customer2.setFirstSurname("Camacho");
		customer2.setSecondSurname("Delgado");
		customer2.setDni("85317614L");
		customer2.setBirthday("20-04-1989");
		customer2.setUpdatedDate(updateDate);
		customer2.setUpdatedUser(updateUser);

		final Customer customer3 = new Customer();
		customer3.setName("Laura");
		customer3.setFirstSurname("Medero");
		customer3.setSecondSurname("Rodriguez");
		customer3.setDni("56841394S");
		customer3.setBirthday("16-11-1982");
		customer3.setUpdatedDate(updateDate);
		customer3.setUpdatedUser(updateUser);

		final Customer customer4 = new Customer();
		customer4.setName("Pepe");
		customer4.setFirstSurname("Mejias");
		customer4.setSecondSurname("Roldan");
		customer4.setDni("20553274R");
		customer4.setBirthday("30-07-1985");
		customer4.setUpdatedDate(updateDate);
		customer4.setUpdatedUser(updateUser);

		final Customer customer5 = new Customer();
		customer5.setName("Estrella");
		customer5.setFirstSurname("Lopez");
		customer5.setSecondSurname("Blanco");
		customer5.setDni("17349835F");
		customer5.setBirthday("01-01-1979");
		customer5.setUpdatedDate(updateDate);
		customer5.setUpdatedUser(updateUser);

		LOG.info("Fin generación de clientes");

		LOG.info("Inicio inserciones de clientes");

		// Inserciones de los clientes.
		customerService.insertNewCustomer(customer1);
		customerService.insertNewCustomer(customer2);
		customerService.insertNewCustomer(customer3);
		customerService.insertNewCustomer(customer4);
		customerService.insertNewCustomer(customer5);

		LOG.info("Fin inserciones de clientes");

		LOG.info("Inicio de consultas y modificaciones de los clientes");

		// Consulta de un cliente por nombre y apellidos.
		System.out.println("Consulta de clientes por nombre y apellidos");
		
		final List<Customer> result1 = customerService.searchByNameAndSurnames("Pablo", "Camacho", "Delgado");
		for (final Customer c : result1) {
			System.out.println(c.toString());
		}

		final List<Customer> result2 = customerService.searchByNameAndSurnames("Estrella", "Lopez", "Blanco");
		for (final Customer c : result2) {
			System.out.println(c.toString());
		}

		// Consulta de un cliente por nombre y DNI.
		System.out.println("\nConsulta de clientes por nombre y DNI");
		
		final List<Customer> result3 = customerService.searchByNameAndDni("Laura", "56841394S");
		for (final Customer c : result3) {
			System.out.println(c.toString());
		}

		// Consulta todos los clientes.
		System.out.println("\nConsulta de todos clientes");
		
		final List<Customer> allCustomers = customerService.searchAll();
		for (final Customer c : allCustomers) {
			System.out.println(c.toString() + "\n");
		}

		// Actualización un cliente.
		customer4.setName("Jose");
		customerService.updateCustomer(customer4);

		// Eliminación un cliente.
		customerService.deleteCustomer(customer5);

		LOG.info("Fin de consultas y modificaciones de los clientes");

		LOG.info("TRAZA FIN");
	}
}
