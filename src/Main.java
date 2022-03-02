import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name, deadLine, dueDate;
        int priority, count = 0;

        Task[] taskList = new Task[10];

        File binaryFile = new File("Task.dat");
        System.out.println("Previously saved Tasks from binary file:");
        if (binaryFile.exists() && binaryFile.length() > 1L) {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                taskList = (Task[]) fileReader.readObject();
                while (taskList[count] != null)
                    System.out.println(taskList[count++]);
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // write your code here
        }
        else
            System.out.println("[None, please enter new Tasks]");

        do{
            System.out.print("Please enter task name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            if (name.equalsIgnoreCase("quit"))
                break;
            System.out.print("Please enter due date (in form MM/DD/YYYY): ");
            dueDate = keyboard.nextLine();
            System.out.print("Please enter deadline : ");
            deadLine = keyboard.nextLine();
            System.out.print("Please enter priority: ");
            priority = keyboard.nextInt();


            taskList[count++] = new Task(name, dueDate, deadLine, priority);

            keyboard.nextLine();


        } while(true);
    try {
        ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
        fileWriter.writeObject(taskList);
        fileWriter.close();
    }catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
}
