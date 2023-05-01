package com.accesssingdatajpaex.demoaccessingdatajpa;

/*CustomerRepository extends the CrudRepository interface.
The type of entity and ID that it works with, Customer and Long, are specified in the generic parameters on CrudRepository.
By extending CrudRepository, CustomerRepository inherits several methods for working with Customer persistence,
 including methods for saving, deleting, and finding Customer entities.
* */

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository  extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
