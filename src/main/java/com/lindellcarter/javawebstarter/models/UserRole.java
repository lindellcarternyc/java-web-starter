package com.lindellcarter.javawebstarter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "userroles")
@IdClass(UserRoleId.class)
public class UserRole implements Serializable {
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name =  "userid")
    @JsonIgnoreProperties(value = "roles", allowSetters = true)
    private UserModel user;

    @Id
    @ManyToOne
    @JoinColumn(name = "roleid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Role role;

    public UserRole() {
    }

    public UserRole(UserModel user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof UserRole)) return false;

        UserRole that = (UserRole) o;
        return ((user == null) ? 0 : user.getUserId()) == ((that.user == null) ? 0 : that.user.getUserId()) &&
                ((role == null) ? 0 : role.getRoleId()) == ((that.role == null) ? 0 : that.role.getRoleId());
    }

    @Override
    public int hashCode() {
        return 8314;
    }
}
