package io.github.jason13official.quickstart_demo.impl;

public record Person(String name, Integer age) {

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public String toPrettyString() {
    return String.format("%s, age %d", name, age);
  }
}
