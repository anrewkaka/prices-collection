package xyz.lannt.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.lannt.constant.Market;
import xyz.lannt.domain.model.MarketSummaries;
import xyz.lannt.infrastructure.repository.MarketSummaryRepository;
import xyz.lannt.market.client.MarketClientFactory;
import xyz.lannt.market.response.bittrex.BittrexMarketSummariesResponse;

@Service
public class MarketSummaryService {

  @Autowired
  private MarketClientFactory marketClientFactory;

  @Autowired
  private MarketSummaryRepository marketSummaryRepository;

  public MarketSummaries get() {
    return MarketSummaries.fromResponse(
        (BittrexMarketSummariesResponse) marketClientFactory.getClient(Market.BITTREX).getMarketSummaries());
  }

  public void save(MarketSummaries marketSummaries) {
    marketSummaries.stream().forEach(e -> {
      this.marketSummaryRepository.save(e.toEntity());
    });
  }
}
