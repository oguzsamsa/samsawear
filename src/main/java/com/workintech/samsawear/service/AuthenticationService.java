package com.workintech.samsawear.service;

import com.workintech.samsawear.entity.Role;
import com.workintech.samsawear.entity.User;
import com.workintech.samsawear.exception.ApiException;
import com.workintech.samsawear.repository.RoleRepository;
import com.workintech.samsawear.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(String name, String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()){
            throw new ApiException("User with given email already exists!", HttpStatus.BAD_REQUEST);
        }

        String encodedPassword = passwordEncoder.encode(password);
        List<Role> roleList = new ArrayList<>();

        Optional<Role> roleUser = roleRepository.findByAuthority("USER");
        if (!roleUser.isPresent()) {
            Role roleUserEntity = new Role();
            roleUserEntity.setAuthority("USER");
            roleList.add(roleRepository.save(roleUserEntity));
        } else {
            roleList.add(roleUser.get());
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setAuthorities(roleList);
        System.out.println(user);
        return userRepository.save(user);
    }

    public User login(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException("User with given email doesn't exist!", HttpStatus.BAD_REQUEST));

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new ApiException("Invalid password!", HttpStatus.BAD_REQUEST);
        }

        return user;
    }

}
