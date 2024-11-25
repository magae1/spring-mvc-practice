package org.conan;

public class SmartPhone {

    private Chargeable c;

    SmartPhone() {
    };

    public void charge() {
        System.out.printf("%s으로 충전", c.getMode());
    }

    public void setBattery(Chargeable c) {
        this.c = c;
    }
}
