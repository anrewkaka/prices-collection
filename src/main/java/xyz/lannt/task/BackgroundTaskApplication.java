package xyz.lannt.task;

import static reactor.bus.selector.Selectors.$;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import reactor.Environment;
import reactor.bus.EventBus;
import xyz.lannt.task.application.Publisher;
import xyz.lannt.task.application.Receiver;
import xyz.lannt.task.application.property.DataCollectorProperty;

@SpringBootApplication
public class BackgroundTaskApplication implements CommandLineRunner {

  @Autowired
  private DataCollectorProperty property;

  @Autowired
  private EventBus eventBus;

  @Autowired
  private Receiver receiver;

  @Autowired
  private Publisher publisher;

  @Override
  public void run(String... args) throws Exception {
    eventBus.on($("quotes"), receiver);
    publisher.publish(property.getSize());
  }

  public static void main(String[] args) throws InterruptedException {
    ApplicationContext app = SpringApplication.run(BackgroundTaskApplication.class, args);
    app.getBean(CountDownLatch.class).await(5, TimeUnit.SECONDS);
    app.getBean(Environment.class).shutdown();
  }
}
