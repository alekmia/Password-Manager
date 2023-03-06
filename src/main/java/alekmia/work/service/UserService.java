package alekmia.work.service;

import alekmia.work.domain.Account;
import alekmia.work.domain.User;
import alekmia.work.form.UserCredentials;
import alekmia.work.repository.AccountRepository;
import alekmia.work.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    
    /**
     * @noinspection FieldCanBeLocal, unused
     */
    public UserService(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    public User register(UserCredentials userCredentials) {
        User user = new User();
        user.setLogin(userCredentials.getLogin());
        userRepository.save(user);
        userRepository.updatePasswordSha(user.getId(), userCredentials.getLogin(), userCredentials.getPassword());
        return user;
    }

    public boolean isLoginVacant(String login) {
        return userRepository.countByLogin(login) == 0;
    }

    public User findByLoginAndPassword(String login, String password) {
        return login == null || password == null ? null : userRepository.findByLoginAndPassword(login, password);
    }

    public User findById(Long id) {
        return id == null ? null : userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public void addAccount(User user, Account account) {
        user.addAccount(account);
        account.setOwner(user);
        userRepository.save(user);
    }


    public void removeAccountBySite(User user, Account account) {
        user.removeAccountBySite(account.getSite());
        userRepository.save(user);
    }

//    public void removeAccount(User user, String site) {
//        user.removeAccount(site);
//        accountRepository.deleteAccountByFirstName(account.getSite());
//    }


}
