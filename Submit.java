import java.io.*;
import java.net.*;
import java.util.*;

public class Submit
{
  public static void main(String[] args) throws IOException
  {
    String[] requiredFiles = {"BubbleSort.java", "BucketSort.java", "ListNode.java",
      "Location.java", "Main.java", "Quicksort.java", "RadixSort.java",
      "SortMonster.java"};
    String[] filesToSend = {"Location.java", "BubbleSort.java",
      "Quicksort.java", "RadixSort.java"};
    
    for (String fileName : requiredFiles)
      if (!new File(fileName).exists())
      throw new RuntimeException("file \"" + fileName + "\" not found in folder"); 
    
    Scanner userInput = new Scanner(System.in);
    
    //submit
    String name;
    do
    {
      System.out.print("Name:  ");
      name = userInput.nextLine();
    }
    while (name.equals(""));
    String password;
    do
    {
      System.out.print("Password:  ");
      password = userInput.nextLine();
    }
    while(name.equals(""));
    Socket socket = new Socket(Integer.parseInt(password.substring(0, 2), 16) + "." +
                               Integer.parseInt(password.substring(2, 4), 16) + "." +
                               Integer.parseInt(password.substring(4, 6), 16) + "." +
                               Integer.parseInt(password.substring(6), 16), 1216);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println(name);
    String receivedName = in.readLine();
    System.out.println("received name:  " + receivedName);
    if (!receivedName.equals(name))
      throw new RuntimeException("received name \"" + receivedName + "\" does not match sent name \"" + name + "\"");
    int lineCount = 0;
    for (String fileName : filesToSend)
    {
      BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
      String line = fileIn.readLine();
      while (line != null)
      {
        out.println(line);
        String receivedLine = in.readLine();
        if (!receivedLine.equals(line))
          throw new RuntimeException("received line \"" + receivedLine + "\" does not match sent line \"" + line + "\"");
        lineCount++;
        System.out.print(".");
        if (lineCount % 40 == 0)
          System.out.println();
        line = fileIn.readLine();
      }
      fileIn.close();
      System.out.println("Submitted " + fileName);
    }
    out.println("%#aenb'8x7{M.F7#");
    in.close();
    out.close();
    socket.close();
    System.out.println("\nSubmitted all files"); 
  }
}