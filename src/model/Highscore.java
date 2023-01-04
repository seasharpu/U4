package model;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors¨
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Highscore {
    private String[] arrayScores;

    public Highscore(String[] arrayScores) {
        this.arrayScores = arrayScores;
    }

    public String[] getArrayScores() {
        return arrayScores;
    }

    public void setArrayScores(String[] arrayScores) {
        this.arrayScores = arrayScores;
    }


    
 String fileinfo;

      public void readScoreboard() {
        try {
          File myObj = new File("highscore.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            fileinfo += data;
          }
          myReader.close();
    
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }
    

  public void printScoreboard(String scoreToAdd) {
    try {
      FileWriter myWriter = new FileWriter("highscore.txt");
      myWriter.write(scoreToAdd);
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

}




}
