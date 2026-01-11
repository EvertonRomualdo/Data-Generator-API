package br.com.everton.datageneratorapi.configuration;

import br.com.everton.datageneratorapi.repository.CpfRepository;
import java.util.Random;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Random bean configuration.
 */
@Configuration
public class RandomConfig {

  @Bean
  public Random getRandom() {
    return new Random();
  }
}
