package xyz.lannt.task.application.config;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.Environment;
import reactor.bus.EventBus;
import xyz.lannt.task.application.property.DataCollectorProperty;

@Configuration
public class DataCollectorConfig {

  @Autowired
  private DataCollectorProperty property;

  @Bean
  Environment env() {
    return Environment.initializeIfEmpty().assignErrorJournal();
  }

  @Bean
  EventBus createEventBus(Environment env) {
    return EventBus.create(env, Environment.THREAD_POOL);
  }

  @Bean
  public CountDownLatch countDownLatch() {
    return new CountDownLatch(property.getSize());
  }
}
