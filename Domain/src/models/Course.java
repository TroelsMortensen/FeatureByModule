package models;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable { // TODO probably shouldn't serializable domain models. Make TOs instead at some point
    private final String code;
    private final String name;
    private final String semester;

    public Course(String code, String name, String semester) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        validate();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public void validate() {
        if (isEmpty(code)) {
            throw new IllegalArgumentException("..");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("..");
        }
        if (isEmpty(semester)) {
            throw new IllegalArgumentException("..");
        }
        // TODO: 16/11/2021 more validation
    }

    private boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return  code.equals(course.code) &&
                name.equals(course.name) &&
                semester.equals(course.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, semester);
    }
}
