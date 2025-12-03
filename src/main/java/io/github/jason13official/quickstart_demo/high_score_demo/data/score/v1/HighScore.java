package io.github.jason13official.quickstart_demo.high_score_demo.data.score.v1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/// {@link JsonTypeInfo} auto-includes the fully-qualified class path as the `class` property in deserialized JSON objects
/// ```
/// {
///     "class": "io.github.jason13official.quickstart_demo.high_score.data.score.v1.ScoreHolder"
/// }
/// ```
/// doc: <a href="https://javadoc.io/static/com.fasterxml.jackson.core/jackson-annotations/2.8.9/com/fasterxml/jackson/annotation/JsonTypeInfo.html">JsonTypeInfo Documentation</a>
@JsonTypeInfo(use= Id.CLASS, include= As.PROPERTY, property="class")
public class HighScore {

  private String username;
  private int score;

  public HighScore(String username, int score) {
    this.username = username;
    this.score = score;
  }

  public String getUsername() {
    return username;
  }

  public int getScore() {
    return score;
  }
}
