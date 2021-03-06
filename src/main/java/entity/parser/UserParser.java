package entity.parser;

import entity.User;

public class UserParser {
    public static User stringToUser(String readLine) {
        String[] userInformations = readLine.split(User.USER_SEPARATOR);

        Long id = Long.parseLong(userInformations[0]);
        String login = userInformations[1];
        String password = userInformations[2];

        return new User(id, login, password);
    }
}
