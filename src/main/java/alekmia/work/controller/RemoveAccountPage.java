package alekmia.work.controller;

import alekmia.work.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import alekmia.work.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class RemoveAccountPage extends Page {
    private final UserService userService;

    public RemoveAccountPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/removeAccount")
    public String removeAccountGet(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("site");
        return "RemoveAccountPage";
    }

    @PostMapping("/removeAccount")
    public String removeAccountPost(@ModelAttribute Account site,
//                                    BindingResult bindingResult,
                                    HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "RemoveAccountPage";
//        }
        userService.removeAccountBySite(getUser(httpSession), site);
        putMessage(httpSession, "You deleted a new account! ;((");

        return "redirect:/myAccounts";
    }

//    @PostMapping("/removeAccount")
//    public String removeAccountPost(@Valid @ModelAttribute Account account,
//                                 BindingResult bindingResult,
//                                 HttpSession httpSession) {
//        if (bindingResult.hasErrors()) {
//            return "RemoveAccountPage";
//        }
//        userService.removeAccount(getUser(httpSession), account);
//        putMessage(httpSession, "You deleted a new account! ;((");
//
//        return "redirect:/myAccounts";
//    }
}
