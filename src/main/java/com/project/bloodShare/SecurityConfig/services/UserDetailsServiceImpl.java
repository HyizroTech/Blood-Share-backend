package com.project.bloodShare.SecurityConfig.services;

<<<<<<< HEAD
import com.project.bloodShare.Repostories.UserRepository;
=======
import com.project.bloodShare.Repositories.UserRepository;
>>>>>>> acc7ed584275b2b5011af5e33c78dff94200b225
import com.project.bloodShare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with Email: " + email));

        return UserDetailsImpl.build(user);
    }
}
