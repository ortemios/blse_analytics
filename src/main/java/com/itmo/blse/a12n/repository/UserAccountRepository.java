package com.itmo.blse.a12n.repository;

import com.itmo.blse.a12n.model.UserAccount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

@Component
public class UserAccountRepository {

    @Value("${auth.users.file:users.xml}")
    String filePath;

    File usersFile;
    ConcurrentHashMap<String, UserAccount> accounts;
    Lock fileLock;

    Logger logger = Logger.getGlobal();

    @PostConstruct
    private void init() {
        this.accounts = new ConcurrentHashMap<>();
        this.fileLock = new ReentrantLock();
        initFile();
        loadFromXml();

    }

    private void initFile() {

        File file = new File(filePath);
        try {
            file.createNewFile();
        }
        catch (IOException ex){
            throw new RuntimeException(ex);
        }
        this.usersFile = file;

    }


    public void addAccount(UserAccount account){
        accounts.put(account.getUsername(), account);
        dumpToXml();
    }
    public void addAccount(String username, String password){
        accounts.put(username, new UserAccount(username, password));
        dumpToXml();
    }
    public UserAccount findAccount(String username){
        return accounts.get(username);
    }

    private void dumpToXml() {
        try {
            fileLock.lock();
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(usersFile)
                    )
            );
            encoder.writeObject(this.accounts);
            encoder.close();
        }
        catch (FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
        finally {
            fileLock.unlock();
        }


    }
    private void loadFromXml(){
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(usersFile)
                    )
            );
            try {
                this.accounts = (ConcurrentHashMap<String, UserAccount>) decoder.readObject();
            }
            catch (Exception ex){
                logger.warning("Users file corrupted, skipping");
            }

            decoder.close();
        }
        catch (FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }



}
