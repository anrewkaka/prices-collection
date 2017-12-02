package xyz.lannt.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xyz.lannt.annotation.MarketResponseName;
import xyz.lannt.domain.vo.CryptoText;
import xyz.lannt.domain.vo.CryptoTimestamp;
import xyz.lannt.domain.vo.CryptoValue;
import xyz.lannt.infrastructure.entity.MarketSummaryEntity;
import xyz.lannt.market.response.bittrex.BittrexResult;

@NoArgsConstructor
public class MarketSummary {

  @Getter
  @Setter
  private int exchangeId;

  @Getter
  @MarketResponseName("MarketName")
  private CryptoText name;

  @MarketResponseName("Hight")
  private CryptoValue hight;

  @MarketResponseName("Low")
  private CryptoValue low;

  @MarketResponseName("Volume")
  private CryptoValue volume;

  @Getter
  @MarketResponseName("Last")
  private CryptoValue last;

  @MarketResponseName("BaseVolume")
  private CryptoValue baseVolume;

  @MarketResponseName("TimeStamp")
  private CryptoTimestamp timestamp;

  @Getter
  @MarketResponseName("Bid")
  private CryptoValue bid;

  @Getter
  @MarketResponseName("Ask")
  private CryptoValue ask;

  @MarketResponseName("OpenBuyOrders")
  private CryptoValue openBuyOrders;

  @MarketResponseName("OpenSellOrders")
  private CryptoValue openSellOrders;

  @MarketResponseName("PrevDay")
  private CryptoValue prevDay;

  @MarketResponseName("Created")
  private CryptoTimestamp created;

  @MarketResponseName("DisplayMarketName")
  private CryptoText displayMarketName;

  public static MarketSummary fromResult(BittrexResult result) {
    return result.toModel(MarketSummary.class);
  }

  public MarketSummaryEntity toEntity() {
    MarketSummaryEntity entity = new MarketSummaryEntity();
    entity.exchangeId = this.exchangeId;
    entity.name = this.name.toString();
    entity.hight = this.hight.doubleValue();
    entity.low = this.low.doubleValue();
    entity.volume = this.volume.doubleValue();
    entity.last = this.last.doubleValue();
    entity.baseVolume = this.baseVolume.doubleValue();
    entity.timestamp = this.timestamp.localDatetime();
    entity.bid = this.bid.doubleValue();
    entity.ask = this.ask.doubleValue();
    entity.openBuyOrders = this.openBuyOrders.doubleValue();
    entity.openSellOrders = this.openSellOrders.doubleValue();
    entity.prevDay = this.prevDay.doubleValue();
    entity.created = this.created.localDatetime();
    entity.displayMarketName = this.displayMarketName.toString();

    return entity;
  }
}
