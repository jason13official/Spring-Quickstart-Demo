package io.github.jason13official.quickstart_demo.impl;

import io.github.jason13official.quickstart_demo.QuickstartDemoApplication;

/**
 * Used by {@link QuickstartDemoApplication} endpoints for demonstrations of returning arrays,
 * lists, and sets.
 *
 * @param person the underlying {@link Person} object of the student, with a name and age
 * @param undergraduate whether the student has graduated
 * @param car the Student's automobile used to get to and from university
 */
public record Student(Person person, boolean undergraduate, Car car) {

}
