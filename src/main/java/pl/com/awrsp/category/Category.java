package pl.com.awrsp.category;

import lombok.*;
import pl.com.awrsp.receipt.Categories;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    private Categories category;
    private double sumOfMoney;

}
