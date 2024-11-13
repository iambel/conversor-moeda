package br.com.moedaconversor.modelo;

import java.util.Map;

public record ConversorRecord( String time_last_update_utc,String base_code,Map<String, Double> conversion_rates) {
}
