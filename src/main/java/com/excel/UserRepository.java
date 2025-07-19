package com.excel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
