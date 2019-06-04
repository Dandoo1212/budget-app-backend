package pl.com.awrsp.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.awrsp.receipt.Categories;
import pl.com.awrsp.receipt.ReceiptDTO;
import pl.com.awrsp.receipt.ReceiptService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

  private ReceiptService receiptService;

  @Autowired
  public CategoryService(ReceiptService receiptService) {
    this.receiptService = receiptService;
  }

  public SummedCategories getCategories() {
    List<ReceiptDTO> receipts = receiptService.findAll();
    List<Category> categories = createCategoriesList();
    for (ReceiptDTO receipt : receipts) {
      for (Category category : categories) {
        if (receipt.getCategory().equals(category.getCategory())) {
          category.setSumOfMoney(category.getSumOfMoney() + receipt.getMoney());
        }
      }
    }
    return new SummedCategories(categories);
  }

  private List<Category> createCategoriesList() {
    List<Category> categories = new ArrayList<>();
    categories.add(new Category(Categories.FOOD, 0));
    categories.add(new Category(Categories.BILLS, 0));
    categories.add(new Category(Categories.FUEL, 0));
    categories.add(new Category(Categories.ENTERTAIMENT, 0));
    categories.add(new Category(Categories.CLOTHING, 0));
    categories.add(new Category(Categories.MEDICAL, 0));
    categories.add(new Category(Categories.OTHER, 0));
    return categories;
  }
}
