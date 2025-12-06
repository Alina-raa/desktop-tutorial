package user;

import utils.PropertyReader;

public class UserFactory {
    public static User wiseAdminPermission() {
        return new User(PropertyReader.getProperty("sausedemo.user"), PropertyReader.getProperty("sausedemo.password"));
    }

    public static User wiseLockedUserPermission() {
        return new User(PropertyReader.getProperty("sausedemo.locked_user"), PropertyReader.getProperty("sausedemo.password"));
    }
}