package pl.britenet.springbootkilubjuly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.britenet.campuslu.object.User;
import pl.britenet.campuslu.service.UserService;
import pl.britenet.springbootkilubjuly.model.UserCredentials;
import pl.britenet.springbootkilubjuly.model.UserLoginData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final Map<String, Integer> activeTokens;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.userService = userService;
        this.activeTokens = new HashMap<>();
    }

    public UserLoginData login(UserCredentials userCredentials) {
        Optional<User> oUser = this.userService.getUser(userCredentials.getUsername(), userCredentials.getPassword());
        if (oUser.isPresent()) {
            User user = oUser.get();
            int userId = user.getId();
            String userToken = UUID.randomUUID().toString();
            this.activeTokens.put(userToken, userId);
            return new UserLoginData(userId, userToken);
        }
        throw new IllegalStateException("Invalid Credentials.");
    }

    public boolean isLogged(String token) {
        return this.activeTokens.containsKey(token);
    }

    public void register(UserCredentials userCredentials) {
        //TODO
    }
}
