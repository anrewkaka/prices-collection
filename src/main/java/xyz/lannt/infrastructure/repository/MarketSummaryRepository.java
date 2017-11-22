package xyz.lannt.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.lannt.infrastructure.dao.MarketSummaryDao;
import xyz.lannt.infrastructure.entity.MarketSummaryEntity;

@Repository
public class MarketSummaryRepository {

  @Autowired
  private MarketSummaryDao marketSummaryDao;

  public void save(MarketSummaryEntity marketSummaryEntity) {
    marketSummaryDao.insert(marketSummaryEntity);
  }
}
