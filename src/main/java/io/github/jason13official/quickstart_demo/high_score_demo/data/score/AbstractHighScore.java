package io.github.jason13official.quickstart_demo.high_score_demo.data.score;

import io.github.jason13official.quickstart_demo.high_score_demo.data.score.v1.HighScore;
import io.github.jason13official.quickstart_demo.high_score_demo.data.score.v2.HighScoreV2;

public abstract sealed class AbstractHighScore permits HighScore, HighScoreV2 {

  private final int score;

  public AbstractHighScore(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }

//  public abstract String getDisplayNames();
}
