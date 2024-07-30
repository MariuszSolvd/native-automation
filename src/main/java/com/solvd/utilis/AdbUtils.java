package com.solvd.utilis;

import java.io.IOException;

public class AdbUtils {

    public static void setSystemLanguage(String language) {
        executeCommand("adb shell setprop persist.sys.locale " + language);
    }

    private static void executeCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
