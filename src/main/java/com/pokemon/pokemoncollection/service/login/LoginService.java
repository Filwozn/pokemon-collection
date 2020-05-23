package com.pokemon.pokemoncollection.service.login;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean isLogged() {
        Object principal = getPrincipal();
        return principal instanceof UserDetails;
    }

    public String getLoggerUserMail() {
       return getLoggedUserDetails().getUsername();
    }

    public void validateUserLogged() {
        if (!isLogged()) {
            throw new LoginServiceException("Użytkownik niezalogowany");
        }
    }

    private UserDetails getLoggedUserDetails() {
        Object principal = getPrincipal();
        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        }
        throw new LoginServiceException("Użytkownik niezalogowany");
    }
    private Object getPrincipal(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return authentication.getPrincipal();
    }
}
