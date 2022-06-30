package com.example.demo.Security;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account,Integer> {
    Account findByUsername(String username);
}
