package pl.com.awrsp.category;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SummedCategories {
  private List<Category> categories;

}
