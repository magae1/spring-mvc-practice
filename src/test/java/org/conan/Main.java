package org.conan;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("setting.txt");
        Scanner scanner = new Scanner(fis);
        Class<?> cl = Class.forName(scanner.nextLine());

        SmartPhone sp = new SmartPhone();
        Chargeable c =(Chargeable) cl.newInstance();
        sp.setBattery(c);
        sp.charge();
    }
}

