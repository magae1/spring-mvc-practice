package org.conan;

public class Battery implements Chargeable {
    private final String mode = "유선";

    public String getMode(){
        return mode;
    }
}
