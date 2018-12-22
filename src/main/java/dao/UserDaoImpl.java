package dao;

import api.UserDao;
import entity.User;
import entity.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String fileName;

    public UserDaoImpl(String fileName) throws IOException {
        this.fileName = fileName;
        FileUtils.createNewFile(fileName);
    }

    @Override
    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for(User user : users) {
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for(User user : users) {
            boolean isFoundUser = user.getLogin().equals(login);
            if(isFoundUser) {
                users.remove(user);
            }
        }
        saveUsers(users);
    }

    @Override
    public void removeUserById(Long id) throws IOException {
        List<User> users = getAllUsers();
        for(User user : users) {
            boolean isFoundUser = user.getId().equals(id);
            if(isFoundUser) {
                users.remove(user);
            }
        }
        saveUsers(users);
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while(readLine != null) {
            User user = UserParser.stringToUser(readLine);
            if(user != null) {
                users.add(user);
            }
        }
        bufferedReader.close();
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for(User user : users) {
            boolean isUserFound = user.getLogin().equals(login);
            if(isUserFound) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long id) throws IOException {
        List<User> users = getAllUsers();
        for(User user : users) {
            boolean isUserFOund = user.getId().equals(id);
            if(isUserFOund) {
                return user;
            }
        }
        return null;
    }
}
