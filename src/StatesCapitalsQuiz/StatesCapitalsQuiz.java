/*

StatesCapitalsQuiz.java
StatesCapitalsQuiz

Written by Joey deVilla 2015-11-27.
Copyright © 2015 Joey deVilla. All rights reserved.
MIT License. See the end of the file for the gory details.

My friend needed help with another Java homework assignment, and he had his hands
full again. I rather had fun helping him the previous time, and I needed the Java
practice, so I said "Why not?"

The assignment: write a Java program that presents the user with the name of a U.S.
state and ask him/her to enter the name of that state's capital. If the user 
gets it right, display a pop-up window that shows the state flag.

I went one better: if the user gets it wrong, the program displays a pop-up window
that shows a "sad face" graphic. I also decided to use an iterator to make it simpler
to step through the set of states and capitals. My friend got full marks for the
solution, so I guess that using iterators wasn't beyond the scope of the assignment.

*/

package StatesCapitalsQuiz;

import javafx.geometry.Insets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class StatesCapitalsQuiz extends Application {
    
    // User interface controls
    Label questionLabel = new Label();
    TextField answerTextField  = new TextField();
    Button submitButton = new Button();
    Alert correctAnswerDialog = new Alert(AlertType.INFORMATION);
    Alert wrongAnswerDialog = new Alert(AlertType.INFORMATION);
    
    // Application data
    Map<String,String> statesAndCapitals = new HashMap<String,String>() {
        {
           put("Alabama", "Montgomery");
           put("Alaska", "Juneau");
           put("Arizona", "Phoenix");
           put("Arkansas", "Little Rock");
           put("California", "Sacramento");
           put("Colorado", "Denver");
           put("Connecticut", "Hartford");
           put("Delaware", "Dover");
           put("Florida", "Tallahassee");
           put("Georgia", "Atlanta");
           put("Hawaii", "Honolulu");
           put("Idaho", "Boise");
           put("Illinois", "Springfield");
           put("Indiana", "Indianapolis");
           put("Iowa", "Des Moines");
           put("Kansas", "Topeka");
           put("Kentucky", "Frankfort");
           put("Louisiana", "Baton Rouge");
           put("Maine", "Augusta");
           put("Maryland", "Annapolis");
           put("Massachusetts", "Boston");
           put("Michigan", "Lansing");
           put("Minnesota", "Saint Paul");
           put("Mississippi", "Jackson");
           put("Missouri", "Jefferson City");
           put("Montana", "Helena");
           put("Nebraska", "Lincoln");
           put("Nevada", "Carson City");
           put("New Hampshire", "Concord");
           put("New Jersey", "Trenton");
           put("New Mexico", "Santa Fe");
           put("New York", "Albany");
           put("North Carolina", "Raleigh");
           put("North Dakota", "Bismark");
           put("Ohio", "Columbus");
           put("Oklahoma", "Oklahoma City");
           put("Oregon", "Salem");         
           put("Pennsylvania", "Harrisburg");
           put("Rhode Island", "Providence");
           put("South Carolina", "Columbia");
           put("South Dakota", "Pierre");
           put("Tennessee", "Nashville");
           put("Texas", "Austin");
           put("Utah", "Salt Lake City");
           put("Vermont", "Montpelier");
           put("Virginia", "Richmond");
           put("Washington", "Olympia");
           put("West Virginia", "Charleston");
           put("Wisconsin", "Madison");
           put("Wyoming", "Cheyenne");
        }
    };
    
    // Program state
    // -------------
    // We use an interator to progress through our hashmap of states and capitals
    Iterator<Map.Entry<String, String>> stateCapitalsIterator = statesAndCapitals.entrySet().iterator();
    
    String currentState;
    String currentCapital;
    
    
    @Override
    public void start(Stage primaryStage) {
        questionLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        submitButton.setText("Submit answer");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                evaluateAnswer();
            }
        });
        
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 20, 10, 20));
        vbox.getChildren().addAll(questionLabel, answerTextField, submitButton);
        
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("States and Capitals");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // The UI's defined -- start the quiz!
        askQuestion();
    }

    /** 
     * Present the user with the next state in the list and ask him/her
     * the name of its capital.
     */
    private void askQuestion() {
        Map.Entry<String, String> stateCapitalPair = stateCapitalsIterator.next();
        currentState = stateCapitalPair.getKey();
        currentCapital = stateCapitalPair.getValue();
        questionLabel.setText("What is the capital of " + currentState + "?");
        answerTextField.setText("");
    }
    
    /**
     * Present a response to the user's answer
     */
    private void evaluateAnswer() {
        String userAnswer = answerTextField.getText().trim().toLowerCase();
        
        if (userAnswer.equals(currentCapital.toLowerCase())) {
            // The user got it right!
            // Present the "correct answer" dialog box, which displays
            // a congratulatory message and the state flag.
            correctAnswerDialog.setTitle("Correct!");
            correctAnswerDialog.setHeaderText("You are correct!");
            String flagFilename = "images/" + currentState.toLowerCase() + ".png";
            Image flagImage = new Image(flagFilename);
            ImageView flagImageView = new ImageView();
            flagImageView.setImage(flagImage);
            correctAnswerDialog.setGraphic(flagImageView);
            correctAnswerDialog.setContentText("The capital of " + currentState + " is " + currentCapital + ".");
            correctAnswerDialog.showAndWait();
        }
        else {
            // The user got it wrong.
            // Present the "wrong answer" dialog box, which displays
            // a "wrong" message and a "sad face" image.
            wrongAnswerDialog.setTitle("Wrong!");
            wrongAnswerDialog.setHeaderText("That's not right.");
            String sadFaceFilename = "images/sad-face.png";
            Image sadFaceImage = new Image(sadFaceFilename);
            ImageView sadFaceImageView = new ImageView();
            sadFaceImageView.setImage(sadFaceImage);
            wrongAnswerDialog.setGraphic(sadFaceImageView);
            wrongAnswerDialog.setContentText("The capital of " + currentState + " is " + currentCapital + ".");
            wrongAnswerDialog.showAndWait();
        }
        
        if (stateCapitalsIterator.hasNext()) {
            // If there are any states left, 
            // ask another states and capitals question.
            askQuestion();
        }
        else {
            // If we've run through all the states,
            // say goodbye.
            questionLabel.setText("Thanks for playing!");
            answerTextField.setText("Click the \"Exit\" button below to leave this program.");
            answerTextField.setDisable(true);
            
            // Change the button into one that
            // quits the program.
            submitButton.setText("Exit");
            submitButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.exit(0);
                }
            });                    
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}/*

This code is released under the MIT license.
Simply put, you're free to use this in your own projects, both
personal and commercial, as long as you include the copyright notice below.
It would be nice if you mentioned my name somewhere in your documentation
or credits.

MIT LICENSE
-----------
(As defined in https://opensource.org/licenses/MIT)

Copyright © 2015 Joey deVilla. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation
the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom
the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

*/
