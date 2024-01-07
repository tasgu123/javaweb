package service;

import model.Resident;

import java.util.List;

public interface ResidentService {
    Resident get(int id);

    List<Resident> getAll();

    boolean add(Resident resident);

    boolean update(Resident resident);

    boolean del(int id);

    List<Resident> get(Resident resident);
}
