import java.util.ArrayList;
import java.util.Scanner;

class StudySession {
    String subject;
    String day;
    String time;
    double hours;

    StudySession(String subject, String day, String time, double hours) {
        this.subject = subject;
        this.day = day;
        this.time = time;
        this.hours = hours;
    }

    void display() {
        System.out.println(
            day + " | " + time + " | " + subject + " | " + hours + " hours"
        );
    }
}

public class StudyTimeTablePlanner {

    static ArrayList<StudySession> timetable = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addSession() {
        System.out.print("Enter subject: ");
        String subject = sc.nextLine();

        System.out.print("Enter day: ");
        String day = sc.nextLine();

        System.out.print("Enter time: ");
        String time = sc.nextLine();

        System.out.print("Enter study hours: ");
        double hours = sc.nextDouble();
        sc.nextLine();

        timetable.add(new StudySession(subject, day, time, hours));

        System.out.println("Study session added successfully!");
    }

    

    static void totalStudyHours() {
        double total = 0;

        for (StudySession session : timetable) {
            total += session.hours;
        }

        System.out.println("Total Study Hours: " + total + " hours");
    }

    static void highestStudySubject() {
        if (timetable.isEmpty()) {
            System.out.println("No sessions available.");
            return;
        }

        StudySession highest = timetable.get(0);

        for (StudySession session : timetable) {
            if (session.hours > highest.hours) {
                highest = session;
            }
        }

        System.out.println(
            "Subject with highest study time: " +
            highest.subject + " (" + highest.hours + " hours)"
        );
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT STUDY TIME TABLE PLANNER =====");
            System.out.println("1. Add Study Session");
            System.out.println("2. View Time Table");
            System.out.println("3. Calculate Total Study Hours");
            System.out.println("4. Find Highest Study Time");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addSession();
                    break;

                case 2:
                    displayTimetable();
                    break;

                case 3:
                    totalStudyHours();
                    break;

                case 4:
                    highestStudySubject();
                    break;

                case 5:
                    System.out.println("Thank you for using the planner!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}