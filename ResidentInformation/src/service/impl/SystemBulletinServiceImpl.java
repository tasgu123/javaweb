package service.impl;

import dao.SystemBulletinDao;
import dao.impl.SystemBulletinDaoImpl;
import model.SystemBulletin;
import service.SystemBulletinService;

import java.util.List;

public class SystemBulletinServiceImpl implements SystemBulletinService {
    SystemBulletinDao dao = new SystemBulletinDaoImpl();

    @Override
    public SystemBulletin get(int id) {
        return dao.findById(id);
    }

    @Override
    public List<SystemBulletin> getAll() {
        return dao.query(null);
    }

    @Override
    public boolean add(SystemBulletin systemBulletin) {
        return dao.insert(systemBulletin) == 1;
    }

    @Override
    public boolean update(SystemBulletin systemBulletin) {
        return dao.update(systemBulletin) == 1;
    }

    @Override
    public boolean del(int id) {
        return dao.delete(id) == 1;
    }

    @Override
    public List<SystemBulletin> get(SystemBulletin systemBulletin) {
        return dao.query(systemBulletin);
    }
}
