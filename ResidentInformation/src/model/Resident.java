package model;

public class Resident {
    private int residentId;//账号
    private String name;//姓名
    private String gender;//性别
    private String telephone;//电话
    private String buildingNo;//楼号
    private String houseNumber;//门牌号

    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "residentId=" + residentId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                '}';
    }
}
