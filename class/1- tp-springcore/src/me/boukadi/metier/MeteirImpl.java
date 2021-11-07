package me.boukadi.metier;

import me.boukadi.dao.DaoImpl;
import me.boukadi.dao.IDao;

public class MeteirImpl implements IMetier {
    // loose coupling
    private IDao dao;

    @Override
    public double calcule() {
        return this.dao.getData() + 10;
    }

    public void setDao(DaoImpl dao) {
        this.dao = dao;
    }
}
