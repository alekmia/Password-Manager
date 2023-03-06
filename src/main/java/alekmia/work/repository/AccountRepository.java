package alekmia.work.repository;

import alekmia.work.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import alekmia.work.domain.User;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM account WHERE site=?1", nativeQuery = true)
    void deleteAccountBySite(String site);
}
