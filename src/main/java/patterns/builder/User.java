package patterns.builder;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class User {
    private String name;
    private String surname;
    private int age;
    private LocalDate dateOfBirth;
    private boolean gender;
    private List<String> language;
    private String city;
}
