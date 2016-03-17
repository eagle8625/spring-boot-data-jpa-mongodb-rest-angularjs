package g.t.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import g.t.entity.Address;

public interface AddressRepository extends MongoRepository< Address, Long > {
}
