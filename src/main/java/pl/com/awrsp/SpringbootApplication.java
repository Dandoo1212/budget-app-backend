package pl.com.awrsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.com.awrsp.receipt.ReceiptService;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, args);

        ReceiptService service = ctx.getBean(ReceiptService.class);
        service.findAll();
    }
}
