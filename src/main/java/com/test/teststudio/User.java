package com.test.teststudio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Setter
    private Long id;
    private String name;
    private int age;
    private String email;

}