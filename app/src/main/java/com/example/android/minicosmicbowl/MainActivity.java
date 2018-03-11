package com.example.android.minicosmicbowl;

import android.app.Activity;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

  //String player1Name = "Enter name";
  //String player2Name = "Enter name";
  int player1Frame1 = 0;
  int player1Frame2 = 0;
  int player2Frame1 = 0;
  int player2Frame2 = 0;
  int player1Frame3 = 0;
  int player2Frame3 = 0;
  //  String player1Frame1Roll1Result = "";
//  String player1Frame1Roll2Result = "";
//  String player1Frame2Roll1Result = "";
//  String player1Frame2Roll2Result = "";
//  String player1Frame3Roll1Result = "";
//  String player1Frame3Roll2Result = "";
//  String player1Frame3Roll3Result = "";
  int player1TotalScore, player2TotalScore;
  //int previousPlayer; //, previousFrame, previousRoll;
  //int player1PreviousFrame, player2PreviousFrame;
  //int player1PreviousRoll, player2PreviousRoll;
  int currentPlayer;  //, currentFrame, currentRoll;
  int nextPlayer;
  int player1CurrentFrame, player2CurrentFrame;
  int player1CurrentRoll, player2CurrentRoll;
  int player1NextFrame, player2NextFrame;
  int player1NextRoll, player2NextRoll;

  Boolean player1BonusAllowed, player2BonusAllowed;
  String gameStatus = "Not started";

  Boolean player1Frame1Strike, player1Frame2Strike, player1Frame1Spare, player1Frame2Spare;
  Boolean player2Frame1Strike, player2Frame2Strike, player2Frame1Spare, player2Frame2Spare;
  String player1Frame1Result, player1Frame2Result, player2Frame1Result, player2Frame2Result;

  int idxPlayer1Frame1Strike, idxPlayer1Frame2Strike, idxPlayer1Frame1Spare, idxPlayer1Frame2Spare;
  int idxPlayer2Frame1Strike, idxPlayer2Frame2Strike, idxPlayer2Frame1Spare, idxPlayer2Frame2Spare;
  int idxPlayer1Frame1, idxPlayer1Frame2;
  int idxPlayer2Frame1, idxPlayer2Frame2;

  TextView tv;
  EditText et;
  Button b;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    View decorView = getWindow().getDecorView();
// Hide the status bar.
    int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
    decorView.setSystemUiVisibility(uiOptions);

    setContentView(R.layout.activity_main);

    //TextView statusText = findViewById(R.id.status_text);
    //statusText.setShadowLayer(60, 0, 0, Color.RED);

    //EditText etPlayer1 = (EditText) findViewById(R.id.p1_name);
    //etPlayer1.setBackgroundResource(R.drawable.edittext_playernames);

    //EditText etPlayer2 = findViewById(R.id.p2_name);
    //etPlayer2.setBackgroundResource(R.drawable.edittext_playernames);

    Typeface fontNovaRound = Typeface.createFromAsset(getAssets(), "fonts/nova_round.ttf");
    Typeface fontMonoton = Typeface.createFromAsset(getAssets(), "fonts/monoton_regular.ttf");
    tv = findViewById(R.id.p1_title);
    tv.setTypeface(fontNovaRound);
    et = findViewById(R.id.p1_name);
    et.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_frame1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_frame2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_frame3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f1_r1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f1_r2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f2_r1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f2_r2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f3_r1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f3_r2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f3_r3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_f3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_total_score);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_4);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_5);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_6);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_7);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_8);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_9);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_X);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_spare);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p1_miss);
    tv.setTypeface(fontNovaRound);

    tv = findViewById(R.id.p2_title);
    tv.setTypeface(fontNovaRound);
    et = findViewById(R.id.p2_name);
    et.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_frame1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_frame2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_frame3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f1_r1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f1_r2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f2_r1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f2_r2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f3_r1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f3_r2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f3_r3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_f3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_total_score);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_1);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_2);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_3);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_4);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_5);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_6);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_7);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_8);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_9);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_X);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_spare);
    tv.setTypeface(fontNovaRound);
    tv = findViewById(R.id.p2_miss);
    tv.setTypeface(fontNovaRound);

    tv = findViewById(R.id.status_text);
    tv.setTypeface(fontNovaRound);

    b = findViewById(R.id.btn_reset);
    b.setTypeface(fontNovaRound);
    b.getBackground().setColorFilter(0xFFFFFF00, Mode.CLEAR);

    b = findViewById(R.id.p1_spare);
    b.getBackground().setColorFilter(0xFFFFFF00, Mode.CLEAR);
    b = findViewById(R.id.p1_miss);
    b.getBackground().setColorFilter(0xFFFFFF00, Mode.CLEAR);
    b = findViewById(R.id.p2_spare);
    b.getBackground().setColorFilter(0xFFFFFF00, Mode.CLEAR);
    b = findViewById(R.id.p2_miss);
    b.getBackground().setColorFilter(0xFFFFFF00, Mode.CLEAR);

    tv = findViewById(R.id.app_title);
    tv.setTypeface(fontMonoton);
    
  }


  /**
   * Start / Reset Game
   */
  public void resetGame(View view) {
    player1TotalScore = player2TotalScore = 0;
    setRollScoreDisplay(1, 1, 1, "");
    setRollScoreDisplay(1, 1, 2, "");
    setRollScoreDisplay(1, 2, 1, "");
    setRollScoreDisplay(1, 2, 2, "");
    setRollScoreDisplay(1, 3, 1, "");
    setRollScoreDisplay(1, 3, 2, "");
    setRollScoreDisplay(1, 3, 3, "");
    setRollScoreDisplay(2, 1, 1, "");
    setRollScoreDisplay(2, 1, 2, "");
    setRollScoreDisplay(2, 2, 1, "");
    setRollScoreDisplay(2, 2, 2, "");
    setRollScoreDisplay(2, 3, 1, "");
    setRollScoreDisplay(2, 3, 2, "");
    setRollScoreDisplay(2, 3, 3, "");
    setFrameScore(1, 1, 0);
    setFrameScore(1, 2, 0);
    setFrameScore(1, 3, 0);
    setFrameScore(2, 1, 0);
    setFrameScore(2, 2, 0);
    setFrameScore(2, 3, 0);
    setPlayerScoreDisplay(1, 0);
    setPlayerScoreDisplay(2, 0);
    player1BonusAllowed = false;
    player2BonusAllowed = false;
    player1Frame1Strike = player1Frame2Strike = player2Frame1Strike = player2Frame2Strike = false;
    player1Frame1Spare = player1Frame2Spare = player2Frame1Spare = player2Frame2Spare = false;
    player1Frame1Result = player1Frame2Result = player2Frame1Result = player2Frame2Result = "No strike or spare";

    idxPlayer1Frame1Strike = idxPlayer1Frame2Strike = idxPlayer2Frame1Strike = idxPlayer2Frame2Strike = 0;
    idxPlayer1Frame1Spare = idxPlayer1Frame2Spare = idxPlayer2Frame1Spare = idxPlayer2Frame2Spare = 0;
    idxPlayer1Frame1 = idxPlayer1Frame2 = idxPlayer2Frame1 = idxPlayer2Frame2 = 0;

    player1Frame1 = player1Frame2 = player2Frame1 = player2Frame2 = 0;

    if (checkPlayerNames() == 0) {
      return;
    }
    setStatusText(getPlayerName(1) + " goes first. Play your first roll.");
    //previousPlayer = 1; //previousFrame = previousRoll = 1;
    currentPlayer = 1;  //currentFrame = currentRoll = 1;
    nextPlayer = 1;
//    player1PreviousFrame = player1CurrentFrame = player1CurrentFrame = player1CurrentRoll = 1;
//    player2PreviousFrame = player2CurrentFrame = player2CurrentFrame = player2CurrentRoll = 1;
    player1CurrentFrame = player1CurrentRoll = player1NextFrame = player1NextRoll = 1;
    player2CurrentFrame = player2CurrentRoll = player2NextFrame = player2NextRoll = 1;

    resetRollButtons();

    Log.i("JB", "currentPlayer: " + String.valueOf(currentPlayer));
    gameStatus = "In progress";
  }

  /**
   * Set score for roll
   */
  public void setRollScore(int player, int frame, int roll, String score) {
    String textViewId = "";

    //Get score from previous textView for 2nd roll
    String textViewIdPreviousRoll;
    int resourceIdPreviousRoll;
    TextView scoreViewPreviousRoll;
    int scoreValuePreviousRoll = 0;
    if (frame < 3 && roll == 2) {
      textViewIdPreviousRoll =
          "p" + String.valueOf(player) + "_f" + String.valueOf(frame) + "_r" + String
              .valueOf(roll - 1);
      resourceIdPreviousRoll = getResources().getIdentifier(
          textViewIdPreviousRoll,
          "id",
          getPackageName());
      scoreViewPreviousRoll = findViewById(resourceIdPreviousRoll);
      if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("-")){
        scoreValuePreviousRoll = 0;
      }
      else{
        scoreValuePreviousRoll = Integer.valueOf(String.valueOf(scoreViewPreviousRoll.getText()));
      }
    }

    int scoreValue = 0;

    if (score.contentEquals("X")) {
      scoreValue = 10;
    } else if (score.contentEquals("spare")) {
      scoreValue = 10 - scoreValuePreviousRoll;
    } else if (score.contentEquals("miss")) {
      scoreValue = 0;
    } else {
      scoreValue = Integer.valueOf(score);
    }

    if (frame < 3 && (score.contentEquals("X") || score.contentEquals("spare"))) {
      if (player == 1) {
        textViewId = "p1_f" + String.valueOf(frame) + "_r2";
      } else {
        textViewId = "p2_f" + String.valueOf(frame) + "_r2";
      }
    }
    else {
      if (player == 1) {
        textViewId = "p1_f" + String.valueOf(frame) + "_r" + String.valueOf(roll);
      }
      else {
        textViewId = "p2_f" + String.valueOf(frame) + "_r" + String.valueOf(roll);
      }
    }

    int resourceId = getResources().getIdentifier(
        textViewId,
        "id",
        getPackageName());

    TextView scoreView = findViewById(resourceId);
    if (score.contentEquals("spare")) {
      scoreView.setText("/");
    } else if (score.contentEquals("miss")) {
      scoreView.setText("-");
    } else {
      scoreView.setText(score);
    }

    //Set flags for Strikes
    if (frame < 3 && score.contentEquals("X")) {
      if (player == 1 && frame == 1) {
        //player1Frame1Strike = true;
        player1Frame1Result = "Strike";
      } else if (player == 1 && frame == 2) {
        //player1Frame2Strike = true;
        player1Frame2Result = "Strike";
      } else if (player == 2 && frame == 1) {
        //player2Frame1Strike = true;
        player2Frame1Result = "Strike";
      } else if (player == 2 && frame == 2) {
        //player2Frame2Strike = true;
        player2Frame2Result = "Strike";
      }
    }
    //Set flags for Spares
    else if (frame < 3 && score.contentEquals("spare")) {
      if (player == 1 && frame == 1) {
        //player1Frame1Spare = true;
        player1Frame1Result = "Spare";
      } else if (player == 1 && frame == 2) {
        //player1Frame2Spare = true;
        player1Frame2Result = "Spare";
      } else if (player == 2 && frame == 1) {
        //player2Frame1Spare = true;
        player2Frame1Result = "Spare";
      } else if (player == 2 && frame == 2) {
        //player2Frame2Spare = true;
        player2Frame2Result = "Spare";
      }
    }

    if (player == 1) {
      if (player1Frame1Result.contentEquals("Strike") || player1Frame1Result
          .contentEquals("Spare")) {
        idxPlayer1Frame1 += 1;
      }
      if (player1Frame2Result.contentEquals("Strike") || player1Frame2Result
          .contentEquals("Spare")) {
        idxPlayer1Frame2 += 1;
      }
    } else if (player == 2) {
      if (player2Frame1Result.contentEquals("Strike") || player2Frame1Result
          .contentEquals("Spare")) {
        idxPlayer2Frame1 += 1;
      }
      if (player2Frame2Result.contentEquals("Strike") || player2Frame2Result
          .contentEquals("Spare")) {
        idxPlayer2Frame2 += 1;
      }
    }

    //Add scores for Strikes and Spares
    if (player == 1) {
      if (player1Frame1Result.contentEquals("Strike") && idxPlayer1Frame1 <= 3) {
        player1Frame1 += scoreValue;
        if (idxPlayer1Frame1 == 1) {
          player1Frame1 = 10;
        }
        if (idxPlayer1Frame1 == 3) {
          setFrameScore(1, 1, player1Frame1);
        }
      } else if (player1Frame1Result.contentEquals("Spare") && idxPlayer1Frame1 <= 2) {
        player1Frame1 += scoreValue;
        if (idxPlayer1Frame1 == 1) {
          player1Frame1 = 10;
        }
        if (idxPlayer1Frame1 == 2) {
          setFrameScore(1, 1, player1Frame1);
        }
      }
    }
    if (player == 1) {
      if (player1Frame2Result.contentEquals("Strike") && idxPlayer1Frame2 <= 3) {
        player1Frame2 += scoreValue;
        if (idxPlayer1Frame2 == 1) {
          player1Frame2 = 10;
        }
        if (idxPlayer1Frame2 == 3) {
          //if the 2nd roll in the 3rd frame is a spare, then the score = 20 for the 2nd frame
          if(score.contentEquals("spare")){
            player1Frame2 = 20;
          }
          setFrameScore(1, 2, player1Frame2);
        }
      } else if (player1Frame2Result.contentEquals("Spare") && idxPlayer1Frame2 <= 2) {
        player1Frame2 += scoreValue;
        if (idxPlayer1Frame2 == 1) {
          player1Frame2 = 10;
        }
        if (idxPlayer1Frame2 == 2) {
          setFrameScore(1, 2, player1Frame2);
        }
      }
    }
    if (player == 2) {
      if (player2Frame1Result.contentEquals("Strike") && idxPlayer2Frame1 <= 3) {
        player2Frame1 += scoreValue;
        if (idxPlayer2Frame1 == 1) {
          player2Frame1 = 10;
        }
        if (idxPlayer2Frame1 == 3) {
          setFrameScore(2, 1, player2Frame1);
        }
      } else if (player2Frame1Result.contentEquals("Spare") && idxPlayer2Frame1 <= 2) {
        player2Frame1 += scoreValue;
        if (idxPlayer2Frame1 == 1) {
          player2Frame1 = 10;
        }
        if (idxPlayer2Frame1 == 2) {
          setFrameScore(2, 1, player2Frame1);
        }
      }
    }
    if (player == 2) {
      if (player2Frame2Result.contentEquals("Strike") && idxPlayer2Frame2 <= 3) {
        player2Frame2 += scoreValue;
        if (idxPlayer2Frame2 == 1) {
          player2Frame2 = 10;
        }
        if (idxPlayer2Frame2 == 3) {
          //if the 2nd roll in the 3rd frame is a spare, then the score = 20 for the 2nd frame
          if(score.contentEquals("spare")){
            player2Frame2 = 20;
          }
          setFrameScore(2, 2, player2Frame2);
        }
      } else if (player2Frame2Result.contentEquals("Spare") && idxPlayer2Frame2 <= 2) {
        player2Frame2 += scoreValue;
        if (idxPlayer2Frame2 == 1) {
          player2Frame2 = 10;
        }
        if (idxPlayer2Frame2 == 2) {
          setFrameScore(2, 2, player2Frame2);
        }
      }
    }

    //Add scores for regular rolls
    if (frame < 3 && roll == 2 && !score.contentEquals("spare")) {
      if (player == 1) {
        if (frame == 1) {
          player1Frame1 = scoreValue + scoreValuePreviousRoll;
          setFrameScore(player, frame, player1Frame1);
        } else if (frame == 2) {
          player1Frame2 = scoreValue + scoreValuePreviousRoll;
          setFrameScore(player, frame, player1Frame2);
        }
      }
      if (player == 2) {
        if (frame == 1) {
          player2Frame1 = scoreValue + scoreValuePreviousRoll;
          setFrameScore(player, frame, player2Frame1);
        } else if (frame == 2) {
          player2Frame2 = scoreValue + scoreValuePreviousRoll;
          setFrameScore(player, frame, player2Frame2);
        }
      }
    }

  }

  /**
   * Set score display for roll
   */
  public void setRollScoreDisplay(int player, int frame, int roll, String score) {
    String textViewId;

    textViewId =
        "p" + String.valueOf(player) + "_f" + String.valueOf(frame) + "_r" + String.valueOf(roll);

    int resourceId = getResources().getIdentifier(
        textViewId,
        "id",
        getPackageName());

    TextView scoreView = findViewById(resourceId);
    scoreView.setText(score);
  }

  /**
   * Set score display for frame
   */
  public void setFrameScore(int player, int frame, int score) {
    String textViewId = "p" + String.valueOf(player) + "_f" + String.valueOf(frame);

    int resourceId = getResources().getIdentifier(
        textViewId,
        "id",
        getPackageName());

    TextView scoreView = findViewById(resourceId);
    if (score == 0) {
      scoreView.setText("");
    } else {
      scoreView.setText(String.valueOf(score));
    }

    //Update total player score
    String textViewIdPlayer;
    int resourceIdPlayer;
    TextView scoreViewPlayer;
    int scorePlayer = 0;

    textViewIdPlayer = "p" + String.valueOf(player) + "_f1";
    resourceIdPlayer = getResources().getIdentifier(textViewIdPlayer, "id", getPackageName());
    scoreViewPlayer = findViewById(resourceIdPlayer);
    if(String.valueOf(scoreViewPlayer.getText()).contentEquals("")) {
      scorePlayer += 0;
    }
    else{
      scorePlayer +=  Integer.parseInt(String.valueOf(scoreViewPlayer.getText()));
    }

    textViewIdPlayer = "p" + String.valueOf(player) + "_f2";
    resourceIdPlayer = getResources().getIdentifier(textViewIdPlayer, "id", getPackageName());
    scoreViewPlayer = findViewById(resourceIdPlayer);
    if(String.valueOf(scoreViewPlayer.getText()).contentEquals("")) {
      scorePlayer += 0;
    }
    else{
      scorePlayer +=  Integer.parseInt(String.valueOf(scoreViewPlayer.getText()));
    }

    textViewIdPlayer = "p" + String.valueOf(player) + "_f3";
    resourceIdPlayer = getResources().getIdentifier(textViewIdPlayer, "id", getPackageName());
    scoreViewPlayer = findViewById(resourceIdPlayer);
    if(String.valueOf(scoreViewPlayer.getText()).contentEquals("")){
      scorePlayer += 0;
    }
    else{
      scorePlayer +=  Integer.parseInt(String.valueOf(scoreViewPlayer.getText()));
    }

    setPlayerScoreDisplay(player, scorePlayer);

  }

  /**
   * Set score for frame 3
   */
  public void setFrame3Score(int player) {
    String textViewId;
    int resourceId;
    TextView scoreView;
    String score1, score2, score3;
    int scoreValue1, scoreValue2, scoreValue3;

    textViewId = "p" + String.valueOf(player) + "_f3_r1";
    resourceId = getResources().getIdentifier(textViewId, "id", getPackageName());
    scoreView = findViewById(resourceId);
    score1 = String.valueOf(scoreView.getText());

    textViewId = "p" + String.valueOf(player) + "_f3_r2";
    resourceId = getResources().getIdentifier(textViewId, "id", getPackageName());
    scoreView = findViewById(resourceId);
    score2 = String.valueOf(scoreView.getText());

    textViewId = "p" + String.valueOf(player) + "_f3_r3";
    resourceId = getResources().getIdentifier(textViewId, "id", getPackageName());
    scoreView = findViewById(resourceId);
    score3 = String.valueOf(scoreView.getText());

    if(score2.contentEquals("/")){
      score1 = "-";
    }
    else if(score3.contentEquals("/")){
      score2 = "-";
    }

    //Assign scoreValues for each score and add them up
    if (score1.contentEquals("X")) {
      scoreValue1 = 10;
    } else if (score1.contentEquals("/")) {
      scoreValue1 = 10;
    } else if (score1.contentEquals("-")) {
      scoreValue1 = 0;
    } else if (score1.contentEquals("")) {
      scoreValue1 = 0;
    } else {
      scoreValue1 = Integer.valueOf(score1);
    }

    if (score2.contentEquals("X")) {
      scoreValue2 = 10;
    } else if (score2.contentEquals("/")) {
      scoreValue2 = 10;
    } else if (score2.contentEquals("-")) {
      scoreValue2 = 0;
    } else if (score2.contentEquals("")) {
      scoreValue2 = 0;
    } else {
      scoreValue2 = Integer.valueOf(score2);
    }

    if (score3.contentEquals("X")) {
      scoreValue3 = 10;
    } else if (score3.contentEquals("/")) {
      scoreValue3 = 10;
    } else if (score3.contentEquals("-")) {
      scoreValue3 = 0;
    } else if (score3.contentEquals("")) {
      scoreValue3 = 0;
    } else {
      scoreValue3 = Integer.valueOf(score3);
    }

    if(player == 1){
      player1Frame3 = scoreValue1 + scoreValue2 + scoreValue3;
      setFrameScore(1, 3, player1Frame3);
    }
    else {
      player2Frame3 = scoreValue1 + scoreValue2 + scoreValue3;
      setFrameScore(2, 3, player2Frame3);
    }

  }

  /**
   * Set score display for player
   */
  public void setPlayerScoreDisplay(int player, int score) {
    String textViewId = "p" + String.valueOf(player);

    int resourceId = getResources().getIdentifier(
        textViewId,
        "id",
        getPackageName());

    TextView scoreView = findViewById(resourceId);
    scoreView.setText(String.valueOf(score));

    String player1TextViewId, player2TextViewId;
    int player1ResourceId, player2ResourceId;
    TextView player1ScoreView, player2ScoreView;
    String player1ScoreValue, player2ScoreValue;

    player1TextViewId = "p1";
    player2TextViewId = "p2";
    player1ResourceId = getResources().getIdentifier(
        player1TextViewId,
        "id",
        getPackageName());
    player2ResourceId = getResources().getIdentifier(
        player2TextViewId,
        "id",
        getPackageName());
    player1ScoreView = findViewById(player1ResourceId);
    player2ScoreView = findViewById(player2ResourceId);
    player1ScoreValue = String.valueOf(player1ScoreView.getText());
    player2ScoreValue = String.valueOf(player2ScoreView.getText());

    if(gameStatus.contentEquals("Finished") && !player1ScoreValue.contentEquals("") && !player2ScoreValue.contentEquals("")){
      endGame();
    }

  }

  /**
   * Set status text
   */
  public void setStatusText(String statusText) {
    TextView scoreView = findViewById(R.id.status_text);
    scoreView.setText(String.valueOf(statusText));
  }

  /**
   * Get player name
   */
  public String getPlayerName(int player) {
    String textViewId = "p" + String.valueOf(player) + "_name";

    int resourceId = getResources().getIdentifier(
        textViewId,
        "id",
        getPackageName());

    TextView scoreView = findViewById(resourceId);
    return String.valueOf(scoreView.getText());
  }

  /**
   * Play roll
   */
  public void playRoll(View view) {
    if (currentPlayer == 0) {
      setStatusText("Please enter player names and hit Start / Reset before playing.");
      return;
    }

//    if (gameStatus == "Finished") {
//      setStatusText("Game over, buddy.");
//      return;
//    }

    String buttonName = getResources().getResourceEntryName(view.getId());
    int playerName = Integer.valueOf(buttonName.substring(1, 2));
    String rollScore = buttonName.substring(3);
    Log.i("JB", rollScore);
    Log.i("JB", buttonName);

    if (playerName != currentPlayer) {
      setStatusText("Not your turn, buddy. " + getPlayerName(currentPlayer) + ", please play.");
      return;
    } else {
      setStatusText(getPlayerName(currentPlayer) + " played their turn.");
    }

    //Set Roll Score Display
    if(currentPlayer == 1){
      setRollScore(currentPlayer, player1CurrentFrame, player1CurrentRoll, rollScore);
    }
    else {
      setRollScore(currentPlayer, player2CurrentFrame, player2CurrentRoll, rollScore);
    }
    //setRollScore(currentPlayer, player2CurrentFrame, player2CurrentRoll, rollScore);

    //Increment player, frame, roll
    incrementPlayerFrameRoll(rollScore);

  }

  /**
   * Check if player names are entered
   */
  public int checkPlayerNames() {
    TextView player1NameTextView = findViewById(R.id.p1_name);
    String player1Name = String.valueOf(player1NameTextView.getText());

    TextView player2NameTextView = findViewById(R.id.p2_name);
    String player2Name = String.valueOf(player2NameTextView.getText());

    if (player1Name.contentEquals("") || player2Name.contentEquals("")) {
      setStatusText("Please enter player names before playing.");
      return 0;
    } else if (player1Name.equals(player2Name)) {
      setStatusText("Please enter distinct player names.");
      return 0;
    } else {
      return 1;
    }
  }

  /**
   * Check if player names are entered
   */
  public void incrementPlayerFrameRoll(String score) {
    if (score.contentEquals("X")) {
      if (currentPlayer == 1 && player1CurrentFrame < 3) {
        nextPlayer = 2;
        player1NextFrame = player1CurrentFrame + 1;
        player1NextRoll = 1;
      } else if (currentPlayer == 2 && player2CurrentFrame < 3) {
        nextPlayer = 1;
        player2NextFrame = player2CurrentFrame + 1;
        player2NextRoll = 1;
      } else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 1) {
        nextPlayer = 2;
        player1BonusAllowed = true;
        player1NextFrame = 3;
        player1NextRoll = 2;
      } else if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 1) {
        nextPlayer = 1;
        player2BonusAllowed = true;
        player2NextFrame = 3;
        player2NextRoll = 2;
      } else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 2) {
        nextPlayer = 2;
        player1NextFrame = 3;
        player1NextRoll = 3;
      } else if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 2) {
        if (player1BonusAllowed) {
          nextPlayer = 1;
        } else {
          nextPlayer = 2;
        }
        player2NextFrame = 3;
        player2NextRoll = 3;
      } else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 3) {
        if (player2BonusAllowed) {
          nextPlayer = 2;
        }
        else {
          gameStatus = "Finished";
        }
      } else if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 3) {
        gameStatus = "Finished";
      }
    }

    if (score.contentEquals("spare")) {
      if (currentPlayer == 1 && player1CurrentFrame < 3) {
        nextPlayer = 2;
        player1NextFrame = player1CurrentFrame + 1;
        player1NextRoll = 1;
      } else if (currentPlayer == 2 && player2CurrentFrame < 3) {
        nextPlayer = 1;
        player2NextFrame = player2CurrentFrame + 1;
        player2NextRoll = 1;
      }
      else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 2) {
//        if (player2BonusAllowed) {
//          nextPlayer = 1;
//        } else {
        nextPlayer = 2;
//        }
        player1BonusAllowed = true;
        player1NextFrame = 3;
        player1NextRoll = 3;
      }
      else if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 2) {
        if (player1BonusAllowed) {
          nextPlayer = 1;
        } else {
          nextPlayer = 2;
        }
        //nextPlayer = 1;
        player2BonusAllowed = true;
        player2NextFrame = 3;
        player2NextRoll = 3;
      }
      else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 3) {
        if (player2BonusAllowed) {
          nextPlayer = 2;
        }
        else {
          gameStatus = "Finished";
        }
      }
    }

    if (!score.contentEquals("X") && !score.contentEquals("spare")) {
      if (currentPlayer == 1 && player1CurrentFrame < 3) {
        nextPlayer = 2;
        if (player1CurrentRoll == 1) {
          player1NextRoll = 2;
          player1NextFrame = player1CurrentFrame;
        } else if (player1CurrentRoll == 2) {
          player1NextRoll = 1;
          player1NextFrame = player1CurrentFrame + 1;
        }
      } else if (currentPlayer == 2 && player2CurrentFrame < 3) {
        nextPlayer = 1;
        if (player2CurrentRoll == 1) {
          player2NextRoll = 2;
          player2NextFrame = player2CurrentFrame;
        } else if (player2CurrentRoll == 2) {
          player2NextRoll = 1;
          player2NextFrame = player2CurrentFrame + 1;
        }
      } else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 1) {
        nextPlayer = 2;
        player1NextFrame = 3;
        player1NextRoll = 2;
      } else if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 1) {
        nextPlayer = 1;
        player2NextFrame = 3;
        player2NextRoll = 2;
      } else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 2) {
        nextPlayer = 2;
        if (!player1BonusAllowed) {
          player1BonusAllowed = false;
          player1NextRoll = 2;
        } else {
          player1NextRoll = 3;
        }

      }
      else if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 2) {
        //player2NextRoll = 2;
        if (player1BonusAllowed) {
          nextPlayer = 1;
        } else if(!player2BonusAllowed){
          gameStatus = "Finished";
        }
        if (!player2BonusAllowed) {
          player2BonusAllowed = false;
          player2NextRoll = 2;
        } else {
          player2NextRoll = 3;
        }
      }
      else if (currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 3) {
        if (player2BonusAllowed) {
          nextPlayer = 2;
        } else {
          gameStatus = "Finished";
        }
      }
    }

    if (currentPlayer == 2 && (player1NextFrame > player2NextFrame || (player1NextRoll == 3 && player2NextRoll == 2 && player2CurrentRoll != 2))) {
      nextPlayer = 2;
    }

    if (currentPlayer == 1 && (player2NextFrame > player1NextFrame || (player2NextRoll == 3 && player1NextRoll == 2 && player1CurrentRoll != 2))) {
      nextPlayer = 1;
    }

    if (currentPlayer == 1 && player2NextFrame == player1NextFrame && player2NextRoll == player1NextRoll && player1CurrentFrame != 3) {
      nextPlayer = 1;
    }

    if (currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 3) {
      gameStatus = "Finished";
    }

    //Calculate frame 3 scores
    if(currentPlayer == 1 && !player1BonusAllowed && player1CurrentFrame == 3 && player1CurrentRoll == 2){
      //calculate frame 3 score
      setFrame3Score(1);
    }
    else if(currentPlayer == 1 && player1BonusAllowed && player1CurrentFrame == 3 && player1CurrentRoll == 3){
      //calculate frame 3 score
      setFrame3Score(1);
    }

    if(currentPlayer == 2 && !player2BonusAllowed && player2CurrentFrame == 3 && player2CurrentRoll == 2){
      //calculate frame 3 score
      setFrame3Score(2);
    }
    else //calculate frame 3 score
      if(currentPlayer == 2 && player2BonusAllowed && player2CurrentFrame == 3 && player2CurrentRoll == 3) {
        setFrame3Score(2);
      }

    if(gameStatus.contentEquals("Finished")){
      //setStatusText("Game over");
      endGame();
      return;
    }

    if(currentPlayer == 1 && player1CurrentFrame == 3 && player1CurrentRoll == 3 & !player1BonusAllowed){
      gameStatus = "Finished";
      //setStatusText("Game over");
      endGame();
      return;
    }
    else if(currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 2 && !player1BonusAllowed && !player2BonusAllowed){
      gameStatus = "Finished";
      //setStatusText("Game over");
      endGame();
      return;
    }
    else if(currentPlayer == 2 && player2CurrentFrame == 3 && player2CurrentRoll == 3){
      gameStatus = "Finished";
      //setStatusText("Game over");
      endGame();
      return;
    }

    currentPlayer = nextPlayer;
    player1CurrentFrame = player1NextFrame;
    player1CurrentRoll = player1NextRoll;
    player2CurrentFrame = player2NextFrame;
    player2CurrentRoll = player2NextRoll;

    setStatusText(getPlayerName(nextPlayer) + ", it's your turn");

    refreshRollButtons();
  }

  /**
   * Disable / enable roll buttons based on players' turn
   */
  public void refreshRollButtons() {
    Button btnRoll;

    //Get score from previous textView for 2nd roll
    String textViewIdPreviousRoll;
    int resourceIdPreviousRoll;
    TextView scoreViewPreviousRoll;
    int scoreValuePreviousRoll;

    if(currentPlayer == 1){
      //enable player 2's panel
      enablePlayer1Panel();
    }
    else if(currentPlayer == 2){
      //enable player 2's panel
      enablePlayer2Panel();
    }

    if(currentPlayer == 1){
      if(player1CurrentRoll == 1){
        //disable spare, enable all others
        btnRoll = findViewById(R.id.p1_spare);
        btnRoll.setEnabled(false);
      }
      else if(player1CurrentFrame < 3 && player1CurrentRoll == 2){
        //disable strike, enable all others
        btnRoll = findViewById(R.id.p1_X);
        btnRoll.setEnabled(false);

        textViewIdPreviousRoll = "p1_f" + String.valueOf(player1CurrentFrame) + "_r" + String
            .valueOf(player1CurrentRoll - 1);
        resourceIdPreviousRoll = getResources().getIdentifier(
            textViewIdPreviousRoll,
            "id",
            getPackageName());
        scoreViewPreviousRoll = findViewById(resourceIdPreviousRoll);
        if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("-")){
          scoreValuePreviousRoll = 0;
        }
        else {
          Log.d("Bowl", String.valueOf(scoreViewPreviousRoll.getText()));
          scoreValuePreviousRoll = Integer.valueOf(String.valueOf(scoreViewPreviousRoll.getText()));
        }

        disableRollsButtonRoll2(1, scoreValuePreviousRoll);
      }
      else if(player1CurrentFrame == 3 && (player1CurrentRoll == 2 || player1CurrentRoll == 3)){
        //disable strike, enable all others
        btnRoll = findViewById(R.id.p1_X);
        btnRoll.setEnabled(false);

        textViewIdPreviousRoll = "";
        if(player1CurrentRoll == 2) {
          textViewIdPreviousRoll = "p1_f3_r1";
        }
        else if(player1CurrentRoll == 3) {
          textViewIdPreviousRoll = "p1_f3_r2";
        }
        resourceIdPreviousRoll = getResources().getIdentifier(
            textViewIdPreviousRoll,
            "id",
            getPackageName());
        scoreViewPreviousRoll = findViewById(resourceIdPreviousRoll);
        if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("-")){
          scoreValuePreviousRoll = 0;
        }
        else if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("/")){
          scoreValuePreviousRoll = 0;
          btnRoll = findViewById(R.id.p1_X);
          btnRoll.setEnabled(true);
          btnRoll = findViewById(R.id.p1_spare);
          btnRoll.setEnabled(false);
        }
        else if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("X")){
          scoreValuePreviousRoll = 10;
          //enable strike
          btnRoll = findViewById(R.id.p1_X);
          btnRoll.setEnabled(true);
          btnRoll = findViewById(R.id.p1_spare);
          btnRoll.setEnabled(false);
        }
        else{
          scoreValuePreviousRoll = Integer.valueOf(String.valueOf(scoreViewPreviousRoll.getText()));
        }
        disableRollsButtonRoll2(1, scoreValuePreviousRoll);
      }
    }
    else if(currentPlayer == 2){
      if(player2CurrentRoll == 1){
        //disable spare, enable all others
        btnRoll = findViewById(R.id.p2_spare);
        btnRoll.setEnabled(false);
      }
      else if(player2CurrentFrame < 3 && player2CurrentRoll == 2){
        //disable strike, enable all others
        btnRoll = findViewById(R.id.p2_X);
        btnRoll.setEnabled(false);

        textViewIdPreviousRoll =
            "p2_f" + String.valueOf(player2CurrentFrame) + "_r" + String
                .valueOf(player2CurrentRoll - 1);
        resourceIdPreviousRoll = getResources().getIdentifier(
            textViewIdPreviousRoll,
            "id",
            getPackageName());
        scoreViewPreviousRoll = findViewById(resourceIdPreviousRoll);
        if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("-")){
          scoreValuePreviousRoll = 0;
        }
        else{
          scoreValuePreviousRoll = Integer.valueOf(String.valueOf(scoreViewPreviousRoll.getText()));
        }

        disableRollsButtonRoll2(2, scoreValuePreviousRoll);
      }
      else if(player2CurrentFrame == 3 && (player2CurrentRoll == 2 || player2CurrentRoll == 3)){
        //disable strike, enable all others
        btnRoll = findViewById(R.id.p2_X);
        btnRoll.setEnabled(false);

        textViewIdPreviousRoll = "";
        if(player2CurrentRoll == 2) {
          textViewIdPreviousRoll = "p2_f3_r1";
        }
        else if(player2CurrentRoll == 3) {
          textViewIdPreviousRoll = "p2_f3_r2";
        }
        resourceIdPreviousRoll = getResources().getIdentifier(
            textViewIdPreviousRoll,
            "id",
            getPackageName());
        scoreViewPreviousRoll = findViewById(resourceIdPreviousRoll);
        if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("-")){
          scoreValuePreviousRoll = 0;
        }
        else if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("/")){
          scoreValuePreviousRoll = 0;
          btnRoll = findViewById(R.id.p2_X);
          btnRoll.setEnabled(true);
          btnRoll = findViewById(R.id.p2_spare);
          btnRoll.setEnabled(false);
        }
        else if(String.valueOf(scoreViewPreviousRoll.getText()).contentEquals("X")){
          scoreValuePreviousRoll = 10;
          //enable strike
          btnRoll = findViewById(R.id.p2_X);
          btnRoll.setEnabled(true);
          btnRoll = findViewById(R.id.p2_spare);
          btnRoll.setEnabled(false);
        }
        else{
          scoreValuePreviousRoll = Integer.valueOf(String.valueOf(scoreViewPreviousRoll.getText()));
        }
        disableRollsButtonRoll2(2, scoreValuePreviousRoll);
      }
    }
  }

  /**
   * Reset roll buttons - enable them for player 1
   */
  public void resetRollButtons() {
    enablePlayer1Panel();

    //Disable player 1 Spare button
    Button btnRoll;
    btnRoll = findViewById(R.id.p1_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);
  }

  /**
   * Enable roll buttons for player 1
   */
  public void enablePlayer1Panel() {
    Button btnRoll;

    //enable player 1 buttons
    btnRoll = findViewById(R.id.p1_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(true);
    btnRoll = findViewById(R.id.p1_miss);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(true);

    enableButton("p1_1");
    enableButton("p1_2");
    enableButton("p1_3");
    enableButton("p1_4");
    enableButton("p1_5");
    enableButton("p1_6");
    enableButton("p1_7");
    enableButton("p1_8");
    enableButton("p1_9");
    enableButton("p1_X");

    //disable player 2 buttons
    btnRoll = findViewById(R.id.p2_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);
    btnRoll = findViewById(R.id.p2_miss);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);

    disableButton("p2_1");
    disableButton("p2_2");
    disableButton("p2_3");
    disableButton("p2_4");
    disableButton("p2_5");
    disableButton("p2_6");
    disableButton("p2_7");
    disableButton("p2_8");
    disableButton("p2_9");
    disableButton("p2_X");
  }

  /**
   * Enable roll buttons for player 2
   */
  public void enablePlayer2Panel() {
    Button btnRoll;

    //enable player 2 buttons
    btnRoll = findViewById(R.id.p2_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(true);
    btnRoll = findViewById(R.id.p2_miss);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(true);

    enableButton("p2_1");
    enableButton("p2_2");
    enableButton("p2_3");
    enableButton("p2_4");
    enableButton("p2_5");
    enableButton("p2_6");
    enableButton("p2_7");
    enableButton("p2_8");
    enableButton("p2_9");
    enableButton("p2_X");

    //disable player 1 buttons
    btnRoll = findViewById(R.id.p1_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);
    btnRoll = findViewById(R.id.p1_miss);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);

    disableButton("p1_1");
    disableButton("p1_2");
    disableButton("p1_3");
    disableButton("p1_4");
    disableButton("p1_5");
    disableButton("p1_6");
    disableButton("p1_7");
    disableButton("p1_8");
    disableButton("p1_9");
    disableButton("p1_X");

  }
  /**
   * Enable specific roll button
   */
  public void enableButton(String buttonName) {
    Button btnRoll;
    int buttonId = getResources().getIdentifier(buttonName, "id", getPackageName());

    btnRoll = findViewById(buttonId);
    //make button visible
    btnRoll.setVisibility(View.VISIBLE);
    //make button enabled
    btnRoll.setEnabled(true);
    //set background image
    btnRoll.setBackground(getResources().getDrawable(R.drawable.button_rolls_enabled));
  }

  /**
   * Disable specific roll button
   */
  public void disableButton(String buttonName) {
    Button btnRoll;
    int buttonId = getResources().getIdentifier(buttonName, "id", getPackageName());

    btnRoll = findViewById(buttonId);
    //make button visible
    btnRoll.setVisibility(View.VISIBLE);
    //make button enabled
    btnRoll.setEnabled(false);
    //set background image
    btnRoll.setBackground(getResources().getDrawable(R.drawable.button_rolls_disabled));
  }

  /**
   * Disable roll buttons for 2nd roll
   */
  public void disableRollsButtonRoll2(int player, int score) {
    Button btnRoll;

    if(player == 1){
      switch (score) {
        case 1:
          disableButton("p1_9");
          break;
        case 2:
          disableButton("p1_9");
          disableButton("p1_8");
          break;
        case 3:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          break;
        case 4:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          disableButton("p1_6");
          break;
        case 5:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          disableButton("p1_6");
          disableButton("p1_5");
          break;
        case 6:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          disableButton("p1_6");
          disableButton("p1_5");
          disableButton("p1_4");
          break;
        case 7:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          disableButton("p1_6");
          disableButton("p1_5");
          disableButton("p1_4");
          disableButton("p1_3");
          break;
        case 8:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          disableButton("p1_6");
          disableButton("p1_5");
          disableButton("p1_4");
          disableButton("p1_3");
          disableButton("p1_2");
          break;
        case 9:
          disableButton("p1_9");
          disableButton("p1_8");
          disableButton("p1_7");
          disableButton("p1_6");
          disableButton("p1_5");
          disableButton("p1_4");
          disableButton("p1_3");
          disableButton("p1_2");
          disableButton("p1_1");
          break;
        default:
          break;
      }
    }
    else if(player == 2){
      switch (score){
        case 1:
          disableButton("p2_9");
          break;
        case 2:
          disableButton("p2_9");
          disableButton("p2_8");
          break;
        case 3:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          break;
        case 4:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          disableButton("p2_6");
          break;
        case 5:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          disableButton("p2_6");
          disableButton("p2_5");
          break;
        case 6:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          disableButton("p2_6");
          disableButton("p2_5");
          disableButton("p2_4");
          break;
        case 7:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          disableButton("p2_6");
          disableButton("p2_5");
          disableButton("p2_4");
          disableButton("p2_3");
          break;
        case 8:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          disableButton("p2_6");
          disableButton("p2_5");
          disableButton("p2_4");
          disableButton("p2_3");
          disableButton("p2_2");
          break;
        case 9:
          disableButton("p2_9");
          disableButton("p2_8");
          disableButton("p2_7");
          disableButton("p2_6");
          disableButton("p2_5");
          disableButton("p2_4");
          disableButton("p2_3");
          disableButton("p2_2");
          disableButton("p2_1");
          break;
        default:
          break;
      }
    }
  }


  /**
   * End game
   */
  public void endGame() {
    String gameResult = "";

    //Decide game result
    String player1TextViewId, player2TextViewId;
    int player1ResourceId, player2ResourceId;
    TextView player1ScoreView, player2ScoreView;
    int player1ScoreValue, player2ScoreValue;

    player1TextViewId = "p1";
    player2TextViewId = "p2";
    player1ResourceId = getResources().getIdentifier(
        player1TextViewId,
        "id",
        getPackageName());
    player2ResourceId = getResources().getIdentifier(
        player2TextViewId,
        "id",
        getPackageName());
    player1ScoreView = findViewById(player1ResourceId);
    player2ScoreView = findViewById(player2ResourceId);
    player1ScoreValue = Integer.valueOf(String.valueOf(player1ScoreView.getText()));
    player2ScoreValue = Integer.valueOf(String.valueOf(player2ScoreView.getText()));

    if(player1ScoreValue > player2ScoreValue){
      gameResult = getPlayerName(1) + " won!";
    }
    else if(player2ScoreValue > player1ScoreValue){
      gameResult = getPlayerName(2) + " won!";
    }
    else {
      gameResult = getPlayerName(1) + " & " + getPlayerName(2) + " tied!";
    }

    //Display game result
    setStatusText("Game over. " + gameResult);

    //Disable both panels
    Button btnRoll;

    //disable player 1 buttons
    btnRoll = findViewById(R.id.p1_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);
    btnRoll = findViewById(R.id.p1_miss);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);

    disableButton("p1_1");
    disableButton("p1_2");
    disableButton("p1_3");
    disableButton("p1_4");
    disableButton("p1_5");
    disableButton("p1_6");
    disableButton("p1_7");
    disableButton("p1_8");
    disableButton("p1_9");
    disableButton("p1_X");

    //disable player 2 buttons
    btnRoll = findViewById(R.id.p2_spare);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);
    btnRoll = findViewById(R.id.p2_miss);
    btnRoll.setVisibility(View.VISIBLE);
    btnRoll.setEnabled(false);

    disableButton("p2_1");
    disableButton("p2_2");
    disableButton("p2_3");
    disableButton("p2_4");
    disableButton("p2_5");
    disableButton("p2_6");
    disableButton("p2_7");
    disableButton("p2_8");
    disableButton("p2_9");
    disableButton("p2_X");

  }




}
