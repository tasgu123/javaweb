package model;

public class SystemBulletin {
    private int systemId;
    private String systemName;
    private String systemDate;
    private String adminUserName;

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public String toString() {
        return "SystemBulletin{" +
                "systemId=" + systemId +
                ", systemName='" + systemName + '\'' +
                ", systemDate='" + systemDate + '\'' +
                ", adminUserName='" + adminUserName + '\'' +
                '}';
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }
}
