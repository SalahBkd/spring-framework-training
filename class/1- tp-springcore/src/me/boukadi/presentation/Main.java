package me.boukadi.presentation;

import me.boukadi.dao.IDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // OPEN-CLOSED principle.

        /* static DI
        MeteirImpl metier = new MeteirImpl();
        metier.setDao(new DaoImpl());
        System.out.println(metier.calcule());
        */

        /* dyanamic DI
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        System.out.println("CLASS NAME: "+ daoClassName);
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();
        System.out.println(dao.getData());
        */
    }
}
