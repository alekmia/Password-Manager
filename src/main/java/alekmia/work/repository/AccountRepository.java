package alekmia.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import alekmia.work.domain.User;

import java.util.List;

public interface AccountRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("delete from Account u where u.site = ?1")
    void deleteAccountBySiteName(String site);


    @Query(value = "SELECT * FROM user WHERE login=?1 AND passwordSha=SHA1(CONCAT('1be3db47a7684152', ?1, ?2))", nativeQuery = true)
    User findByLoginAndPassword(String login, String password);

    List<User> findAllByOrderByIdDesc();
}
