package ua.kharkiv.riezvan.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.repository.TeacherRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Cacheable("teacherUserNames")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("Get teacher by username");
        var teacherOptional = teacherRepository.findTeacherByUserName(username);
        teacherOptional.orElseThrow(() ->
                new UsernameNotFoundException("Invalid username " + username
                        + " or such a user does not exists"));

        return new UserPrincipal(teacherOptional.get());
    }
}
