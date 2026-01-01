package io.github.jason13official.quickstart_demo.high_score_demo.data.score.v2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.github.jason13official.quickstart_demo.high_score_demo.data.score.AbstractHighScore;
import io.github.jason13official.quickstart_demo.high_score_demo.data.score.v1.HighScore;

/// An evolution on {@link HighScore}, allowing for multiple usernames to be displayed for the high score
@JsonTypeInfo(use= Id.CLASS, include= As.PROPERTY, property="class")
public final class HighScoreV2 extends AbstractHighScore {

  private String[] usernames;

  public HighScoreV2() {
    this(new String[]{"DEFAULT1", "DEFAULT2"}, 0);
  }

  public HighScoreV2(String[] usernames, int score) {
    super(score);
    this.usernames = usernames;
  }

  public String[] getUsernames() {
    return usernames;
  }

  public void setUsernames(String[] usernames) {
    this.usernames = usernames;
  }

//  @Override
//  public String getDisplayNames() {
//
//    var builder = new StringBuilder();
//
//    for (int i = 0; i < usernames.length; i++) {
//      String suffix = i == usernames.length - 1 ? "" : ", ";
//      builder.append(usernames[i]);
//      builder.append(suffix);
//    }
//
//    return builder.toString();
//  }
}
