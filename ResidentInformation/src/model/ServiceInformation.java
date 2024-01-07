package model;

public class ServiceInformation {
    private  int serviceId;
    private  String serviceName;
    private  String serviceDate;
    private  String ResidentName;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getResidentName() {
        return ResidentName;
    }

    public void setResidentName(String residentName) {
        ResidentName = residentName;
    }

    @Override
    public String toString() {
        return "serviceInformation{" +
                "serviceId=" + serviceId +
                ", serviceName='" + serviceName + '\'' +
                ", serviceDate='" + serviceDate + '\'' +
                ", ResidentName='" + ResidentName + '\'' +
                '}';
    }
}
