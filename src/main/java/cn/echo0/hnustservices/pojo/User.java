/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jun 30, 2017 2:03:16 PM
 */
package cn.echo0.hnustservices.pojo;

/**
 *
 * @author Ech0
 */
public class User {
    private int stuId;
    private String password ;

    public User(int stuId, String password) {
        this.stuId = stuId;
        this.password = password;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
