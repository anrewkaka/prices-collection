package xyz.lannt.infrastructure.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface MarketSummaryDao {

  @Select
  String selectAll();
}
