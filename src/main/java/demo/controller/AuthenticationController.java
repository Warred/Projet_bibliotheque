package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.AuthenticationResponse;
import demo.dto.UserSecurity;
import demo.security.JwtUtils;

@CrossOrigin
@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserSecurity userSecurity){
        UsernamePasswordAuthenticationToken springToken = new UsernamePasswordAuthenticationToken(
                userSecurity.getUsername(),
                userSecurity.getPassword()
        );
        try {
            authenticationManager.authenticate(springToken);
        } catch(BadCredentialsException exception){
            throw exception;            
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        	throw e;
        }
        UserDetails user = userDetailsService.loadUserByUsername(userSecurity.getUsername());
        String jwt = jwtUtils.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
