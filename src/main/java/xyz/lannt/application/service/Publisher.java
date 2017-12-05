package xyz.lannt.application.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.bus.EventBus;
import xyz.lannt.application.property.DataCollectorProperty;

@Service
public class Publisher {

  @Autowired
  DataCollectorProperty property;

  @Autowired
  EventBus eventBus;

  @Autowired
  CountDownLatch countDownLatch;

  @Autowired
  private MarketSummaryService marketSummaryService;

  public void publish() throws InterruptedException {
    while(true) {
      Thread.sleep(property.getDelay());
      eventBus.notify("price-collector", Event.wrap(marketSummaryService.get()));
    }
  }
}
