package pl.com.awrsp.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {

    private ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository){
        this.receiptRepository=receiptRepository;
    }


    public List<Receipt> findAll(){

    }


}
