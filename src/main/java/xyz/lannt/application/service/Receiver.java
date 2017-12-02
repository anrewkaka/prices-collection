package xyz.lannt.application.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.fn.Consumer;
import xyz.lannt.domain.model.MarketSummaries;

@Service
public class Receiver implements Consumer<Event<MarketSummaries>> {

  @Autowired
  CountDownLatch latch;

  @Autowired
  private MarketSummaryService marketSummaryService;

  @Override
  public void accept(Event<MarketSummaries> event) {
    this.marketSummaryService.save(event.getData());
    latch.countDown();
  }
}
