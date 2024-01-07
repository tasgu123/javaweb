package model;

import java.io.Serializable;
import java.util.Date;

public class AdminUser implements Serializable {
    private int id;//id
    private String username;//用户名
    private String password;//密码
    private long createTime;//创建时间
    private long lastAccessTime;//最后一次访问时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setCreateTime(Date createTime) {
        setCreateTime(createTime.getTime());
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        setLastAccessTime(lastAccessTime.getTime());

    }
    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                '}';
    }
}
