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
    return "$name, age $age".replace("$name", this.name).replace("$age", String.valueOf(this.age));
  }
}
