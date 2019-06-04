package pl.com.awrsp.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class ReceiptController {

  private ReceiptService receiptService;

  @Autowired
  public ReceiptController(ReceiptService receiptService) {
    this.receiptService = receiptService;
  }

  @GetMapping("/receipts")
  public ResponseEntity<List<ReceiptDTO>> getAllReceipts() {
    return new ResponseEntity<>(receiptService.findAll(), OK);
  }

  @PostMapping("/receipts")
  public ResponseEntity<ReceiptDTO> postReceipt(@RequestBody ReceiptDTO receiptDTO) {
    return new ResponseEntity<>(receiptService.save(receiptDTO), OK);
  }

  @PutMapping("/receipt/{id}")
  public ResponseEntity<Boolean> updateReceipt(
      @RequestBody ReceiptDTO receiptDTO, @PathVariable long id) {
    return new ResponseEntity(receiptService.update(receiptDTO, id), OK);
  }

  @DeleteMapping("/receipt/{id}")
    public ResponseEntity<Boolean> deleteReceipt(@PathVariable long id){
      return new ResponseEntity<>(receiptService.delete(id), OK);
  }

}
