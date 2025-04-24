package gr.aueb.cf.model;

import gr.aueb.cf.core.enums.LessonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    //@Column(length = 1000000)
    @Column(columnDefinition = "TEXT")
    private String comments;

    @Enumerated(EnumType.ORDINAL)   // default is ordinal
    @Column(name = "lesson_type", columnDefinition = "TINYINT COMMENT 'ΕΙΔΟΣ ΜΑΘΗΜΑΤΟΣ (1. Θεωρία, 2. Εργαστηριακό, 3. Μεικτό)'")
    private LessonType lessonType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_teachers")   // table-name + _id
//    Άμα είχα ή ήθελα να βάλω δικά μου ονόματα στα id θα γράψω κάτι τέτοιο:
//    @JoinTable(name = "courses_teachers",
//        joinColumns = @JoinColumn(name = "courses_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    )
    private Set<Teacher> teachers = new HashSet<>();


    public Set<Teacher> getAllTeachers() {
        return Collections.unmodifiableSet(teachers);
    }


    public void addTeacher(Teacher teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.getCourses().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        if (teachers == null) return;
        teachers.remove(teacher);
        teacher.getCourses().remove(this);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comments='" + comments + '\'' +
                ", lessonType=" + lessonType +
                '}';
    }
}
