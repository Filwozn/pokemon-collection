package com.pokemon.pokemoncollection.service;

import com.pokemon.pokemoncollection.dto.UserDTO;
import com.pokemon.pokemoncollection.model.User;
import com.pokemon.pokemoncollection.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private UserRepository userRepository;
    private boolean logged = false;
    private User loggedUser = null;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void loginUser(UserDTO userDTO) {
        String email = userDTO.getEmail();
        validateEmail(email);
        validatePassword(userDTO);
        User user =  userRepository.findByEmail(userDTO.getEmail());
        login(user);

    }
    public void validateEmail(String email){
        if (email.isBlank()){
            throw new LoginServiceException("Należy podać email.");
        }
        String regex = "^(.+)@(.+)$";
        if(!email.matches(regex)){
            throw new LoginServiceException("Niepoprawny email.");
        }
        if(userRepository.findByEmail(email) == null){
            throw new LoginServiceException("Nie istnieje użytkownik o takim e-mailu.");
        }
    }
    public void validatePassword(UserDTO userDTO) {
        if (userDTO.getPassword().isBlank()) {
            throw new LoginServiceException("Należy podać hasło.");
        }
        if (userDTO.getPassword().length()<5) {
            throw new LoginServiceException("Za krótkie hasło.");
        }

        User user =  userRepository.findByEmail(userDTO.getEmail());
          if (!user.getPassword().equals(userDTO.getPassword())){
              throw new LoginServiceException("Niepoprawne hasło.");
          }
    }
    public void login(User user){
        logged = true;
        loggedUser = user;
    }
    public void logout(){
        logged = false;
        loggedUser = null;
    }

    public boolean isLogged() {
        return logged;
    }
    public String getLoggerUserMail(){
        return loggedUser.getEmail();
    }
}
