package com.basterikus.cs_money_service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "parse")
public class ParseConfig {
    private String url;
}
