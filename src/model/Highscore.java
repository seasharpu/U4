package model;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors¨
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Highscore {
    private String[] arrayScores = new String[10];

    public Highscore() {

    }

    public String[] getArrayScores() {
        return arrayScores;
    }

    public void setArrayScores(String[] arrayScores) {
        this.arrayScores = arrayScores;
    }

      public void readScoreboard() {
        try {
          File myObj = new File("./src/model/highscore.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            for (char c : data.toCharArray()) {
             System.out.print(Character.getNumericValue(c));
              if (Character.isDigit(c)) {
                  System.out.print(Character.getNumericValue(c));
              }
          }

            for(int i = 0; i < arrayScores.length; i++){
              if(arrayScores[i] == null){
                arrayScores[i] = data;
                break;
              }
            }
          }
          myReader.close();
    
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }
    

  public void printScoreboard(String name, int score) {
    for(int i = 0; i < arrayScores.length; i++){
      if(arrayScores[i] == null){
        arrayScores[i] = name + " , " + score;
        break;
      }
    }
    try {
     // FileWriter myWriter = new FileWriter("./src/model/highscore.txt");
      BufferedWriter writer = new BufferedWriter(new FileWriter("./src/model/highscore.txt"));
      for(int i = 0; i < arrayScores.length; i++){
        if(arrayScores[i] != null){
          writer.write(arrayScores[i]);
          writer.newLine();
        }
      }
      
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

}




}
