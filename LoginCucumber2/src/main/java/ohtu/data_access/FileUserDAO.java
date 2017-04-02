/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.AbstractList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

/**
 *
 * @author Willburner
 */
public class FileUserDAO implements UserDao {
    private Scanner scanner;
    private String fileName;
    private List<User> users;
    FileWriter writer;
    
    public FileUserDAO(String fileName)  {
        this.fileName = fileName;
        initializeDB();
    }

    public void initializeDB() {
        try {
            scanner = new Scanner(new File(this.fileName));
            while(scanner.hasNextLine()) {
                User userNew = new User(scanner.next(), scanner.next());
                this.users.add(userNew);
            }
        } catch (Exception e) {
            System.out.println("Couldn't read file.");
            System.out.println("Creating new file.");
            File f = new File(fileName);
        }
    }
    
    public void initializeWriter() {
    try {
            writer = new FileWriter(new File(fileName));
        } catch (Exception e) {
            System.out.println("Couldn't read file: " + e.getMessage());
        }
    }

    
    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        if (this.users.isEmpty()) {
            return null;
        }
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
            
        }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            initializeWriter();
            String toAppend = user.getUsername() + " " + user.getPassword() + System.lineSeparator();
            writer.write(toAppend);
            writer.close();
        } catch (Exception e) {
            System.out.println("Couldn't add a user: " + e.getMessage());
        }
    }


}
