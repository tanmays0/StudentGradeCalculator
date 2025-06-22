import java.util.*;
public class StudentGradeCalculator
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the Student Grade Calculator!");
        boolean continueCalculation=true;
        while(continueCalculation)
        {
            System.out.println();
            System.out.print("Enter student's name: ");
            String studentName=sc.nextLine().trim();
            int numberOfSubjects=0;
            while(true)
            {
                System.out.print("Enter the number of subjects for " + studentName + ": ");
                try
                {
                    numberOfSubjects=Integer.parseInt(sc.nextLine());
                    if(numberOfSubjects <= 0)
                    {
                        System.out.println("Number of subjects must be positive.");
                    }
                    else
                    {
                        break;
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Please enter a valid integer.");
                }
            }
            String[] subjects=new String[numberOfSubjects];
            int[] marks=new int[numberOfSubjects];
            int totalMarks=0;
            for(int i=0;i<numberOfSubjects;i++)
            {
                System.out.print("Enter name of subject " +(i+1)+ ": ");
                subjects[i]=sc.nextLine().trim();
                int mark=-1;
                while(true)
                {
                    System.out.print("Enter marks obtained in " + subjects[i] + " (0-100): ");
                    try
                    {
                        mark=Integer.parseInt(sc.nextLine());
                        if(mark<0||mark>100)
                        {
                            System.out.println("Marks must be between 0 and 100.");
                        }
                        else
                        {
                            break;
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Please enter a valid integer.");
                    }
                }
                marks[i]=mark;
                totalMarks += mark;
            }
            double averagePercentage=(double) totalMarks/numberOfSubjects;
            char grade=calculateGrade(averagePercentage);
            String remark=generateRemark(grade);
            printReport(studentName, subjects, marks, totalMarks, averagePercentage, grade, remark);
            System.out.print("\nDo you want to calculate grades for another student? (yes/no): ");
            String response=sc.nextLine().trim().toLowerCase();
            continueCalculation=response.equals("yes")||response.equals("y");
        }
        System.out.println("Thank you for using Student Grade Calculator.");
        sc.close();
    }
    private static char calculateGrade(double average)
    {
        if(average>=90) return 'A';
        else if (average>=80) return 'B';
        else if (average>=70) return 'C';
        else if (average>=60) return 'D';
        else return 'F';
    }
    private static String generateRemark(char grade)
    {
        switch(grade)
        {
            case 'A': return "Excellent performance! Keep it up!";
            case 'B': return "Very Good! You are doing great.";
            case 'C': return "Good! There's room for improvement.";
            case 'D': return "Fair. Work harder for better results.";
            case 'F': return "Failed. Please put in more effort and ask for help.";
            default: return "";
        }
    }
    private static void printReport(String studentName, String[] subjects, int[] marks, int totalMarks, double average, char grade, String remark)
    {
        System.out.println();
        System.out.println("----- Grade Report for " + studentName + " -----");
        System.out.printf("%-20s %10s%n", "Subject", "Marks");
        System.out.println("-------------------------------");
        for(int i=0;i<subjects.length;i++)
        {
            System.out.printf("%-20s %10d%n", subjects[i], marks[i]);
        }
        System.out.println("-------------------------------");
        System.out.printf("%-20s %10d%n", "Total Marks:", totalMarks);
        System.out.printf("%-20s %9.2f%%%n", "Average Percentage:", average);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remark);
        System.out.println("-------------------------------");
    }
}