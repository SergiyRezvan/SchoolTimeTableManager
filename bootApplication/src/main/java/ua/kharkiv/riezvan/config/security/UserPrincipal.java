package ua.kharkiv.riezvan.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.kharkiv.riezvan.lessonmanager.teacher.db.entity.Teacher;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private String userName;
    private String role;
    private Long id;
    private String email;
    private String password;
    private Long schoolId;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Teacher teacher) {
        this.userName = teacher.getUserName();
        this.role = "ROLE_" + teacher.getRole().getName();
        this.id = teacher.getId();
        this.email = teacher.getEmail();
        this.password = teacher.getPassword();
        this.schoolId = teacher.getSchoolId();
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + teacher.getRole().getName()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Long getSchoolId() {
        return schoolId;
    }
}
