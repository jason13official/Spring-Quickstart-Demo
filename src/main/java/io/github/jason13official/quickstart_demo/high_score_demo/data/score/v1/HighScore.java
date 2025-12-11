package io.github.jason13official.quickstart_demo.high_score_demo.data.score.v1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.github.jason13official.quickstart_demo.high_score_demo.data.score.AbstractHighScore;

/// {@link JsonTypeInfo} auto-includes the fully-qualified class path as the `class` property in deserialized JSON objects
/// ```
/// {
///     "class": "io.github.jason13official.quickstart_demo.high_score.data.score.v1.ScoreHolder"
/// }
/// ```
/// doc: <a href="https://javadoc.io/static/com.fasterxml.jackson.core/jackson-annotations/2.8.9/com/fasterxml/jackson/annotation/JsonTypeInfo.html">JsonTypeInfo Documentation</a>
@JsonTypeInfo(use= Id.CLASS, include= As.PROPERTY, property="class")
public final class HighScore extends AbstractHighScore {

  private final String username;

  public HighScore(String username, int score) {
    super(score);
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

//  @Override
//  public String getDisplayNames() {
//    return username;
//  }
}
