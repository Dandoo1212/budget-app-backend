package pl.com.awrsp.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptService {

  private ReceiptRepository receiptRepository;
  private ReceiptMapper receiptMapper;

  @Autowired
  public ReceiptService(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper) {
    this.receiptRepository = receiptRepository;
    this.receiptMapper = receiptMapper;
  }

  public List<ReceiptDTO> findAll() {
    return receiptMapper.toDtoList(receiptRepository.findAll());
  }

  public ReceiptDTO save(ReceiptDTO receiptDTO) {
    return receiptMapper.toDto(receiptRepository.save(receiptMapper.toEntity(receiptDTO)));
  }

  public boolean update(ReceiptDTO receiptDTO, long id) {
    Receipt receipt = receiptMapper.toEntity(receiptDTO);
    return receiptRepository.update(
            receipt.getName(), receipt.getMoney(), receipt.getCategory(), id)
        == 1;
  }

  public boolean delete(Long id) {
    receiptRepository.deleteById(id);
    return receiptRepository.findById(id).isPresent();
  }
}
