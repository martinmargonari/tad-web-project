package ar.gob.modernizacion.tad.model;

/**
 * Created by MMargonari on 04/07/2017.
 */
public class User {
    private String username;
    private String password;
    private String salt;
    private String iv;

    public User() {
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String salt, String iv) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.iv = iv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public boolean decryptPassword() {
        boolean success = true;
        try {
            this.password = Encrypter.decrypt(this.password, this.salt, this.iv);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    public boolean encryptPassword() {
        boolean success = true;
        try {
            this.password = Encrypter.encrypt(this.password, this.salt, this.iv);
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}
