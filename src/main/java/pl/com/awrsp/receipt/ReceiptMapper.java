package pl.com.awrsp.receipt;

import java.util.List;
import java.util.stream.Collectors;

public class ReceiptMapper {

  ReceiptDTO toDto(Receipt receipt) {
    return new ReceiptDTO(receipt.getName(), receipt.getMoney(), receipt.getCategory());
  }

  Receipt toEntity(ReceiptDTO receiptDTO) {
    return new Receipt(null, receiptDTO.getName(), receiptDTO.getMoney(), receiptDTO.getCategory());
  }

  List<ReceiptDTO> toDtoList(List<Receipt> receipts) {
    return receipts.stream().map(x -> toDto(x)).collect(Collectors.toList());
  }

  List<Receipt> toEntityList(List<ReceiptDTO> receipts) {
    return receipts.stream().map(x -> toEntity(x)).collect(Collectors.toList());
  }
}
