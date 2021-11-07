package me.boukadi.dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        System.out.println("VERSION BD");
        return 20;
    }
}
