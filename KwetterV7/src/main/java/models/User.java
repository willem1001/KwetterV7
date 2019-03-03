package models;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "className")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "username", nullable = false, unique = true, length = 30)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "location")
    private String location;

    @Column(name = "website")
    private String website;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar")
    private String avatar;

    @ElementCollection
    //@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "followingIds")
    private List<Long> followerIds = new ArrayList<Long>();

    @ElementCollection
    private List<Long> followingIds = new ArrayList<Long>();


    public User() {
    }

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String location, String website, String bio, String avatar, Role role) {
        this.username = username;
        this.location = location;
        this.website = website;
        this.bio = bio;
        this.avatar = avatar;
        this.role = role;
    }
}