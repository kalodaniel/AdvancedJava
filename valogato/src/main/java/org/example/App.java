package org.example;

public class App 
{
    private static void printGoodUniversityCitizens(PersonChecker[] citizens){
        for (PersonChecker citizen : citizens){
            if (citizen.isOk()){
                System.out.println(citizen);
            }
        }
    }

    public static void main( String[] args ) {

        PersonChecker[] citizens = new PersonChecker[6];

        citizens[0] = new Student("Student 1",22,2,3.4F);
        citizens[1] = new Teacher("Teacher 1",62,120);
        citizens[2] = new Student("Student 2",22,0,4.5F);
        citizens[3] = new Student("Student 3",22,2,5F);
        citizens[4] = new Teacher("Teacher 2",62,20);
        citizens[5] = new Student("Student 4",22,2,3.4F);

        printGoodUniversityCitizens(citizens);

    }
}
