package com.kevinx8;

import java.util.Arrays;
//remove static everywhere later
public class Function {
    public static String[] sheets = new String[256];
    public static int lastadded = 0, amountofsheets = 0;

    public static boolean add() {
        if (amountofsheets <= 256) {
            while (Function.index("Sheet" + (lastadded + 1)) != -1) {
                lastadded++;
            }
            sheets[amountofsheets] = "Sheet" + (lastadded + 1);
            amountofsheets++;
            lastadded++;
            return true;
        } else {
            return false;
        }
    }
    public static int move(String from, String to,boolean before) {
        return -1;

    }
    public static String move(int from, int to, boolean before) {
        return null;

    }
    public static int moveToEnd(String from) {
        return -1;

    }
    public static String moveToEnd(int from) {
        return null;

    }
    public static int rename(String currentName, String newName) {
        return -1;

    }
    public static String sheetName(int index){
        if(index >= 0 && index < sheets.length){
            return sheets[index];
        } else {
            return null;
        }
    }

    public static int index(String sheetName){
        int i;
        int index = -1;
        for (i = 0; i < amountofsheets; i++) {
            if (sheets[i].equalsIgnoreCase(sheetName)) {
                return i;
            }
        }
        return -1;
    }

    public static void Display(){
        //System.out.println(Arrays.asList(sheets).subList(0,amountofsheets));
        for (int i = 0; i < amountofsheets; i++) {
            System.out.print(sheets[i] + " ");
        }
        System.out.println(); //remove this later
    }

    public static String remove(int index){
        int i;
        String temp = sheetName(index);
        if (amountofsheets > 1 && sheetName(index) !=null) {
            for(i=index; i < amountofsheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            amountofsheets--;
            sheets[i+1] = null;
            return temp;
        }else {
            return null;
        }
    }
    public static int remove(String sheetName) {
        int i;
        int temp = index(sheetName);
        if (amountofsheets > 1 && index(sheetName) != -1) {
            for(i=index(sheetName); i < amountofsheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            amountofsheets--;
            sheets[i+1] = null;
            return temp;
        }else {
            return -1;
        }
    }
    public static int length() {
        return amountofsheets;
    }
    public static void Help(String arg) {
        boolean helpall = arg.equalsIgnoreCase("all");
        boolean validcmd = false;
        if (arg.equalsIgnoreCase("add") || helpall) {
            System.out.println("add : adds a sheet to the sheetpad");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("remove") || helpall) {
            System.out.println("remove <index/name>: removes the specified sheet by index or by name");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("move") || helpall) {
            System.out.println("move <index/name> <index/name> <before> : Moves a sheet to the position before or after the target based on the before flag");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("moveToEnd") || helpall) {
            System.out.println("moveToEnd <index/name> : Moves a sheet after the last sheet in the sheetpad");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("rename") || helpall) {
            System.out.println("rename <index/name> <index/name> : renames a sheet if the name doesn't already exist");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("index") || helpall) {
            System.out.println("index <name> : finds the index of a sheet");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("sheetName") || helpall) {
            System.out.println("sheetName <index> : finds the sheet at that index");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("display") || helpall) {
            System.out.println("display : shows the contents of the sheetpad");
            validcmd = true;
        }
        if (arg.equalsIgnoreCase("length") || helpall) {
            System.out.println("length : shows the length of the sheetpad");
            validcmd = true;
        }
        if (!validcmd) {
            System.out.println("not a valid command");
        }
    }
}
