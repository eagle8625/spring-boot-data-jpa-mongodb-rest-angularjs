package g.t.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import g.t.entity.Address;

public interface AddressRepository extends MongoRepository< Address, Long > {

	@Query("{ 'country' : ?0}")
	List<Address> findByTheCountry(String country);
}
