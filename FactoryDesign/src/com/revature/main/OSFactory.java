package com.revature.main;

import java.awt.*;

public class OSFactory {

    public OS FindOSType(String strOS) {

        if (strOS.equals("ios"))
            return new Ios();
        else if (strOS.equals("windows"))
            return new windows();
        else if (strOS.equals("andriod"))
            return new Android();
        else return null;

        // return s
    }}