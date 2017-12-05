package xyz.lannt;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import reactor.Environment;
import reactor.bus.EventBus;
import xyz.lannt.application.service.Publisher;
import xyz.lannt.application.service.Receiver;

@SpringBootApplication
public class PricesCollectionApplication implements CommandLineRunner {

  @Autowired
  private EventBus eventBus;

  @Autowired
  private Receiver receiver;

  @Autowired
  private Publisher publisher;

  @Override
  public void run(String... args) throws Exception {
    eventBus.on($("price-collector"), receiver);
    publisher.publish();
  }

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext app = SpringApplication.run(PricesCollectionApplication.class, args);
    app.getBean(Environment.class).shutdown();
  }
}
