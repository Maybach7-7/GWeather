package com.maybach7.gweather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PasswordChangeForm {

    private String currentPassword;
    private String newPassword;
    private String repeatedNewPassword;
}