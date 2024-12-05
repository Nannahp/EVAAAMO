package com.example.evaaamo.controllers;

import com.example.evaaamo.services.LoginService;
import com.example.evaaamo.services.MailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    MailService mailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {
        if (loginService.authenticateUser(email, password)){
            return "redirect:/home/admin/now";
        } else {
            redirectAttributes.addFlashAttribute("errormessage", "Forkert email eller kodeord");
            return "redirect:/login";
        }
    }

    //For testing
    @GetMapping("/home/admin/now")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the secured home page!");
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, SessionStatus sessionStatus) {
        request.getSession().invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/forgotten-password")
    public String forgottenPassword() {
        return "forgotten-password";
    }

    @PostMapping("/forgotten-password")
    public String forgottenPassword(@RequestParam String email, RedirectAttributes redirectAttributes) {
        if (!mailService.isValidEmail(email)) {
            redirectAttributes.addFlashAttribute("message", "Forkert email");
            return "redirect:/forgotten-password";
        }

        if (loginService.findUserByEmail(email) == null) {
            redirectAttributes.addFlashAttribute("message", "Brug din bruger email");
            return "redirect:/forgotten-password";
        }

        String newPassword = loginService.randomPassword();
        mailService.sendEmail(email, newPassword);
        loginService.updatePassword(newPassword, email);

        return "redirect:/login";
    }

    @GetMapping("/reset-password")
    public String resetPassword () {
        return "reset-password";

    }

    @PostMapping("/reset-password/admin")
    public String resetPassword(@RequestParam String currentEmail, @RequestParam String newPassword,
                                @RequestParam String repeatedPassword, HttpSession session,
                                RedirectAttributes redirectAttributes) {


        if (loginService.findUserByEmail(currentEmail) != null){
            if (newPassword.equals(repeatedPassword)) {
                loginService.updatePassword(newPassword, currentEmail);
            } else {
                redirectAttributes.addFlashAttribute("message", "De to kodeord er ikke ens");
                return "redirect:/reset-password/admin";
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Denne bruger findes ikke");
            return "redirect:/reset-password/admin";
        }

        return "redirect:/login";
    }


}
