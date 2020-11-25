package ua.kharkiv.riezvan.config.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.repository.TeacherRepository;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final TeacherRepository teacherRepository;

    @Cacheable("teacherUserNames")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Get teacher by username");
        var teacherOptional = teacherRepository.findTeacherByUserName(username);
        teacherOptional.orElseThrow(() ->
                new UsernameNotFoundException("Invalid username " + username
                        + " or such a user does not exists"));

        return new UserPrincipal(teacherOptional.get());
    }
}
