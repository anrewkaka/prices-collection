package xyz.lannt.infrastructure.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name = "MarketSummaries")
public class MarketSummaryEntity {

  @Column(name = "MarketName")
  public String name;

  @Column(name = "Hight")
  public Double hight;

  @Column(name = "Low")
  public Double low;

  @Column(name = "Volume")
  public Double volume;

  @Column(name = "Last")
  public Double last;

  @Column(name = "BaseVolume")
  public Double baseVolume;

  @Column(name = "TimeStamp")
  public LocalDateTime timestamp;

  @Column(name = "Bid")
  public Double bid;

  @Column(name = "Ask")
  public Double ask;

  @Column(name = "OpenBuyOrders")
  public Double openBuyOrders;

  @Column(name = "OpenSellOrders")
  public Double openSellOrders;

  @Column(name = "PrevDay")
  public Double prevDay;

  @Column(name = "Created")
  public LocalDateTime created;

  @Column(name = "DisplayMarketName")
  public String displayMarketName;
}
