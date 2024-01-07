package service.impl;

import dao.ServiceInfoDao;
import dao.impl.ServiceInfoDaoImpl;
import model.ServiceInformation;
import service.ServiceInformationService;

import java.util.List;

public class ServiceInformationImpl implements ServiceInformationService {
    ServiceInfoDao serviceInfoDao = new ServiceInfoDaoImpl();

    @Override
    public ServiceInformation get(int id) {
        return serviceInfoDao.findById(id);
    }

    @Override
    public List<ServiceInformation> getAll() {
        return serviceInfoDao.query(null);
    }

    @Override
    public boolean add(ServiceInformation service) {
        return serviceInfoDao.insert(service) == 1;
    }

    @Override
    public boolean update(ServiceInformation service) {
        return serviceInfoDao.update(service) == 1;
    }

    @Override
    public boolean del(int id) {
        return serviceInfoDao.delete(id) == 1;
    }

    @Override
    public List<ServiceInformation> get(ServiceInformation service) {
        return serviceInfoDao.query(service);
    }
}
