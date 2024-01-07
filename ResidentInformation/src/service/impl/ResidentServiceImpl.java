package service.impl;

import dao.ResidentDao;
import dao.impl.ResidentDaoImpl;
import model.Resident;
import service.ResidentService;

import java.util.List;

public class ResidentServiceImpl implements ResidentService {
    ResidentDao dao = new ResidentDaoImpl();

    @Override
    public Resident get(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Resident> getAll() {
        return dao.query(null);
    }

    @Override
    public boolean add(Resident resident) {
        return dao.insert(resident) == 1;
    }

    @Override
    public boolean update(Resident resident) {
        return dao.update(resident) == 1;
    }

    @Override
    public boolean del(int id) {
        return dao.delete(id) == 1;
    }

    @Override
    public List<Resident> get(Resident resident) {
        return dao.query(resident);
    }

}
