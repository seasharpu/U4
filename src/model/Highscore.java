package model;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors¨
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Highscore {
    private String[] arrayScores = new String[10];
    private String[] names;
    private String[] scores = new String[10];

    private int amountPlayers = 0;

    public Highscore() {

    }

    public String[] getArrayScores() {
        return arrayScores;
    }

    public void setArrayScores(String[] arrayScores) {
        this.arrayScores = arrayScores;
    }

    public void countAmountPlayersOnList() {
        try {
          File myObj = new File("./src/model/names.txt");
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            amountPlayers++;
          }
          myReader.close();
    
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    public void readNames() {
      names = new String[amountPlayers];

      try {
        File myObj = new File("./src/model/names.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String name = myReader.nextLine();

          for(int i = 0; i < names.length; i++){
            if(names[i] == null){
              names[i] = name;
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
  
    public void readScores(){
      scores = new String[amountPlayers];

      try {
        File myObj = new File("./src/model/scores.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String score = myReader.nextLine();

          for(int i = 0; i < scores.length; i++){
            if(scores[i] == null){
              scores[i] = score;
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

      
  public void sortTheArrays() {
    //creating an instance of an array  
    //sorting logic  
    for (int i = 0; i < scores.length; i++){  
      for (int j = i + 1; j < scores.length; j++){  
        String tmpScore;  
        String tempName;

        if(scores[i] != null && scores[j] != null){
          int parsedScoreI = Integer.parseInt(scores[i]);
          int parsedScoreJ = Integer.parseInt(scores[j]);

          if (parsedScoreI > parsedScoreJ){  
            tmpScore = scores[i];  
            tempName = names[i];
  
            scores[i] = scores[j];  
            names[i] = names[j];
  
            scores[j] = tmpScore;  
            names[j] = tempName;
          }
        }
      }   
    } 
  
  }

  public void writeToArrayScores(){
    for(int i = 0; i < amountPlayers; i++){
      if(i <= 9){
        if(arrayScores[i] == null){
          arrayScores[i] = names[i] + ", " + scores[i];
        }
      }
    }
  }

  public void printScoreboard(String name, int score) {

    //Creates a temporary name and score array to updates the names and scores array
    String[] namesToPrint = new String[amountPlayers+1];
    String[] scoresToPrint = new String[amountPlayers+1];

    for(int i = 0; i < names.length; i++){
      if(namesToPrint[i] == null){
        namesToPrint[i] = names[i];
        scoresToPrint[i] = scores[i];
      }
    }

    names = namesToPrint;
    scores = scoresToPrint;

    //Adds the lastest players name and score to the names and scores array
    for (int i = 0; i < names.length; i++) {
      if(names[i] == null){
        names[i] = name;
        scores[i] = Integer.toString(score);
        break;
      }
    }

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("./src/model/names.txt"));
      for(int i = 0; i < names.length; i++){
        if(names[i] != null){
          writer.write(names[i]);
          writer.newLine();
        }
      }
      
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    try {
       BufferedWriter writer = new BufferedWriter(new FileWriter("./src/model/scores.txt"));
       for(int i = 0; i < scores.length; i++){
         if(scores[i] != null){
           writer.write(scores[i]);
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
