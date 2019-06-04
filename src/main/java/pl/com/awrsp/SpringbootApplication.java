package pl.com.awrsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.com.awrsp.receipt.Categories;
import pl.com.awrsp.receipt.ReceiptDTO;
import pl.com.awrsp.receipt.ReceiptService;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, args);

        ReceiptService service = ctx.getBean(ReceiptService.class);
        service.save(new ReceiptDTO("Paragon", 20.0, Categories.BILLS));
        service.update(new ReceiptDTO("Not paragon", 25.0, Categories.CLOTHING), 1);
        System.out.println(service.findAll());
        service.delete(1L);
         System.out.println(service.findAll());
    }
}
