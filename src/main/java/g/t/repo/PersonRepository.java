package g.t.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import g.t.entity.Person;

public interface PersonRepository extends MongoRepository< Person, Long > {

	Iterable<Person> findByName(String personName);

	Iterable<Person> findByNameAndAge(String name, int age);

}
