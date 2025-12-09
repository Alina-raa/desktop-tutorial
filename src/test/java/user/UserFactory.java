package user;

import utils.PropertyReader;

public class UserFactory {
    public static User wiseAdminPermission() {
        return new User(PropertyReader.getProperty("sausedemo.user"), PropertyReader.getProperty("sausedemo.password"));
    }

    public static User wiseLockedUserPermission() {
        return new User(PropertyReader.getProperty("sausedemo.locked_user"), PropertyReader.getProperty("sausedemo.password"));
    }
    public static User wiseZeroUserPermission() {
        return new User(PropertyReader.getProperty("sausedemo.zero_user"), PropertyReader.getProperty("sausedemo.password"));
    }
    public static User wiseinCorlockedUserPermission() {
        return new User(PropertyReader.getProperty("sausedemo.inCorlocked_user"), PropertyReader.getProperty("sausedemo.password"));
    }

    public static User wiseZeroPassPermission() {
        return new User(PropertyReader.getProperty("sausedemo.user"), PropertyReader.getProperty("sausedemo.zero_password"));
    }
}