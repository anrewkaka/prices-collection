package xyz.lannt.infrastructure.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.springframework.stereotype.Component;

import xyz.lannt.infrastructure.entity.MarketSummaryEntity;

@Dao
@Component
public interface MarketSummaryDao {

  @Insert
  void insert(MarketSummaryEntity entity);
}
