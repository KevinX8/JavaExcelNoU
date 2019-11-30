package com.kevinx8;

public class Driver {
    public static void main(String[] args) {
        RoutineA();

    }
    public static void RoutineA() {
        ExcelRemake SpreadSheet1 = new ExcelRemake();
        SpreadSheet1.initialise();
        ExcelRemake SpreadSheet2 = new ExcelRemake();
        SpreadSheet2.initialise();
        System.out.println("Routine A");
        SpreadSheet1.Display(); //1st
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display(); //2nd
        //System.out.printf();
        System.out.printf("%d\n%d\n%d\n"
                , SpreadSheet1.remove("ShEEt1")
                , SpreadSheet1.remove("sheet2")
                , SpreadSheet1.remove("sheet3")
        );
        System.out.println("First three sheets were removed");
        SpreadSheet1.Display(); //3rd
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display(); //4th
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("sheet5", "ClassList"));
        SpreadSheet1.Display(); //5th
        System.out.printf("%d\n%d\n"
                , SpreadSheet1.remove("Sheet4")
                , SpreadSheet1.remove("sheet6")
        );
        SpreadSheet1.Display(); //6th
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //7
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //8
        SpreadSheet1.Display(); //7th
        System.out.printf("Sheet at index %d renamed\n", SpreadSheet1.rename("sheet8", "TimeTable"));
        SpreadSheet1.Display(); //8th
        System.out.printf("%d\n%d\n"
                , SpreadSheet1.remove("ShEEt7")
                , SpreadSheet1.remove("ClAsSlIsT")
        );
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //9
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add()); //10
        System.out.printf("Sheet at index %d moved to index 1, Sheet at index %d moved to index 0\n", SpreadSheet1.move("Sheet9", "Timetable", true), SpreadSheet1.move("Sheet10", "Sheet9", true));
        SpreadSheet1.Display(); //9th
        System.out.printf("Sheet added: %b\n", SpreadSheet1.add());
        SpreadSheet1.Display(); //10th
    }
    public static void RoutineB() {
        
    }
}
