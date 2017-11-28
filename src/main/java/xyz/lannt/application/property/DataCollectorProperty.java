package xyz.lannt.application.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "data-collector")
public class DataCollectorProperty {

  private int size;

  private int delay;
}
