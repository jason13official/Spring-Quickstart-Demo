package io.github.jason13official.quickstart_demo.high_score_demo.data.score;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.github.jason13official.quickstart_demo.high_score_demo.data.score.v1.HighScore;
import io.github.jason13official.quickstart_demo.high_score_demo.data.score.v2.HighScoreV2;

@JsonTypeInfo(use= Id.CLASS, include= As.PROPERTY, property="class")
public abstract sealed class AbstractHighScore permits HighScore, HighScoreV2 {

  private int score;

  public AbstractHighScore() {
    this(0);
  }

  public AbstractHighScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

//  public abstract String getDisplayNames();
}
