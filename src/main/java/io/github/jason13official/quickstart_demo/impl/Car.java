package io.github.jason13official.quickstart_demo.impl;

/**
 * Used by {@link Student} to denote the make and model of their respective {@link Car} object.
 *
 * @param make a {@link String} representing the manufacturer of the {@link Car}
 * @param model a {@link String} representing the model of the {@link Car}
 */
public record Car(String make, String model) {
}
