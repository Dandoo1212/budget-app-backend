package pl.com.awrsp.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class CategoryContoller {

  private CategoryService categoryService;

  public CategoryContoller(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/api/categories")
  public ResponseEntity<SummedCategories> findAll() {
    return new ResponseEntity<>(categoryService.getCategories(), OK);
  }
}
