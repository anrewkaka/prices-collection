package xyz.lannt.task.application;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.bus.EventBus;
import xyz.lannt.task.application.property.DataCollectorProperty;

@Service
public class Publisher {

  @Autowired
  DataCollectorProperty property;

  @Autowired
  EventBus eventBus;

  @Autowired
  CountDownLatch countDownLatch;

  public void publish(int number) throws InterruptedException {
    AtomicInteger counter = new AtomicInteger();
    for (int i = 0; i < number; i++) {
      Thread.sleep(property.getDelay());
      eventBus.notify("quotes", Event.wrap(counter.getAndIncrement()));
      if (property.getSize() == 999) {
        i = 0;
        number = 1;
      }
    }
  }
}
