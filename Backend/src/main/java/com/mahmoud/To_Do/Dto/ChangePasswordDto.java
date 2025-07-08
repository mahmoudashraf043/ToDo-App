package com.mahmoud.To_Do.Dto;

public class ChangePasswordDto {

    String oldPassword;
    String newPassword;
    public ChangePasswordDto() {}

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
