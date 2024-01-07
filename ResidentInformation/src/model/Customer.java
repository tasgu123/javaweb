package model;

import java.util.Date;

public class Customer {
    private int residentId;//id
    private String username;//用户名
    private String password;//密码
    private long createTime;//创建时间
    private long lastAccessTime;//最后一次访问时间

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
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
        return "Customer{" +
                "residentId=" + residentId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", lastAccessTime=" + lastAccessTime +
                '}';
    }
}
