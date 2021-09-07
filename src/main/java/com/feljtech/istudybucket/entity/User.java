package com.feljtech.istudybucket.entity;

import com.feljtech.istudybucket.entity.relation.UserInBucket;
import com.feljtech.istudybucket.entity.relation.UserVotePost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Elroy Kanye
 *
 * Modified by: ...
 * Modified on: ...
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", length = 32, unique = true)
    private String username;

    @Column(name = "email", length = 32, unique = true)
    private String email;

    @Column(name = "password", length = 128)
    private String password;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "gender", length = 16)
    private String gender;

    @Column(name = "user_role")
    private int userRole;


    // embedded field -Address
    @Embedded
    private Address address;

    // one to many relationship with Post entity
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts;

    // one to many relationship with Comment entity
    @OneToMany(mappedBy = "commentAuthor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    // [special] many to many relationship with Bucket entity
    @OneToMany(mappedBy = "user")
    private Set<UserInBucket> memberships;

    @OneToMany(mappedBy = "user")
    private Set<UserVotePost> votes;

}
