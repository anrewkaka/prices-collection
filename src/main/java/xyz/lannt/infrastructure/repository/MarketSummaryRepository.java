package xyz.lannt.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.lannt.infrastructure.dao.MarketSummaryDao;

@Repository
public class MarketSummaryRepository {

  @Autowired
  private MarketSummaryDao marketSummaryDao;

  public String get() {
    return marketSummaryDao.selectAll();
  }
}
