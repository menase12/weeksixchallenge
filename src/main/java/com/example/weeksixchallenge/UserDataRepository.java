package com.example.weeksixchallenge;

import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData, Long> {

    //UserData findByAcctNumber(String acctNumber);
//        UserInfo findByUsername(String username);
//
//        UserInfo findByEmail (String email);
//
//        Long countByEmail(String email);
//
//        Long countByUsername(String username);
    }

