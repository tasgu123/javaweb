package service;

import model.SystemBulletin;

import java.util.List;

public interface SystemBulletinService {

    SystemBulletin get(int id);

    List<SystemBulletin> getAll();

    boolean add(SystemBulletin systemBulletin);

    boolean update(SystemBulletin systemBulletin);

    boolean del(int id);

    List<SystemBulletin> get(SystemBulletin systemBulletin);
}
