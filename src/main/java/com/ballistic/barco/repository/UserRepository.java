package com.ballistic.barco.repository;

import com.ballistic.barco.domain.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Nabeel on 1/11/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    User findByUsernameCaseInsensitive(@Param("username") String username);
    User findByEmail(String email);
    User findByEmailAndActivationKey(String email, String activationKey);
    User findByEmailAndResetPasswordKey(String email, String resetPasswordKey);

}
