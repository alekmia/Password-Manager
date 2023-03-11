package alekmia.work.controller;

import alekmia.work.domain.Account;
import alekmia.work.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Random;
import java.util.regex.Pattern;

@Controller
public class AddAccountPage extends Page {
    private final UserService userService;

    public AddAccountPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addAccount")
    public String addAccountGet(Model model, HttpSession httpSession) {
        model.addAttribute("account", new Account());
        model.addAttribute("suggested_password", generatePassword());
        httpSession.setAttribute("confirmation", false);
        return "AddAccountPage";
    }

    @PostMapping("/addAccount")
    public String addAccountPost(Model model, @Valid @ModelAttribute Account account,
                                 BindingResult bindingResult,
                                 HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "AddAccountPage";
        }
        if((!checkLet(account.getPassword()) || !checkNum(account.getPassword()))
                && (boolean)httpSession.getAttribute("confirmation") == false) {

            model.addAttribute("account", account);
            model.addAttribute("suggested_password", generatePassword());
            httpSession.setAttribute("confirmation", true);

            putMessage(httpSession,
                    "You sure you want a password like that? Make sure your password contains a number and a letter");
            return "AddAccountPage";
        }
        userService.addAccount(getUser(httpSession), account);
        putMessage(httpSession, "You added a new account! Congratulations!!");

        return "redirect:/myAccounts";
    }

    boolean checkNum(String string) {
        return Pattern.compile("[0-9]").matcher(string).find();
    }


    boolean checkLet(String string) {
        return Pattern.compile("[a-zA-Z]").matcher(string).find();
    }

    String generatePassword() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
//        return "qwe";
    }
}
