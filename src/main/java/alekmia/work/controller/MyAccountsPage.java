package alekmia.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyAccountsPage extends Page {
    @GetMapping("/myAccounts")
    public String accounts(HttpSession httpSession) {
        if(getUser(httpSession) == null) {
            return "redirect:/";
        }
        return "MyAccountsPage";
    }
}
