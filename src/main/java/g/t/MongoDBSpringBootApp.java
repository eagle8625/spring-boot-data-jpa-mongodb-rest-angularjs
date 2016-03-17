package g.t;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import g.t.entity.Address;
import g.t.entity.Person;
import g.t.repo.AddressRepository;
import g.t.repo.PersonRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan( basePackages = "g.t" )

public class MongoDBSpringBootApp implements CommandLineRunner {

	@Autowired
	private PersonRepository	personRepo;
	@Autowired
	private AddressRepository	addressRepo;

	@Override
	public void run( String... args ) throws Exception {

		System.out.println( "Running ..." );

		savePerson1( );
		savePerson2( );

		Iterable< Person > personList = personRepo.findAll( );
		
		System.out.println( "Person List : " );
		
		for ( Person person: personList ) {
			System.out.println( person );
		}
		
		Iterable<Address> addressesNepal = addressRepo.findByTheCountry( "Nepal" );
		for ( Address address: addressesNepal ) {
			System.out.println( address );
		}

	}

	private void savePerson1( ) {
		/*
		 * The mapping framework does not handle cascading saves. 
		 * 
		 * Calling save on the Person object will not automatically save the Address objects in the property 'addresses'.
		 * 
		 * we need to save each object
		 */
		Person person = new Person( "Ganesh", 25 );

		Address addr = addressRepo.save( new Address( "Kupondole 221", "Lalitpur", "Nepal", 44600 ) );

		person.addAddresses( addr );

		personRepo.save( person );
	}

	private void savePerson2( ) {
		Person person = new Person( "Jyoti", 20 );

		Address address = new Address( "Pulchowk 120", "Lalitpur", "Nepal", 44600 );

		address = addressRepo.save( address );

		person.addAddresses( address );

		personRepo.save( person );
	}

	public static void main( String[] args ) throws Exception {
		SpringApplication app = new SpringApplication( MongoDBSpringBootApp.class );
		app.setWebEnvironment( false );

		ConfigurableApplicationContext context = app.run( args );

		context.close( );
	}

}
