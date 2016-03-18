package g.t.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document( collection = "person" )
@Data
public class Person extends AbstractEntity {

	private static final long	serialVersionUID	= 8622050086330182038L;

	@Id
	private String				id;

	private String				name;

	private int					age;

	@DBRef( db = "address" )
	private List< Address >		addresses			= new ArrayList<>( );

	public Person( ) {
	}

	@PersistenceConstructor
	public Person( String name, int age ) {
		super( );
		this.name = name;
		this.age = age;
	}

	public void addAddresses( Address address ) {

		List< Address > addresses = getAddresses( );

		if ( addresses == null ) {
			addresses = new ArrayList<>( );
		}

		addresses.add( address );

	}
}
