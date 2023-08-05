package com.example.springjwt.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    @NotBlank(message = "Name is required, please input!")
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "Username is required, please input!")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Email is required, please input!")
    @Size(min = 3, max = 50)
    private String email;

    @NotBlank(message = "Password is required, please input!")
    @Size(min = 3, max = 50)
    private String password;

    private Set<String> roles;
}
