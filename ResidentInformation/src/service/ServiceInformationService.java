package service;

import model.ServiceInformation;

import java.util.List;

public interface ServiceInformationService {

    ServiceInformation get(int id);

    List<ServiceInformation> getAll();

    boolean add(ServiceInformation service);

    boolean update(ServiceInformation service);

    boolean del(int id);

    List<ServiceInformation> get(ServiceInformation service);
}
