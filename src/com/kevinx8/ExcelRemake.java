package com.kevinx8;
// Paulis Gributs 19250568
// Josh McGiff
// Not Sean lol
public class ExcelRemake {
    public String[] sheets = new String[256];
    public int lastAdded = 0, amountOfSheets = 0;
    public void initialise() {
        add();
        add();
        add();
    }
    public boolean add() {
        if (amountOfSheets <= 256) {
            while (index("Sheet" + (lastAdded + 1)) != -1) {
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
    public int move(String from, String to,boolean before) {
        int temp = index(to);
        int temp2, range;
        if(index(from) != -1  && index(to) != -1 && !from.equalsIgnoreCase(to) ) {
            if (before) {
                range = temp;
            } else {
                range = temp +1;
            }
                for (int i = amountOfSheets - 1; i >= range; i--) {
                    sheets[i + 1] = sheets[i];
                }
                amountOfSheets++; //accounts for remove function reducing amountofsheets but during a move net size change is zero
                temp2 = index(from); //stored temporarily so that remove doesn't remove the new sheet below
                sheets[range] = sheetName(temp2);
            remove(temp2);
            return range;
        } else {
            return -1;
        }
    }
    public String move(int from, int to, boolean before) {
        String temp2 = sheetName(from);
        int temp3, range;
        if(sheetName(to) != null  && sheetName(from) != null && from != to ) {
            if (before) {
                range = to;
            } else {
                range = to + 1;
            }
                for (int i = amountOfSheets - 1; i >= range; i--) {
                    sheets[i + 1] = sheets[i];
                }
                amountOfSheets++; //accounts for remove function reducing amountofsheets but during a move net size change is zero
                temp3 = index(temp2); //same as in other move
                sheets[range] = temp2;
            remove(temp3);
            return temp2;
        } else {
            return null;
        }
    }
    public int moveToEnd(String from) {
        int temp = index(from);
        if (temp != -1) {
            move(from, sheetName(amountOfSheets - 1), false);
            return temp;
        } else {
            return -1;
        }
    }
    public String moveToEnd(int from) {
        String temp = sheetName(from);
        if(sheetName(from) != null){
            move(from, amountOfSheets - 1, false);
            return temp;
        } else {
            return null;
        }
    }
    public int rename(String currentName, String newName) {
        if(index(currentName) != -1 && index(newName) == -1){
            sheets[index(currentName)] = newName;
            return index(newName);
        } else {
            return -1;
        }
    }
    public String sheetName(int index){
        if(index >= 0 && index < sheets.length){
            return sheets[index];
        } else {
            return null;
        }
    }
    public int index(String sheetName){
        int i;
        for (i = 0; i < amountOfSheets; i++) {
            if (sheets[i].equalsIgnoreCase(sheetName)) {
                return i;
            }
        }
        return -1;
    }

    public void Display(){
        String output = "[";
        for (int i = 0; i < amountOfSheets; i++) {
            output += sheets[i] + ", ";
        }
        System.out.println(output.substring(0,output.length() -2) + "]");
    }
    public String remove(int index){
        int i;
        String temp = sheetName(index);
        if (amountOfSheets > 1 && sheetName(index) !=null) {
            for(i=index; i < amountOfSheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            sheets[amountOfSheets] = null;
            amountOfSheets--;
            return temp;
        } else {
            return null;
        }
    }
    public int remove(String sheetName) {
        int i;
        int temp = index(sheetName);
        if (amountOfSheets > 1 && index(sheetName) != -1) {
            for(i=index(sheetName); i < amountOfSheets; i++ ) {
                sheets[i] = sheets[i+1];
            }
            sheets[amountOfSheets] = null;
            amountOfSheets--;
            return temp;
        } else {
            return -1;
        }
    }
    public int length() {
        return amountOfSheets;
    }
}