package xyz.lannt.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class DataCollectorConfig {

  @Bean
  Environment env() {
    return Environment.initializeIfEmpty().assignErrorJournal();
  }

  @Bean
  EventBus createEventBus(Environment env) {
    return EventBus.create(env, Environment.THREAD_POOL);
  }
}
