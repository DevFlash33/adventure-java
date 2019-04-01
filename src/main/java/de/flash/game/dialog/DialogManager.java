package de.flash.game.dialog;

public final class DialogManager {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void printMessage(final String msg) {
        System.out.println(ANSI_RESET + msg);
    }
    public static void printFightMessage(final String msg) {
        System.out.println(ANSI_RED + msg);
    }
}
