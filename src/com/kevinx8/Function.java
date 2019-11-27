package com.kevinx8;

import java.util.Arrays;
//remove static everywhere later
public class Function {
    public static String[] sheets = new String[256];
    public static int lastAdded = 0, amountOfSheets = 0;

    public static boolean add() {
        if (amountOfSheets <= 256) {
            while (Function.index("Sheet" + (lastAdded + 1)) != -1) {
                lastAdded++;
            }
            sheets[amountOfSheets] = "Sheet" + (lastAdded + 1);
            amountOfSheets++;
            lastAdded++;
            return true;
        } else {
            return false;
        }
    }
    public static int move(String from, String to,boolean before) {
        int temp = index(to);
        int temp2 = 0, range = 0;
        if(index(from) != -1  && index(to) != -1 && !from.equalsIgnoreCase(to) ) {
            if (before) {
                range = temp;
                temp--;
            } else {
                range = temp +1;
            }
                for (int i = amountOfSheets - 1; i >= range; i--) {
                    sheets[i + 1] = sheets[i];
                }
                amountOfSheets++;
                temp2 = index(from);
                sheets[range] = sheetName(temp2);
            remove(temp2);
            return temp;
        } else {
            return -1;
        }
    }
    public static String move(int from, int to, boolean before) {
        String temp = sheetName(to);
        String temp2 = sheetName(from);
        int temp3 =0, range = 0;
        if(sheetName(to) != null  && sheetName(from) != null && from != to ) {
            if (before) {
                range = to;
            } else {
                range = to + 1;
            }
                for (int i = amountOfSheets - 1; i >= range; i--) {
                    sheets[i + 1] = sheets[i];
                }
                amountOfSheets++;
                temp3 = index(temp2);
                sheets[range] = temp2;
            remove(temp3);
            return temp;
        } else {
            return null;
        }
    }
    public static int moveToEnd(String from) {
       int temp = index(from);
        if(temp != -1){
           move(from, sheetName(amountOfSheets - 1), false);
            return temp;
        } else {
            return -1;
        }
        }


    public static String moveToEnd(int from) {
        String temp = sheetName(from);
        if(sheetName(from) != null){
            move(from, amountOfSheets - 1, false);
            return temp;
        } else {
            return null;
        }

    }
    public static int rename(String currentName, String newName) {
        if(index(currentName) != -1 && index(newName) == -1){
            sheets[index(currentName)] = newName;
            return index(newName);
        }   else{
            return -1;
        }

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
        for (i = 0; i < amountOfSheets; i++) {
            if (sheets[i].equalsIgnoreCase(sheetName)) {
                return i;
            }
        }
        return -1;
    }

    public static void Display(){
        //System.out.println(Arrays.asList(sheets).subList(0,amountOfSheets));
        for (int i = 0; i < amountOfSheets; i++) {
            System.out.print(sheets[i] + " ");
        }
        System.out.println(); //remove this later
    }

    public static String remove(int index){
        int i;
        String temp = sheetName(index);
        if (amountOfSheets > 1 && sheetName(index) !=null) {
            for(i=index; i < amountOfSheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            sheets[amountOfSheets] = null;
            amountOfSheets--;
            return temp;
        }else {
            return null;
        }
    }
    public static int remove(String sheetName) {
        int i;
        int temp = index(sheetName);
        if (amountOfSheets > 1 && index(sheetName) != -1) {
            for(i=index(sheetName); i < amountOfSheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            sheets[amountOfSheets] = null;
            amountOfSheets--;
            return temp;
        }else {
            return -1;
        }
    }
    public static int length() {
        return amountOfSheets;
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
