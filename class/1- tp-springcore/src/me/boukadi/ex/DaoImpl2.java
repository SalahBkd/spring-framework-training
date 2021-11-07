package me.boukadi.ex;

import me.boukadi.dao.IDao;

public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("VERSION WEB");
        return 10;
    }
}
