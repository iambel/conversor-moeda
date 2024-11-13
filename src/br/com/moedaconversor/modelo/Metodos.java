package br.com.moedaconversor.modelo;

public class Metodos {

    public void retorna_atualizacao(ConversorRecord record, String moeda, String moeda_base){
        System.out.println("-------------------");
        System.out.println("Última atualização: "+record.time_last_update_utc());
        System.out.println("Moeda base ["+record.base_code()+"]: "+ record.conversion_rates().get(moeda_base));
        System.out.println("Moeda ["+moeda+"]: "+record.conversion_rates().get(moeda));
        System.out.println("-------------------");
    }

    public void converte_moeda(ConversorRecord record, Double valor, String moeda, String moeda_base){

        Double moeda_base_busca = record.conversion_rates().get(moeda_base);
        double moeda_busca = record.conversion_rates().get(moeda);
        Double resultado = valor*moeda_busca;
        System.out.printf("%.2f",resultado);
    }
}
