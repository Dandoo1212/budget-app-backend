package pl.com.awrsp.receipt;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReceiptDTO {
  private String name;
  private double money;
  private Categories category;
}
