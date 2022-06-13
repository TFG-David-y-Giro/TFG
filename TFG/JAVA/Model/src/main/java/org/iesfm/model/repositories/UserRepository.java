package org.iesfm.model.repositories;

import org.iesfm.model.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT username FROM user"
    )
    List<String> getAllUsernames();

    @Query(
            nativeQuery = true,
            value = "SELECT mail FROM user"
    )
    List<String> getAllMails();

    @Query(
            nativeQuery = true,
            value = "SELECT password FROM user"
    )
    List<String> getAllPasswords();

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM user u WHERE u.username=:username AND u.password=:password"
    )
    User getUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);


}
