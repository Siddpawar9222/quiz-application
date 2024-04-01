package com.spquiz.quizappbackend.service;

import com.spquiz.quizappbackend.dto.UserDto;
import com.spquiz.quizappbackend.exception.BadRequestException;
import com.spquiz.quizappbackend.exception.LoginException;
import com.spquiz.quizappbackend.exception.ResourceUnavailableException;
import com.spquiz.quizappbackend.exception.UsernameAlreadyExistException;
import com.spquiz.quizappbackend.model.ERole;
import com.spquiz.quizappbackend.model.Role;
import com.spquiz.quizappbackend.model.User;
import com.spquiz.quizappbackend.repo.RoleRepository;
import com.spquiz.quizappbackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository ;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String registerUser(UserDto userDto) throws BadRequestException, ResourceUnavailableException, UsernameAlreadyExistException {
        Boolean existsByUsername = userRepository.existsByUsername(userDto.getUsername());

        if (existsByUsername) {
            throw new UsernameAlreadyExistException("Username already exist, use different one");
        }

        List<String> roleList = userDto.getRoles();

        List<Role> role = new ArrayList<>();
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();

        if (roleList == null) {
             Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT).orElseThrow(() -> new RuntimeException("Student Role not available right now"));
            role.add(userRole);
        } else {
            for (String r : roleList) {
                if (r.equalsIgnoreCase("admin")) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new ResourceUnavailableException("ADMIN Role is not available "));
                    role.add(adminRole);
                } else if (r.equalsIgnoreCase("user")) {
                    Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                            .orElseThrow(() -> new ResourceUnavailableException("Student Role is not available"));
                    role.add(userRole);
                } else {
                    throw new BadRequestException("Only Admin Or Student role is available");
                }
            }
        }

        user.setRoles(role);
        userRepository.save(user) ;
        return "Registration Successful....Please Login" ;
    }

//    public String authenticateAndGetToken(UserDto userDto) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
//        System.out.println(authentication.isAuthenticated());
//        if (authentication.isAuthenticated()) {
//            Integer userId = userRepository.findIdByUsername(userDto.getUsername());
//            return jwtService.generateToken(userDto.getUsername(), userId);
//        } else {
//            throw new UsernameNotFoundException("Invalid user request !");
//        }
//    }


    public String authenticateAndGetToken(UserDto userDto) throws LoginException {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
            System.out.println(authentication.isAuthenticated());
            if (authentication.isAuthenticated()) {
                Integer userId = userRepository.findIdByUsername(userDto.getUsername());
                return jwtService.generateToken(userDto.getUsername(), userId);
            } else {
                throw new UsernameNotFoundException("Invalid user request !");
            }
        } catch (AuthenticationException e) {
            throw new LoginException("Authentication failed: " + e.getMessage());
        }
    }

}
