package pl.com.awrsp.receipt;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public void findAll(){
     System.out.println(receiptRepository.findAll());
    }

}
