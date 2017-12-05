package xyz.lannt.domain.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import xyz.lannt.infrastructure.entity.MarketSummaryEntity;
import xyz.lannt.market.response.bittrex.BittrexMarketSummariesResponse;

@AllArgsConstructor
public class MarketSummaries {

  private List<MarketSummary> values;

  public static MarketSummaries fromResponse(BittrexMarketSummariesResponse response) {
    return response.getResult().stream().map(MarketSummary::fromResult)
        .collect(collectingAndThen(toList(), MarketSummaries::new));
  }

  public Optional<MarketSummary> find(String market) {
    return values.stream().filter(e -> StringUtils.equals(e.getName().toString(), market)).findFirst();
  }

  public MarketSummaries find(MarketNames marketNames) {
    return values.stream()
        .filter(e -> marketNames.contains(e.getName().toString()))
        .collect(collectingAndThen(toList(), MarketSummaries::new));
  }

  public MarketSummaries truncateTimestamp() {
    return values.stream()
        .peek(MarketSummary::truncateTimestamp)
        .collect(collectingAndThen(toList(), MarketSummaries::new));
  }

  public List<MarketSummaryEntity> toEntities() {
    return this.values.stream()
        .map(MarketSummary::toEntity)
        .collect(Collectors.toList());
  }

  public Stream<MarketSummary> stream() {
    return values.stream();
  }
}
