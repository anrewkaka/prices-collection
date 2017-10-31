package xyz.lannt.application.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class Receiver implements Consumer<Event<Integer>> {

  @Autowired
  CountDownLatch latch;

  @Override
  public void accept(Event<Integer> ev) {
    System.err.println(this.getClass().getName() + ": " + ev.getData());
    latch.countDown();
  }
}
