package sandbox.graphql.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private List<Book> books;
}
