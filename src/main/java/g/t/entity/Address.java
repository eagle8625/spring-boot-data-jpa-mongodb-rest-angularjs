package g.t.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document( collection = "address" )
@Data
public class Address {

	@Id
	private String	id;

	private String	street;

	private String	city;

	private String	country;

	private int		zipcode;

	public Address( ) {
	}

	@PersistenceConstructor
	public Address( String street, String city, String country, int zipcode ) {
		super( );
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

}
