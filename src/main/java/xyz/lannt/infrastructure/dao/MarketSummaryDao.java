package xyz.lannt.infrastructure.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import xyz.lannt.infrastructure.entity.MarketSummaryEntity;

@Dao
@ConfigAutowireable
public interface MarketSummaryDao {

  @Insert
  int insert(MarketSummaryEntity entity);

  @Select
  List<MarketSummaryEntity> selectAll();
}
