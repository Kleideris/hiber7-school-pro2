package gr.aueb.cf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Getter(AccessLevel.PROTECTED)
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)  // τα collection έχουν FetchType.Lazy by default, το βάλαμε εδώ για readability.
    private Set<Teacher> teachers = new HashSet<>();

    public Region(String title) {
        this.title = title;
    }

    public Set<Teacher> getAllTeachers() {
        return Collections.unmodifiableSet(teachers);
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setRegion(this);
    }

    public void removeTeacher(Teacher teacher) {
        if (teacher == null) teachers = new HashSet<>();
        teachers.remove(teacher);
        teacher.setRegion(null);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
