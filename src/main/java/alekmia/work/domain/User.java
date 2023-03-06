package alekmia.work.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class User {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @NotEmpty
    private String login;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @OrderBy("creationTime desc")
//    private List<Post> posts;

//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = {CascadeType.ALL})
//    @JoinTable(name = "user_country",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "country_id"))
//    private Set<Country> countries;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void addAccount(Account account) {
        account.setOwner(this);
        getAccounts().add(account);
    }

    public void removeAccountBySite(String site) {
        accounts.removeIf(el -> Objects.equals(el.getSite(), site));
    }

    public void removeAccount(Account account) {
        accounts.removeIf(el -> el == account);
    }


}
