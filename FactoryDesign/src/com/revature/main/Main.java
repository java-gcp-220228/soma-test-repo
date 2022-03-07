package com.revature.main;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        OSFactory OSF = new OSFactory();
        OS win = OSF.FindOSType("windows");
        win.OSType();

        OS and = OSF.FindOSType("andriod");
        and.OSType();

        OS ios = OSF.FindOSType("ios");
        ios.OSType();

    }
}
