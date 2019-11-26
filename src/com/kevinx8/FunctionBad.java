package com.kevinx8;

import java.util.ArrayList;
import java.util.Collections;


public class FunctionBad {
    public static ArrayList<String> sheets = new ArrayList<String>(Collections.nCopies(255, ""));
    public static int lastadded = 0,amountofsheets = 0;
    public static boolean add() {
        if (amountofsheets != 256) {
            sheets.set(lastadded, "Sheet" + (lastadded+1));
           // sheets.add("Sheet" + (lastadded + 1));
            amountofsheets++;
            lastadded++;
            return true;
        } else {
            return false;
        }
    }
    public static int remove(String sheetName) {
       // sheetName = sheetName.toLowerCase();
        if (sheets.size() > 1) {
            int toberemoved = sheets.indexOf(sheetName);
            sheets.remove(sheetName);
            amountofsheets--;
             return toberemoved;
        } else {
            return -1;
        }
    }
    public static String remove(int index) {
        if (index >= 0 && index <= 255 && amountofsheets != 1) {
            String tempr = sheets.get(index);
            sheets.remove(index);
            amountofsheets--;
            return tempr;
        } else {
            return null;
        }
    }
    public static int move(String from, String to, boolean before) {
     if (before && !from.equalsIgnoreCase(to) && sheets.contains(from) && sheets.contains(to)) {
         remove(from); // Dunno if this is necessary as not mentioned in spec but it is implied by the name "move"
         sheets.set((sheets.indexOf(to) - 1), from);
        return (sheets.indexOf(from));
     } else if (!before && !from.equalsIgnoreCase(to) && sheets.contains(from) && sheets.contains(to)) {
            remove(from);
            sheets.set(sheets.indexOf(to)+1, from);
            amountofsheets++;
            return sheets.indexOf(from);
     } else {
         return -1;
        }
    }
    public static String move(int from, int to, boolean before) {
        if (from < sheets.size() || to < sheets.size()) {
            String tomove;
            tomove = sheets.get(from);
            if (before && sheets.get(from) != null && sheets.get(to) != null) {
                remove(from);
                sheets.set(to - 1, tomove);
                return tomove;
            } else if (!before && sheets.get(from) != null && sheets.get(to) != null) {
                remove(from);
                sheets.set(to + 1, tomove);
                amountofsheets++;
                return tomove;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    public static String moveToEnd(int from) {
        if (from >= 0 && from <= 254) {
            sheets.set(amountofsheets+ 1,sheets.get(from));
            remove(from);
            amountofsheets++;
            return sheets.get(from);
        } else {
            return null;
        }
    }
    public static int moveToEnd(String from) {
        if (sheets.contains(from)) {
            sheets.set(amountofsheets+ 1, from);
            remove(from);
            amountofsheets++;
            return sheets.indexOf(from);
        } else {
            return -1;
        }
    }
    public static int rename(String currentName, String newName) {
        if (sheets.stream().anyMatch(currentName::equalsIgnoreCase) && !sheets.contains(newName) && newName.length() > 1) {
           sheets.set(sheets.indexOf(currentName), newName);
           return sheets.indexOf(newName);
        } else {
            return -1;
        }
    }
    public static int index(String sheetName) {
        if (sheets.stream().anyMatch(sheetName::equalsIgnoreCase)) {
         return sheets.indexOf(sheetName);
        } else {
            return -1;
        }
    }
    public static String sheetName(int index) {
        if (index >=0 && index < 256 && index < amountofsheets) {
            return sheets.get(index);
        } else {
            return null;
        }
    }
    public static void Display() {
        ArrayList<String> sheetsNoNulls = new ArrayList<String>(sheets);
        sheetsNoNulls.removeAll(Collections.singleton(""));
        System.out.println(sheetsNoNulls); //not sure if all elements should be listed including null ones
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
