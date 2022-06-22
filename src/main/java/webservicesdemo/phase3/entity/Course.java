package webservicesdemo.phase3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String name;
    private String code;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Course course)) return false;
        return this.id == course.getId();
    }
}
