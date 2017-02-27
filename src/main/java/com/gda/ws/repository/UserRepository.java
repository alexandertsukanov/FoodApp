package com.gda.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gda.ws.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = " select user from User user where user.deviceId = :deviceId")
    User findByDeviceId(@Param(value = "deviceId") String deviceId);
}
