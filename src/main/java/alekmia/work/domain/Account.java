package alekmia.work.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    @NotNull
    @NotEmpty
    private String site;

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String password;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
