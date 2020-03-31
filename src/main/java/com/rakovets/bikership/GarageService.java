package com.rakovets.bikership;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GarageService {
    @Autowired
    private UserRepository userRepository;

    User getUser(long id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        throw new Exception("User isn't exist!");
    }

    User saveUser(User user) {
        return userRepository.save(user);
    }
}
