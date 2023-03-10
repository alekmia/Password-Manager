package alekmia.work.controller;

import alekmia.work.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import alekmia.work.service.UserService;

import javax.servlet.http.HttpSession;

public class Page {
    private static final String USER_ID_SESSION_KEY = "userId";
    private static final String MESSAGE_SESSION_KEY = "message";

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUser(HttpSession httpSession) {
        return userService.findById((Long) httpSession.getAttribute(USER_ID_SESSION_KEY));
    }

    @ModelAttribute("message")
    public String getMessage(HttpSession httpSession) {
        String message = (String) httpSession.getAttribute(MESSAGE_SESSION_KEY);
        httpSession.removeAttribute(MESSAGE_SESSION_KEY);
        return message;
    }

    void setUser(HttpSession httpSession, User user) {
        if (user != null) {
            httpSession.setAttribute(USER_ID_SESSION_KEY, user.getId());
        } else {
            unsetUser(httpSession);
        }
    }

    void unsetUser(HttpSession httpSession) {
        httpSession.removeAttribute(USER_ID_SESSION_KEY);
    }

    public void putMessage(HttpSession httpSession, String message) {
        httpSession.setAttribute(MESSAGE_SESSION_KEY, message);
    }
}
