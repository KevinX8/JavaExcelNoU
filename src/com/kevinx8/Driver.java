package com.kevinx8;
// Paulis Gributs 19250568
// Josh McGiff
// Not Sean lol
public class Driver {
    public static void main(String[] args) {
        RoutineA();
        RoutineB();
        RoutineGaeilge();
        RoutineGaeilgeButInEnglish();

    }
    public static void RoutineA() {
        ExcelRemake SpreadSheet1 = new ExcelRemake();
        SpreadSheet1.initialise();
        System.out.println("Routine A");
        SpreadSheet1.Display(); //1st
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display(); //2nd
        System.out.printf("Sheet1 removed from position %d\nSheet2 removed from position %d\nSheet3 removed from position %d\n"
                , SpreadSheet1.remove("ShEEt1") +1
                , SpreadSheet1.remove("sheet2") +1
                , SpreadSheet1.remove("sheet3") +1
        );
        SpreadSheet1.Display(); //3rd
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display(); //4th
        System.out.printf("Sheet at position %d renamed\n", SpreadSheet1.rename("sheet5", "ClassList")+1);
        SpreadSheet1.Display(); //5th
        System.out.printf("Sheet4 removed from position %d\nSheet6 removed from position %d\n"
                , SpreadSheet1.remove("Sheet4") +1
                , SpreadSheet1.remove("sheet6") +1
        );
        SpreadSheet1.Display(); //6th
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //7
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //8
        SpreadSheet1.Display(); //7th
        System.out.printf("Sheet at position %d renamed\n", SpreadSheet1.rename("sheet8", "TimeTable")+1);
        SpreadSheet1.Display(); //8th
        System.out.printf("Sheet7 removed from position %d\nClassList removed from position %d\n"
                , SpreadSheet1.remove("ShEEt7") +1
                , SpreadSheet1.remove("ClAsSlIsT") +1
        );
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //9
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //10
        System.out.printf("Sheet at position 2 moved to position %d, Sheet at position 3 moved to position %d\n", SpreadSheet1.move("Sheet9", "Timetable", true)+1, SpreadSheet1.move("Sheet10", "Sheet9", true)+1);
        SpreadSheet1.Display(); //9th
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display(); //10th
    }

    public static void RoutineB() {
        ExcelRemake SpreadSheet1 = new ExcelRemake();
        SpreadSheet1.initialise();
        System.out.println("Routine B");
        SpreadSheet1.Display();
        SpreadSheet1.move("sheet3", "sheet1", true);
        SpreadSheet1.Display();
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display();
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet3", "Clean"));
        SpreadSheet1.moveToEnd("cLeAN");
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet1", "Bandit"));
        SpreadSheet1.moveToEnd(0);
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet2", "is"));
        SpreadSheet1.moveToEnd("iS");
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet4", "the"));
        SpreadSheet1.moveToEnd(0);
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet5", "best"));
        SpreadSheet1.moveToEnd("bESt");
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet6", "band"));
        SpreadSheet1.moveToEnd(0);
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet7", "in"));
        SpreadSheet1.moveToEnd("iN");
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet8", "da"));
        SpreadSheet1.moveToEnd(0);
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet9", "world"));
        SpreadSheet1.moveToEnd("WorLD");
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet10", "!"));
        SpreadSheet1.moveToEnd(0);
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("Sheet11", ":)"));
        SpreadSheet1.moveToEnd(0);
        SpreadSheet1.Display();
    }

    public static void RoutineGaeilge() {
        ExcelRemake SpreadSheet1 = new ExcelRemake();
        SpreadSheet1.initialise();
        ExcelRemake SpreadSheet2 = new ExcelRemake();
        SpreadSheet2.initialise();
        System.out.println("Céim C");
        System.out.printf("Buileog curtha i SpreadSheet1: %b\n", SpreadSheet1.add());
        System.out.printf("Buileog curtha i SpreadSheet1: %b\n", SpreadSheet1.add());
        System.out.printf("Buileog curtha i SpreadSheet1: %b\n", SpreadSheet1.add());
        System.out.printf("%d is ea an méid buileog atá i SpreadSheet1\n", SpreadSheet1.length());
        SpreadSheet1.Display();
        System.out.printf("%d is ea an áit in a bhfuil Sheet3\n", SpreadSheet1.index("Sheet3") + 1);
        int userInput = 5;
        userInput--;
        System.out.printf("%d is ea an áit ina bhfuil %s\n", userInput + 1, SpreadSheet1.sheetName(userInput));
        System.out.printf("Buileog curtha i SpreadSheet2: %b\n", SpreadSheet2.add());
        System.out.printf("Buileog ag %d tugtha \n", SpreadSheet2.rename("Sheet4", "ThisNotInSpreadSheet1"));
        System.out.println("Seo é Spreadsheet1: ");
        SpreadSheet1.Display();
        System.out.println("Seo é Spreadsheet2: ");
        SpreadSheet2.Display();
    }

    public static void RoutineGaeilgeButInEnglish() {
        ExcelRemake SpreadSheet1 = new ExcelRemake();
        SpreadSheet1.initialise();
        ExcelRemake SpreadSheet2 = new ExcelRemake();
        SpreadSheet2.initialise();
        System.out.println("Routine C");
        System.out.printf("Sheet added to Spreadsheet1: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added to Spreadsheet1: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added to Spreadsheet1: %b\n", SpreadSheet1.add());
        System.out.printf("%d is the amount of sheets in SpreadSheet1\n", SpreadSheet1.length());
        SpreadSheet1.Display();
        System.out.printf("%d is the position of Sheet3 in SpreadSheet1.\n", SpreadSheet1.index("Sheet3") + 1);
        int userInput = 5; //user's input
        userInput--; //converts user input to Java index offset
        System.out.printf("Sheet at position %d is %s in SpreadSheet1\n", userInput + 1, SpreadSheet1.sheetName(userInput));
        System.out.printf("Sheet added to Spreadsheet2: %b\n", SpreadSheet2.add());
        System.out.printf("Sheet at index %d renamed in SpreadSheet2\n", SpreadSheet2.rename("Sheet4", "ThisNotInSpreadSheet1"));
        System.out.printf("Sheet %s moved to index 0 in Spreadsheet2\n", SpreadSheet2.move(3,0,true));
        System.out.println("This is Spreadsheet1: ");
        SpreadSheet1.Display();
        System.out.println("This is Spreadsheet2: ");
        SpreadSheet2.Display();
    }
}